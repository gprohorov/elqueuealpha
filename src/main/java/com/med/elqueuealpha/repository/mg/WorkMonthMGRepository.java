package com.med.elqueuealpha.repository.mg;

import com.med.elqueuealpha.model.statics.dto.general.GeneralStatisticsDTOMonthly;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkMonthMGRepository
        extends MongoRepository<GeneralStatisticsDTOMonthly, String> {

}
