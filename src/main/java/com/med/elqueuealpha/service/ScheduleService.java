package com.med.elqueuealpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ScheduleService {

    private final GeneralService generalService;
    private final TotalWorkDayService totalWorkDayService;

    @Autowired
    public ScheduleService(GeneralService generalService
            , TotalWorkDayService totalWorkDayService
    ) {
        this.generalService = generalService;
        this.totalWorkDayService = totalWorkDayService;
    }

    @Scheduled(cron = "0 10 19 * * *")
    void zeroingDayDoctors() {
        generalService.zeroingDay();
    }

    @Scheduled(cron = "0 20 19 * * *")
    void totalSalaryDailyGeneration() {
        totalWorkDayService.total(LocalDate.now());
    }
}
