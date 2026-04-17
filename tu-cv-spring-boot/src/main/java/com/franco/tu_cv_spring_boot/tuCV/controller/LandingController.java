package com.franco.tu_cv_spring_boot.tuCV.controller;

import com.franco.tu_cv_spring_boot.tuCV.model.CvData;
import com.franco.tu_cv_spring_boot.tuCV.service.CvInitializationServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LandingController {

    private final CvInitializationServices cvInitializationServices;

    @GetMapping("/cv-form")
    public String showFormCV(Model model){
        CvData cvData = cvInitializationServices.initilizeCvData();
        model.addAttribute("cvData", cvData);
        return "cv-form";
    }

    @PostMapping("/generate-cv")
    public String generateCv(@ModelAttribute CvData cvData, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("cvData", cvData);
        return "redirect:cv-display";
    }

    @GetMapping("/cv-display")
    public String displayCv(@ModelAttribute("cvData") CvData cvData, Model model){
        if(cvData.getPersonalDetails() == null){
            cvData = cvInitializationServices.initilizeCvData();
        }
        model.addAttribute("cvData", cvData);
        return "index";
    }


}
