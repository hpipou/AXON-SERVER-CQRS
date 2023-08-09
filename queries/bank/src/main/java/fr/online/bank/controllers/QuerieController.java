package fr.online.bank.controllers;

import fr.online.bank.entities.Account;
import fr.online.bank.entities.GetAllAccount;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/queries/account")
public class QuerieController {

    private QueryGateway queryGateway;

    public QuerieController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/all")
    public CompletableFuture<List<Account>> getAllAccount(){
        return queryGateway.query(new GetAllAccount(), ResponseTypes.multipleInstancesOf(Account.class));
    }
}
