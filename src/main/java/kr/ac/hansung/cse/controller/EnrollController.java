package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Enroll;
import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @GetMapping("/createEnroll")
    public String createEnroll(Model model) {

        model.addAttribute("enroll", new Enroll());

        return "createEnroll";
    }

    @PostMapping("/docreateEnroll")
    public String doCreateEnroll(Model model, @Valid Enroll enroll, BindingResult result) {

//        System.out.println(enroll);
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createdEnroll";
        }

//         Controller -> Service -> Dao
        enrollService.insert(enroll);

        return "enrollcreated";
    }
}
