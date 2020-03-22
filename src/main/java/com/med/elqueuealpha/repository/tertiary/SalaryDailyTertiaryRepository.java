package com.med.elqueuealpha.repository.tertiary;

import com.med.elqueuealpha.model.SalaryDaily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryDailyTertiaryRepository extends MongoRepository<SalaryDaily, String> {}
