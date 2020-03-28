package com.med.elqueuealpha.service;

import com.med.elqueuealpha.model.statics.dto.general.GeneralStatisticsDTOWeekly;
import com.med.elqueuealpha.model.total.TotalWorkWeek;
import com.med.elqueuealpha.repository.bs.TotalWorkWeekRepository;
import com.med.elqueuealpha.repository.cv.WorkWeekCVRepository;
import com.med.elqueuealpha.repository.kl.WorkWeekKLRepository;
import com.med.elqueuealpha.repository.mg.WorkWeekMGRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TotalWorkWeekService {
    private final TotalWorkWeekRepository totalWorkWeekRepository;
    private final WorkWeekCVRepository workWeekCVRepository;
    private final WorkWeekKLRepository workWeekKLRepository;
    private final WorkWeekMGRepository workWeekMGRepository;

    public TotalWorkWeekService(TotalWorkWeekRepository totalWorkWeekRepository
            , WorkWeekCVRepository workWeekCVRepository
            , WorkWeekKLRepository workWeekKLRepository
            , WorkWeekMGRepository workWeekMGRepository) {
        this.totalWorkWeekRepository = totalWorkWeekRepository;
        this.workWeekCVRepository = workWeekCVRepository;
        this.workWeekKLRepository = workWeekKLRepository;
        this.workWeekMGRepository = workWeekMGRepository;
    }

    // get All
    public List<TotalWorkWeek> getAll(){
        return totalWorkWeekRepository.findAll();
    }

    public void generateWeek(){
        int year = LocalDate.now().getYear();

        int lastWeek = this.getAll()
                .stream()
                .filter(item -> item.getYear() == year)
                .mapToInt(TotalWorkWeek::getWeekNumber)
                .max()
                .orElse(0);

        this.setTotalForWeek( year,lastWeek + 1);
    }

    // общая сумма за неделю
    void setTotalForWeek(int year, int week){
        GeneralStatisticsDTOWeekly dtoWeeklyCV = workWeekCVRepository.findAll()
                 .stream()
                 .filter(item -> item.getYear() == year)
                 .filter(item -> item.getWeekNumber() == week)
                 .findFirst()
                 .get();

        GeneralStatisticsDTOWeekly dtoWeeklyKL = workWeekKLRepository.findAll()
                .stream()
                .filter(item -> item.getYear() == year)
                .filter(item -> item.getWeekNumber() == week)
                .findFirst()
                .get();

        GeneralStatisticsDTOWeekly dtoWeeklyMG = workWeekMGRepository.findAll()
                .stream()
                .filter(item -> item.getYear() == year)
                .filter(item -> item.getWeekNumber() == week)
                .findFirst()
                .get();

        TotalWorkWeek totalWorkWeek = new TotalWorkWeek(
                dtoWeeklyCV.getWeek()
                , dtoWeeklyCV.getYear()
                , dtoWeeklyCV.getWeekNumber()
                , dtoWeeklyCV.getBill()
                , dtoWeeklyKL.getBill()
                , dtoWeeklyMG.getBill()
                , dtoWeeklyCV.getCash()
                , dtoWeeklyKL.getCash()
                , dtoWeeklyMG.getCash()
                , dtoWeeklyCV.getCard()
                , dtoWeeklyKL.getCard()
                , dtoWeeklyMG.getCard()
                ,dtoWeeklyCV.getBill() + dtoWeeklyKL.getBill() +
                dtoWeeklyMG.getBill() // процедур за неделю
                ,dtoWeeklyCV.getCash() + dtoWeeklyKL.getCash() +
                dtoWeeklyMG.getCash() + dtoWeeklyCV.getCard() +
                dtoWeeklyKL.getCard() + dtoWeeklyMG.getCard() // общая сумма
        );
        totalWorkWeekRepository.save(totalWorkWeek);
    }

    // заполнение базы 2020 год
    public void setStart(){
        totalWorkWeekRepository.deleteAll();

        Comparator<GeneralStatisticsDTOWeekly> comparator = Comparator.comparing(GeneralStatisticsDTOWeekly::getWeekNumber);

        GeneralStatisticsDTOWeekly week = workWeekCVRepository.findAll()
                .stream()
                .filter(item -> item.getYear() == 2020)
                .max(comparator)
                .get();

        for (int i = 0; i <= week.getWeekNumber(); i++) {
            this.setTotalForWeek(2020, i);
        }
    }

    // за все время
    public void setStartFull(){
        totalWorkWeekRepository.deleteAll();

        Comparator<GeneralStatisticsDTOWeekly> comparatorWeek = Comparator.comparing(GeneralStatisticsDTOWeekly::getWeekNumber);
        Comparator<GeneralStatisticsDTOWeekly> comparatorYear = Comparator.comparing(GeneralStatisticsDTOWeekly::getYear);

        GeneralStatisticsDTOWeekly yearCV = workWeekCVRepository.findAll()
                .stream()
                .min(comparatorYear)
                .get();
        GeneralStatisticsDTOWeekly yearKL = workWeekKLRepository.findAll()
                .stream()
                .min(comparatorYear)
                .get();
        GeneralStatisticsDTOWeekly yearMG = workWeekMGRepository.findAll()
                .stream()
                .min(comparatorYear)
                .get();

        GeneralStatisticsDTOWeekly year;

        if(yearCV.getYear() > yearKL.getYear())year = yearCV;
        else year = yearKL;
        if(year.getYear() < yearMG.getYear()) year = yearMG;

        for(int j = year.getYear(); j <= LocalDate.now().getYear();j++) {

            int finalJ = j;
            GeneralStatisticsDTOWeekly weekMax = new GeneralStatisticsDTOWeekly();
            GeneralStatisticsDTOWeekly weekMin = new GeneralStatisticsDTOWeekly();

            if(year == yearCV) {
                weekMax = workWeekCVRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .max(comparatorWeek)
                        .get();

                weekMin = workWeekCVRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .min(comparatorWeek)
                        .get();
            }
            if(year == yearKL) {
                weekMax = workWeekKLRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .max(comparatorWeek)
                        .get();

                weekMin = workWeekKLRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .min(comparatorWeek)
                        .get();
            }
            if(year == yearMG) {
                weekMax = workWeekMGRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .max(comparatorWeek)
                        .get();

                weekMin = workWeekMGRepository.findAll()
                        .stream()
                        .filter(item -> item.getYear() == finalJ)
                        .min(comparatorWeek)
                        .get();
            }

            for (int i = weekMin.getWeekNumber(); i <= weekMax.getWeekNumber(); i++) {
                this.setTotalForWeek(finalJ, i);
            }
        }
    }


}
