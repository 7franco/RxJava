package com.franco.tu_cv_spring_boot.tuCV.service;

import com.franco.tu_cv_spring_boot.tuCV.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CvInitializationServicesImpl implements CvInitializationServices{

    @Override
    public CvData initilizeCvData() {
        CvData cvData = new CvData();
        PersonalDetails personalDetails = getPersonalDetails();

        cvData.setPersonalDetails(personalDetails);


        //Education
        Education education = new Education();
        education.setInstitution("Universidad de Machala");
        education.setDegree("Description...");
        education.setPeriod("2010-2017");
        education.setDescription("Bacherlor of Science in computer Science");

        /* lista con  1 solo elemento inmutable
        */
        cvData.setEducations(Collections.singletonList(education));

        //Experiencia
        Experience experience = new Experience();
        experience.setCompany("");
        experience.setPeriod("");
        experience.setDescription("");

        Experience experience2 = new Experience();
        experience2.setCompany("");
        experience2.setPeriod("");
        experience2.setDescription("");

        /*cvData.setExperiences(new ArrayList<>());
        cvData.getExperiences().add(experience);
        cvData.getExperiences().add(experience2);*/
        cvData.setExperiences(List.of(experience, experience2));

        Skill skill = new Skill();
        skill.setName("Spanish");
        skill.setLevel("Avance");

        Skill skill2 = new Skill();
        skill2.setName("English");
        skill2.setLevel("Basic");

        cvData.setSkills(Arrays.asList(skill, skill2));
        return cvData;
    }

    private static PersonalDetails getPersonalDetails() {
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName("Jonathan");
        personalDetails.setLastName("Franco");
        personalDetails.setEmail("jcrfranco7@gmail.com");
        personalDetails.setPhone("+593-997761525");
        personalDetails.setAddress("Rumipamba");
        personalDetails.setCity("Quito");
        personalDetails.setProvince("Pichincha");
        personalDetails.setPostalCode("170201");
        personalDetails.setProfessionalProfile("Ingeniero de Sistema");
        return personalDetails;
    }
}
