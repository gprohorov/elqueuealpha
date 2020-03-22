package com.med.elqueuealpha.repository.primary;

import com.med.elqueuealpha.model.SalaryDaily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryDailyPrimaryRepository extends MongoRepository<SalaryDaily, String> {}
