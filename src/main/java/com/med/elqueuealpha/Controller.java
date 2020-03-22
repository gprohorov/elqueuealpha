package com.med.elqueuealpha;
import com.med.elqueuealpha.model.Doctor;
import com.med.elqueuealpha.model.SalaryDaily;
import com.med.elqueuealpha.repository.cv.DoctorCVRepository;
import com.med.elqueuealpha.repository.cv.SalaryDailyCVRepository;
import com.med.elqueuealpha.repository.kl.DoctorKLRepository;
import com.med.elqueuealpha.repository.kl.SalaryDailyKLRepository;
import com.med.elqueuealpha.repository.mg.DoctorMGRepository;
import com.med.elqueuealpha.repository.mg.SalaryDailyMGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final DoctorCVRepository doctorCVRepository;
    private final DoctorKLRepository doctorKLRepository;
    private final DoctorMGRepository doctorMGRepository;

    private final SalaryDailyCVRepository salaryDailyCVRepository;
    private final SalaryDailyKLRepository salaryDailyKLRepository;
    private final SalaryDailyMGRepository salaryDailyMGRepository;

    @Autowired
    public Controller(DoctorCVRepository doctorCVRepository
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

    @RequestMapping("/list")
    public List<Doctor> showDoctorAll(){
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.addAll(doctorCVRepository.findAll());
        doctorList.addAll(doctorKLRepository.findAll());
        doctorList.addAll(doctorMGRepository.findAll());
        return doctorList;
    }

    @RequestMapping("/listSalary")
    public List<SalaryDaily> showSalaryAll(){
        List<SalaryDaily> doctorList = new ArrayList<>();
        doctorList.addAll(salaryDailyCVRepository.findAll());
        doctorList.addAll(salaryDailyKLRepository.findAll());
        doctorList.addAll(salaryDailyMGRepository.findAll());
        return doctorList;
    }
}