package com.med.elqueuealpha.service;

import com.med.elqueuealpha.model.statics.dto.general.GeneralStatisticsDTOWeekly;
import com.med.elqueuealpha.model.total.TotalWorkWeek;
import com.med.elqueuealpha.repository.bs.TotalWorkWeekRepository;
import com.med.elqueuealpha.repository.cv.WorkWeekCVRepository;
import com.med.elqueuealpha.repository.kl.WorkWeekKLRepository;
import com.med.elqueuealpha.repository.mg.WorkWeekMGRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

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

    public void start(){
        totalWorkWeekRepository.deleteAll();
        for (int i = 0; i < 12; i++) {
            this.setTotalForWeek(2020, i);
        }
    }


}
