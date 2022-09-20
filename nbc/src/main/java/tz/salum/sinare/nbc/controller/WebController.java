/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2022

 *  Created on 20 Sep 2022
 */
package tz.salum.sinare.nbc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tz.salum.sinare.nbc.constant.XY;
import tz.salum.sinare.nbc.model.Transaction;
import tz.salum.sinare.nbc.repository.TransactionRepository;

/**
 *
 * @author A243345
 */
@Controller
public class WebController {

    @Autowired
    public TransactionRepository repository;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView home(Model model) {
        if (model.getAttribute("transactions") != null) {
            model.addAttribute("transactions", model.getAttribute("transactions"));
        }
        return new ModelAndView("home");
    }

    @PostMapping("view-transactions/{institution}")
    public ModelAndView view(Model model, @PathVariable("institution") XY institution) {
        List<Transaction> transactions = repository.findByPartnerInstitution(institution);
        model.addAttribute("transactions", transactions);
        return new ModelAndView("redirect:/home");
    }
}
