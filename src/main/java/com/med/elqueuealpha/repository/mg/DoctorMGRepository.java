package com.med.elqueuealpha.repository.mg;

import com.med.elqueuealpha.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorMGRepository extends MongoRepository<Doctor, Integer> { }
