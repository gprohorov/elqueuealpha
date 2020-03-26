package com.med.elqueuealpha.repository.cv;

import com.med.elqueuealpha.model.statics.dto.general.GeneralStatisticsDTOMonthly;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkMonthCVRepository
        extends MongoRepository<GeneralStatisticsDTOMonthly, String> {

}
