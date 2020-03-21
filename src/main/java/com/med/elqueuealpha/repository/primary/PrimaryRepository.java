package com.med.elqueuealpha.repository.primary;

import com.med.elqueuealpha.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimaryRepository extends MongoRepository<Doctor, Integer> {

}
