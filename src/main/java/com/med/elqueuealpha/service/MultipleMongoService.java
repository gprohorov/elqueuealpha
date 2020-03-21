package com.med.elqueuealpha.service;

import com.med.elqueuealpha.repository.primary.PrimaryRepository;
import com.med.elqueuealpha.repository.primary.PrimaryStudent;
import com.med.elqueuealpha.repository.secondary.SecondaryRepository;
import com.med.elqueuealpha.repository.secondary.SecondaryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MultipleMongoService {

    @Autowired
    private PrimaryRepository primaryRepository;

    @Autowired
    private SecondaryRepository secondaryRepository;

    @PostConstruct
    void init(){
      //  primaryRepository.save(new PrimaryStudent("1", "john"));
       // secondaryRepository.save(new SecondaryStudent("2", "paul"));
    }

}
