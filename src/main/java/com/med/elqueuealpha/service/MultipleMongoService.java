package com.med.elqueuealpha.service;

import com.med.elqueuealpha.repository.primary.PrimaryRepository;
import com.med.elqueuealpha.repository.sdcv.SdcvRepository;
import com.med.elqueuealpha.repository.secondary.SecondaryRepository;
import com.med.elqueuealpha.repository.tertiary.TertiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MultipleMongoService {

    @Autowired
    private PrimaryRepository primaryRepository;

    @Autowired
    private SecondaryRepository secondaryRepository;

    @Autowired
    private TertiaryRepository tertiaryRepository;

    @Autowired
    private SdcvRepository sdcvRepository;

    @PostConstruct
    void init(){
        System.out.println("--------------------------------");
        System.out.println(primaryRepository.findAll().size());
        System.out.println(secondaryRepository.findAll().size());
        System.out.println(tertiaryRepository.findAll().size());
        System.out.println(sdcvRepository.findAll().size());

    }

}
