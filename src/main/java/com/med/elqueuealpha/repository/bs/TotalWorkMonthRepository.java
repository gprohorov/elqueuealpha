package com.med.elqueuealpha.repository.bs;

import com.med.elqueuealpha.model.total.TotalWorkMonth;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalWorkMonthRepository extends MongoRepository<TotalWorkMonth, String> {
}
