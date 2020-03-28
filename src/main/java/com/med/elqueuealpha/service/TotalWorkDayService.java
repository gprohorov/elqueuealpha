package com.med.elqueuealpha.service;

import com.med.elqueuealpha.model.total.TotalWorkDay;
import com.med.elqueuealpha.model.workday.WorkDay;
import com.med.elqueuealpha.repository.bs.TotalWorkDayRepository;
import com.med.elqueuealpha.repository.cv.WorkDayCVRepository;
import com.med.elqueuealpha.repository.kl.WorkDayKLRepository;
import com.med.elqueuealpha.repository.mg.WorkDayMGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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

    // get All
    public List<TotalWorkDay> getAll(){
        return totalWorkDayRepository.findAll();
    }

    //данные по дате
    public TotalWorkDay getDate(LocalDate date){
        return totalWorkDayRepository.findByDate(date);
    }

    // общая сумма за день
    void setTotalForDay(LocalDate date){
        final WorkDay workDayCV = workDayCVRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(date))
                .findFirst().orElse(null);

        final WorkDay workDayKL = workDayKLRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(date))
                .findFirst().orElse(null);

        final WorkDay workDayMG = workDayMGRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(date))
                .findFirst().orElse(null);

        long totalProcedure = workDayCV.getSumForExecutedProcedures() +
                workDayKL.getSumForExecutedProcedures() +
                workDayMG.getSumForExecutedProcedures();

        long totalCashCard = workDayCV.getCash() + workDayKL.getCash() +
                workDayMG.getCash() + workDayCV.getCard() + workDayKL.getCard() +
                workDayMG.getCard();

        TotalWorkDay totalWorkDay = new TotalWorkDay(
                date
                , workDayCV.getSumForExecutedProcedures()
                , workDayKL.getSumForExecutedProcedures()
                , workDayMG.getSumForExecutedProcedures()
                , workDayCV.getCash()
                , workDayKL.getCash()
                , workDayMG.getCash()
                , workDayCV.getCard()
                , workDayKL.getCard()
                , workDayMG.getCard()
                , totalProcedure
                , totalCashCard
                );

        totalWorkDayRepository.save(totalWorkDay);
    }

    // заполнение базы с 1 января 2020 по текущий день, только 1 раз
    public void setStart(){
        totalWorkDayRepository.deleteAll();
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 1);
        int num = 0;
        while(!date.plusDays(num).equals(LocalDate.now())){
            this.setTotalForDay(date.plusDays(num));
            num++;
        }
    }

}
