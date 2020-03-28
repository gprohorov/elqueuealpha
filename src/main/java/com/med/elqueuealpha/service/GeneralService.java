package com.med.elqueuealpha.service;

import com.med.elqueuealpha.model.SalaryDaily;
import com.med.elqueuealpha.repository.cv.DoctorCVRepository;
import com.med.elqueuealpha.repository.cv.SalaryDailyCVRepository;
import com.med.elqueuealpha.repository.kl.DoctorKLRepository;
import com.med.elqueuealpha.repository.kl.SalaryDailyKLRepository;
import com.med.elqueuealpha.repository.mg.DoctorMGRepository;
import com.med.elqueuealpha.repository.mg.SalaryDailyMGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralService {

    private final DoctorCVRepository doctorCVRepository;
    private final DoctorKLRepository doctorKLRepository;
    private final DoctorMGRepository doctorMGRepository;

    private final SalaryDailyCVRepository salaryDailyCVRepository;
    private final SalaryDailyKLRepository salaryDailyKLRepository;
    private final SalaryDailyMGRepository salaryDailyMGRepository;

    @Autowired
    public GeneralService(DoctorCVRepository doctorCVRepository
            , DoctorKLRepository doctorKLRepository
            , DoctorMGRepository doctorMGRepository
            , SalaryDailyCVRepository salaryDailyCVRepository
            , SalaryDailyKLRepository salaryDailyKLRepository
            , SalaryDailyMGRepository salaryDailyMGRepository
    ) {
        this.doctorCVRepository = doctorCVRepository;
        this.doctorKLRepository = doctorKLRepository;
        this.doctorMGRepository = doctorMGRepository;
        this.salaryDailyCVRepository = salaryDailyCVRepository;
        this.salaryDailyKLRepository = salaryDailyKLRepository;
        this.salaryDailyMGRepository = salaryDailyMGRepository;
    }

    void zeroingDay(){
        this.zeroingDayKL();
    }

    // list докторов id Черновцы
    List<Integer> listIdCV(){
        return salaryDailyCVRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(LocalDate.now()))
                .mapToInt(SalaryDaily::getDoctorId)
                .boxed()
                .collect(Collectors.toList());
    }

    // list телефонов докторов из id Черновцы
    List<String> listPhoneCV(){
        return this.listIdCV()
                .stream()
                .map(item -> doctorCVRepository.findById(item).get().getCellPhone())
                .collect(Collectors.toList());
    }

    // list докторов id Клишковцы
    List<Integer> listIdKL(){
        return salaryDailyKLRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(LocalDate.now()))
                .mapToInt(SalaryDaily::getDoctorId)
                .boxed()
                .collect(Collectors.toList());
    }

    // list телефонов докторов из id Клишковцы
    List<String> listPhoneKL(){
        return this.listIdKL()
                .stream()
                .map(item -> doctorKLRepository.findById(item).get().getCellPhone())
                .collect(Collectors.toList());
    }

    // обнуление если есть вторая ставка Клишковцы
    void zeroingDayKL(){
        List<String> listPhoneKL = this.listPhoneKL();
        this.listZeroingDay(listPhoneKL);
    }

    // list докторов id Мигово
    List<Integer> listIdMG(){
        return salaryDailyMGRepository.findAll()
                .stream()
                .filter(item -> item.getDate().equals(LocalDate.now()))
                .mapToInt(SalaryDaily::getDoctorId)
                .boxed()
                .collect(Collectors.toList());
    }

    // list телефонов докторов из id Мигово
    List<String> listPhoneMG(){
        return this.listIdMG()
                .stream()
                .map(item -> doctorMGRepository.findById(item).get().getCellPhone())
                .collect(Collectors.toList());
    }

    // обнуление если есть вторая ставка Мигово
    void zeroingDayMG(){
        List<String> listPhoneMG = this.listPhoneMG();
        this.listZeroingDay(listPhoneMG);
    }

    // процесс обнуление если есть вторая ставка
    void listZeroingDay(List<String> list){
        list.stream()
                .forEach( numb -> {
                            if (this.listPhoneCV().contains(numb)) {

                                //ищем врача с таким номером
                                int id = doctorCVRepository.findAll()
                                        .stream()
                                        .filter( item -> item.getCellPhone().equals(numb))
                                        .findFirst()
                                        .get()
                                        .getId();

                                // ищем зарплату этому врачу за СЕГОДНЯ
                                SalaryDaily salaryDaily = salaryDailyCVRepository.findByDateAndDoctorId(LocalDate.now(), id);
                                /*
                                SalaryDaily salaryDaily = salaryDailyCVRepository.findAll().stream()
                                .filter(item -> item.getDoctorId()==id)
                                .filter(item -> item.getDate().equals(LocalDate.now()))
                                .findFirst().orElse(null);
                                */

                                // проверка на NULL
                                if(salaryDaily != null) {
                                    salaryDaily.setStavka(0);
                                    salaryDailyCVRepository.save(salaryDaily);
                                }
                            }
                        }
                );
    }
}
