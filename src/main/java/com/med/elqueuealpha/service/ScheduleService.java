package com.med.elqueuealpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ScheduleService {

    private final GeneralService generalService;
    private final TotalWorkDayService totalWorkDayService;
    private final TotalWorkMonthService totalWorkMonthService;
    private final TotalWorkWeekService totalWorkWeekService;

    @Autowired
    public ScheduleService(GeneralService generalService
            , TotalWorkDayService totalWorkDayService,
                           TotalWorkMonthService totalWorkMonthService, TotalWorkWeekService totalWorkWeekService) {
        this.generalService = generalService;
        this.totalWorkDayService = totalWorkDayService;
        this.totalWorkMonthService = totalWorkMonthService;
        this.totalWorkWeekService = totalWorkWeekService;
    }

    // zeroing day kl
    @Scheduled(cron = "0 10 19 * * *")
    void zeroingDayDoctors() {
        generalService.zeroingDay();
    }

    // day
    @Scheduled(cron = "0 20 19 * * *")
    void totalSalaryDailyGeneration() {
        totalWorkDayService.setTotalForDay(LocalDate.now());
    }

    // week
    @Scheduled(cron = "0 45 19 * * SAT")
    void setTotalWorkWeek(){
        totalWorkWeekService.generateWeek();
    }

    // month
    @Scheduled(cron = "0 10 1 1 * *")
    void setTotalWorkMonth(){
        totalWorkMonthService.generateMonth();
    }
}
