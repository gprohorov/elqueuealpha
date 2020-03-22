package com.med.elqueuealpha.repository.kl;

import com.med.elqueuealpha.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorKLRepository extends MongoRepository<Doctor, Integer> { }
