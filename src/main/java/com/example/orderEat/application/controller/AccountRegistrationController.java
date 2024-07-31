//package com.example.orderEat.application.controller;
//
//
//import com.example.orderEat.application.dto.AccountRegistrationDto;
//import com.example.orderEat.application.service.AccountService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/registration")
//public class AccountRegistrationController {
//    private AccountService accountService;
//
//    public AccountRegistrationController(AccountService accountService) {
//        super();
//        this.accountService = accountService;
//    }
//    @ModelAttribute("account")
//    public AccountRegistrationDto accountRegistrationDto(){
//        return new AccountRegistrationDto();
//    }
//
//    @GetMapping
//    public String showRegistrationForm(Model model){
//        model.addAttribute("account", new AccountRegistrationDto());
//        return "registration";
//    }
//    @PostMapping
//    public String registerAccount(@ModelAttribute("account")AccountRegistrationDto accountRegistrationDto){
//        accountService.save(accountRegistrationDto);
//        return "redirect:/registration?success";
//    }
//}
