package com.med.elqueuealpha.repository.secondary;

import com.med.elqueuealpha.model.SalaryDaily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryDailySecondaryRepository extends MongoRepository<SalaryDaily, String> {}
