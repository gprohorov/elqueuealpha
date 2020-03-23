package com.med.elqueuealpha.repository.mg;

import com.med.elqueuealpha.model.WorkDay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayMGRepository extends MongoRepository<WorkDay, String> {
}
