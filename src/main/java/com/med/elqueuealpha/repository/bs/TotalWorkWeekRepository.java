package com.med.elqueuealpha.repository.bs;

import com.med.elqueuealpha.model.total.TotalWorkWeek;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalWorkWeekRepository extends MongoRepository<TotalWorkWeek, String> {
}
