package com.med.elqueuealpha.repository.mg;

import com.med.elqueuealpha.model.statics.dto.general.GeneralStatisticsDTOWeekly;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkWeekMGRepository extends MongoRepository<GeneralStatisticsDTOWeekly, String> {

}
