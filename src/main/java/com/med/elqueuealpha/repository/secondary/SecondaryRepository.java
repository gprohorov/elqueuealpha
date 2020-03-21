package com.med.elqueuealpha.repository.secondary;

import com.med.elqueuealpha.repository.primary.PrimaryStudent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondaryRepository extends MongoRepository<SecondaryStudent, String> {

}
