package com.med.elqueuealpha.service;

import com.med.elqueuealpha.model.Doctor;
import com.med.elqueuealpha.model.SalaryDaily;
import com.med.elqueuealpha.repository.primary.PrimaryRepository;
import com.med.elqueuealpha.repository.sdcv.SdcvRepository;
import com.med.elqueuealpha.repository.secondary.SecondaryRepository;
import com.med.elqueuealpha.repository.tertiary.TertiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<String> numbersCV = primaryRepository.findAll()
                .stream().map(doctor -> doctor.getCellPhone()).collect(Collectors.toList());

         List<SalaryDaily> salaryForDoctorForToday = sdcvRepository.findAll().stream().filter(item -> item.getDate().equals(LocalDate.now()))
                .filter(item -> item.getDoctorId() == 5)
                .collect(Collectors.toList());

         //////////---------------------------------------------///////////////////

        List<Integer> listIdsCV = sdcvRepository.findAll().stream()
                .filter(item-> item.getDate().equals(LocalDate.now()))
                .mapToInt(SalaryDaily::getDoctorId).boxed()
                .collect(Collectors.toList());

        List<String>  listPhonesCV = listIdsCV.stream()
                .map(id -> primaryRepository.findById(id).get().getCellPhone() )
                .collect(Collectors.toList());  //  For CV

          List<Integer> listIdsKL = new ArrayList<>();

        List<String>  listPhonesKL = listIdsCV.stream()
                .map(id -> secondaryRepository.findById(id).get().getCellPhone() )
                .collect(Collectors.toList());  //  For CV


        listIdsKL.stream()
                .forEach(numb ->{

                    if (listPhonesCV.contains(numb)){

                        // ищем врача с таким номером
                        final Doctor doctor1 = primaryRepository.findAll().stream()
                                .filter(doctor -> doctor.getCellPhone().equals(numb))
                                .findFirst().get();
                        int id = doctor1.getId();

                        //  ищем зарплату этому врачу за СЕГОДНЯ
                        SalaryDaily salaryDaily = sdcvRepository.findByDateAndDoctorId(LocalDate.now(), id);
                        // проверить не NULL ли
                        salaryDaily.setStavka(0);
                        sdcvRepository.save(salaryDaily);
                    }

                });










    }

}
