package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Information;
import kr.ac.hansung.cse.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping("/informations")
    public String showCreditSummary(Model model) {
        List<Information> creditSummary = informationService.getCreditSummary();
        model.addAttribute("creditSummary", creditSummary);

        return "informations";  // JSP 파일 이름
    }
}
