package com.med.elqueuealpha.repository.tertiary;

import com.med.elqueuealpha.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TertiaryRepository extends MongoRepository<Doctor, Integer> {}
