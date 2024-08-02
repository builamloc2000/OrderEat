package com.example.orderEat.application.service.serviceImpl;
import com.example.orderEat.application.service.AccountService;
import com.example.orderEat.domain.entities.Account;
import com.example.orderEat.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;



    private String[] getRoles(Account account) {
        if (account.getRole() == null) {
            return new String[]{"USER"};
        }
        return account.getRole().split(",");
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUsername(username);
        if(account.isPresent()){
            var accObj = account.get();
            return User.builder()
                    .username(accObj.getUsername())
                    .password(accObj.getPassword())
                    .roles(getRoles(accObj))
                    .build();
        }else{
            throw new UsernameNotFoundException(username);
        }
    }
}
