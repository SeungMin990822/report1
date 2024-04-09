package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Enroll;
import kr.ac.hansung.cse.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EnrollController {

    @Autowired
    private EnrollService enrollService;

    @GetMapping("/enrolls")
    public String showEnrolls(Model model){
        List<Enroll> enrolls = enrollService.getAllEnrolls();
        model.addAttribute("id_enrolls", enrolls);

        return "enrolls";

    }
}
