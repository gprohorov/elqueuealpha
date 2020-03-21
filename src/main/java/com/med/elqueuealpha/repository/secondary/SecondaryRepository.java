package com.med.elqueuealpha.repository.secondary;

import com.med.elqueuealpha.model.Doctor;
import com.med.elqueuealpha.model.SecondaryStudent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondaryRepository extends MongoRepository<Doctor, Integer> {

}
