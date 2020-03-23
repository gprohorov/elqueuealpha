package com.med.elqueuealpha.repository.sdcv;

import com.med.elqueuealpha.model.SalaryDaily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SdcvRepository extends MongoRepository<SalaryDaily, String> {
    SalaryDaily findByDateAndDoctorId(LocalDate date, int doctorId);
}
