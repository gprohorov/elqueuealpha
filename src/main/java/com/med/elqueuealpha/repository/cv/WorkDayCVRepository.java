package com.med.elqueuealpha.repository.cv;

import com.med.elqueuealpha.model.workday.WorkDay;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkDayCVRepository extends MongoRepository<WorkDay, String> {
}
