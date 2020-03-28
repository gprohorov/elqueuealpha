package com.med.elqueuealpha.service;

import com.med.elqueuealpha.model.statics.dto.general.GeneralStatisticsDTOMonthly;
import com.med.elqueuealpha.model.total.TotalWorkMonth;
import com.med.elqueuealpha.repository.bs.TotalWorkMonthRepository;
import com.med.elqueuealpha.repository.cv.WorkMonthCVRepository;
import com.med.elqueuealpha.repository.kl.WorkMonthKLRepository;
import com.med.elqueuealpha.repository.mg.WorkMonthMGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    // общая сумма за месяц
    void setTotalForMonth(int year, int month){
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


    public void start(){
        totalWorkMonthRepository.deleteAll();
        for(int i = 1; i < 3; i++) {
            this.setTotalForMonth(2020, i);
        }
    }
}
