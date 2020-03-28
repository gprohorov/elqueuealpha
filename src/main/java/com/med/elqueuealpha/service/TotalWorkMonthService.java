package com.med.elqueuealpha.service;

import com.med.elqueuealpha.model.statics.dto.general.GeneralStatisticsDTOMonthly;
import com.med.elqueuealpha.model.total.TotalWorkMonth;
import com.med.elqueuealpha.repository.bs.TotalWorkMonthRepository;
import com.med.elqueuealpha.repository.cv.WorkMonthCVRepository;
import com.med.elqueuealpha.repository.kl.WorkMonthKLRepository;
import com.med.elqueuealpha.repository.mg.WorkMonthMGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;


@Service
public class TotalWorkMonthService {

    private final TotalWorkMonthRepository totalWorkMonthRepository;
    private final WorkMonthCVRepository workMonthCVRepository;
    private final WorkMonthKLRepository workMonthKLRepository;
    private final WorkMonthMGRepository workMonthMGRepository;

    @Autowired
    public TotalWorkMonthService(TotalWorkMonthRepository totalWorkMonthRepository
            , WorkMonthCVRepository workMonthCVRepository
            , WorkMonthKLRepository workMonthKLRepository
            , WorkMonthMGRepository workMonthMGRepository) {
        this.totalWorkMonthRepository = totalWorkMonthRepository;
        this.workMonthCVRepository = workMonthCVRepository;
        this.workMonthKLRepository = workMonthKLRepository;
        this.workMonthMGRepository = workMonthMGRepository;
    }

    // get All
    public List<TotalWorkMonth> getAll(){
        return totalWorkMonthRepository.findAll();
    }

    // создание нового месяца
    public void generateMonth(){
        int year = LocalDate.now().getYear();

        int month = LocalDate.now().getMonthValue() -1 ;
        if(LocalDate.now().getMonth().equals(Month.JANUARY)){
            year-=1;
            month=12;
        }

        this.createTotalForMonth(year, month);
    }

    // общая сумма за месяц
    void createTotalForMonth(int year, int month){
        GeneralStatisticsDTOMonthly dtoMonthliesCV = workMonthCVRepository.findAll()
                .stream()
                .filter(item -> item.getYear() == year)
                .filter(item -> item.getMonthNumber() == month)
                .findFirst()
                .get();

       GeneralStatisticsDTOMonthly dtoMonthliesKL = workMonthKLRepository.findAll()
               .stream()
               .filter(item -> item.getYear() == year)
               .filter(item -> item.getMonthNumber() == month)
               .findFirst()
               .get();

        GeneralStatisticsDTOMonthly dtoMonthliesMG = workMonthMGRepository.findAll()
                .stream()
                .filter(item -> item.getYear() == year)
                .filter(item -> item.getMonthNumber() == month)
                .findFirst()
                .get();


        TotalWorkMonth totalCash = new TotalWorkMonth(
                dtoMonthliesCV.getMonth()
                , dtoMonthliesCV.getYear()
                , dtoMonthliesCV.getMonthNumber()
                , dtoMonthliesCV.getBill()
                , dtoMonthliesKL.getBill()
                , dtoMonthliesMG.getBill()
                , dtoMonthliesCV.getCash()
                , dtoMonthliesKL.getCash()
                , dtoMonthliesMG.getCash()
                , dtoMonthliesCV.getCard()
                , dtoMonthliesKL.getCard()
                , dtoMonthliesMG.getCard()
                , dtoMonthliesCV.getBill() + dtoMonthliesKL.getBill() +
                dtoMonthliesMG.getBill()
                , dtoMonthliesCV.getCash() + dtoMonthliesKL.getCash() +
                dtoMonthliesMG.getCash() + dtoMonthliesCV.getCard() +
                dtoMonthliesKL.getCard() + dtoMonthliesMG.getCard()
        );
        totalWorkMonthRepository.save(totalCash);
    }

    // заполнение базы 2020 год
    public void setStart(){
        totalWorkMonthRepository.deleteAll();

        Comparator<GeneralStatisticsDTOMonthly> comparator = Comparator.comparing(GeneralStatisticsDTOMonthly::getMonthNumber);

        GeneralStatisticsDTOMonthly month = workMonthCVRepository.findAll()
                .stream()
                .filter(item -> item.getYear() == 2020)
                .max(comparator)
                .get();

        for(int i = 1; i <= month.getMonthNumber(); i++) {
            this.createTotalForMonth(2020, i);
        }
    }

    // за все время
    public void setStartFull(){
        totalWorkMonthRepository.deleteAll();

        Comparator<GeneralStatisticsDTOMonthly> comparatorMonth = Comparator.comparing(GeneralStatisticsDTOMonthly::getMonthNumber);
        Comparator<GeneralStatisticsDTOMonthly> comparatorYear = Comparator.comparing(GeneralStatisticsDTOMonthly::getYear);

        GeneralStatisticsDTOMonthly yearCV = workMonthCVRepository.findAll()
                .stream()
                .min(comparatorYear)
                .get();
        GeneralStatisticsDTOMonthly yearKL = workMonthKLRepository.findAll()
                .stream()
                .min(comparatorYear)
                .get();
        GeneralStatisticsDTOMonthly yearMG = workMonthMGRepository.findAll()
                .stream()
                .min(comparatorYear)
                .get();

        GeneralStatisticsDTOMonthly year;

        if(yearCV.getYear() > yearKL.getYear())year = yearCV;
        else year = yearKL;
        if(year.getYear() < yearMG.getYear()) year = yearMG;

        for (int j = year.getYear(); j <= LocalDate.now().getYear(); j++) {
            int finalJ = j;

            GeneralStatisticsDTOMonthly monthMax = new GeneralStatisticsDTOMonthly();
            GeneralStatisticsDTOMonthly monthMin = new GeneralStatisticsDTOMonthly();

            if(year == yearCV) {
                monthMax = workMonthCVRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .max(comparatorMonth)
                        .get();


                monthMin = workMonthCVRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .min(comparatorMonth)
                        .get();
            }
            if(year == yearKL) {
                monthMax = workMonthKLRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .max(comparatorMonth)
                        .get();


                monthMin = workMonthKLRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .min(comparatorMonth)
                        .get();
            }
            if(year == yearMG) {
                monthMax = workMonthMGRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .max(comparatorMonth)
                        .get();

                monthMin = workMonthMGRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .min(comparatorMonth)
                        .get();
            }

            for (int i = monthMin.getMonthNumber(); i <= monthMax.getMonthNumber(); i++) {
                this.createTotalForMonth(finalJ, i);
            }
        }
    }
}
