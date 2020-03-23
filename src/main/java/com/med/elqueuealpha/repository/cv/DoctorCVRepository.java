package com.med.elqueuealpha.repository.cv;

import com.med.elqueuealpha.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorCVRepository extends MongoRepository<Doctor, Integer> {

}
