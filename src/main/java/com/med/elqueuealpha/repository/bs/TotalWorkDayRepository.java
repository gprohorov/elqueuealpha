package com.med.elqueuealpha.repository.bs;

import com.med.elqueuealpha.model.TotalWorkDay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalWorkDayRepository extends MongoRepository<TotalWorkDay, String> {
}
