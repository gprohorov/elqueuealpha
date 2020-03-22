package com.med.elqueuealpha.service;

import com.med.elqueuealpha.model.TotalWorkDay;
import com.med.elqueuealpha.model.WorkDay;
import com.med.elqueuealpha.repository.bs.TotalWorkDayRepository;
import com.med.elqueuealpha.repository.cv.WorkDayCVRepository;
import com.med.elqueuealpha.repository.kl.WorkDayKLRepository;
import com.med.elqueuealpha.repository.mg.WorkDayMGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TotalWorkDayService {

    private final WorkDayCVRepository workDayCVRepository;
    private final WorkDayKLRepository workDayKLRepository;
    private final WorkDayMGRepository workDayMGRepository;
    private final TotalWorkDayRepository totalWorkDayRepository;

    @Autowired
    public TotalWorkDayService(WorkDayCVRepository workDayCVRepository
            , WorkDayKLRepository workDayKLRepository
            , WorkDayMGRepository workDayMGRepository
            , TotalWorkDayRepository totalWorkDayRepository
    ) {
        this.workDayCVRepository = workDayCVRepository;
        this.workDayKLRepository = workDayKLRepository;
        this.workDayMGRepository = workDayMGRepository;
        this.totalWorkDayRepository = totalWorkDayRepository;
    }

    // общая сумма за день
    void total(){
        final WorkDay workDayCV = workDayCVRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(LocalDate.now()))
                .findFirst().orElse(null);
        final WorkDay workDayKL = workDayKLRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(LocalDate.now()))
                .findFirst().orElse(null);
        final WorkDay workDayMG = workDayMGRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(LocalDate.now()))
                .findFirst().orElse(null);
        TotalWorkDay totalWorkDay = new TotalWorkDay(LocalDate.now()
                , workDayCV.getSumForExecutedProcedures()
                , workDayKL.getSumForExecutedProcedures()
                , workDayMG.getSumForExecutedProcedures()
                , workDayCV.getCash()
                , workDayKL.getCash()
                ,workDayMG.getCash()
                );
        totalWorkDayRepository.save(totalWorkDay);
    }
}
