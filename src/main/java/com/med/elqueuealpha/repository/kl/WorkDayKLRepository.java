package com.med.elqueuealpha.repository.kl;

import com.med.elqueuealpha.model.workday.WorkDay;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkDayKLRepository extends MongoRepository<WorkDay, String> {
}
