package fr.online.bank.services;

import fr.online.bank.entities.Account;
import fr.online.bank.entities.GetAllAccount;
import fr.online.bank.events.CreatedAccountEvent;
import fr.online.bank.repository.AccountRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @EventHandler
    public void on(CreatedAccountEvent event){

        Account account = new Account();
        account.setId(event.getId());
        account.setCurrency(event.getCurrency());
        account.setBalance(event.getInitialBalance());

        accountRepository.save(account);
    }

    @QueryHandler
    public List<Account> GetAllAccount(GetAllAccount query){
        return accountRepository.findAll();
    }
}
