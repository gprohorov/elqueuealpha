package com.med.elqueuealpha.repository.mg;

import com.med.elqueuealpha.model.SalaryDaily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryDailyMGRepository extends MongoRepository<SalaryDaily, String> { }
