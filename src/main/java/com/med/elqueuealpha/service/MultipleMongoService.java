package com.med.elqueuealpha.service;

import com.med.elqueuealpha.repository.cv.DoctorCVRepository;
import com.med.elqueuealpha.repository.cv.SalaryDailyCVRepository;
import com.med.elqueuealpha.repository.kl.DoctorKLRepository;
import com.med.elqueuealpha.repository.kl.SalaryDailyKLRepository;
import com.med.elqueuealpha.repository.mg.DoctorMGRepository;
import com.med.elqueuealpha.repository.mg.SalaryDailyMGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MultipleMongoService {

    private final DoctorCVRepository doctorCVRepository;
    private final DoctorKLRepository doctorKLRepository;
    private final DoctorMGRepository doctorMGRepository;

    private final SalaryDailyCVRepository salaryDailyCVRepository;
    private final SalaryDailyKLRepository salaryDailyKLRepository;
    private final SalaryDailyMGRepository salaryDailyMGRepository;

    @Autowired
    public MultipleMongoService(DoctorCVRepository doctorCVRepository
            , DoctorKLRepository doctorKLRepository
            , DoctorMGRepository doctorMGRepository
            , SalaryDailyCVRepository salaryDailyCVRepository
            , SalaryDailyKLRepository salaryDailyKLRepository
            , SalaryDailyMGRepository salaryDailyMGRepository) {
        this.doctorCVRepository = doctorCVRepository;
        this.doctorKLRepository = doctorKLRepository;
        this.doctorMGRepository = doctorMGRepository;
        this.salaryDailyCVRepository = salaryDailyCVRepository;
        this.salaryDailyKLRepository = salaryDailyKLRepository;
        this.salaryDailyMGRepository = salaryDailyMGRepository;
    }

    //@PostConstruct
    void init(){

        System.out.println("--------------Doctor------------------");
        System.out.println(doctorCVRepository.findAll().size());
        System.out.println(doctorKLRepository.findAll().size());
        System.out.println(doctorMGRepository.findAll().size());

        System.out.println("--------------Salary------------------");
        System.out.println(salaryDailyCVRepository.findAll().size());
        System.out.println(salaryDailyKLRepository.findAll().size());
        System.out.println(salaryDailyMGRepository.findAll().size());
    }
}
