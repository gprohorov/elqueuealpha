package com.med.elqueuealpha.repository.kl;

import com.med.elqueuealpha.model.SalaryDaily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SalaryDailyKLRepository extends MongoRepository<SalaryDaily, String> {
    SalaryDaily findByDateAndDoctorId(LocalDate date, int id);
}
