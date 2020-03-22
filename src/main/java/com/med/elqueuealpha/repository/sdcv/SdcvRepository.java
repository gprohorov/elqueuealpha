package com.med.elqueuealpha.repository.sdcv;

import com.med.elqueuealpha.model.Doctor;
import com.med.elqueuealpha.model.SalaryDaily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SdcvRepository extends MongoRepository<SalaryDaily, String> {}
