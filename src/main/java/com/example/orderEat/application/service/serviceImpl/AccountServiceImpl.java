//package com.example.orderEat.application.service.serviceImpl;
//
//import com.example.orderEat.application.dto.AccountRegistrationDto;
//import com.example.orderEat.application.service.AccountService;
//import com.example.orderEat.domain.entities.Account;
//import com.example.orderEat.infrastructure.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountServiceImpl implements AccountService {
//
//
//    private AccountRepository accountRepository;
//
//    public AccountServiceImpl(AccountRepository accountRepository) {
//        super();
//        this.accountRepository = accountRepository;
//    }
//
//    @Override
//    public Account save(AccountRegistrationDto registrationDto) {
//        Account account = new Account(registrationDto.getName(), registrationDto.getAccount(), registrationDto.getPassword(),registrationDto.getRole());
//        return accountRepository.save(account);
//    }
//}
