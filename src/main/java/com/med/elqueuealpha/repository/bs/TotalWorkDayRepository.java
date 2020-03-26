package com.med.elqueuealpha.repository.bs;

import com.med.elqueuealpha.model.total.TotalWorkDay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TotalWorkDayRepository extends MongoRepository<TotalWorkDay, String> {
    TotalWorkDay findByDate(LocalDate date);
}
