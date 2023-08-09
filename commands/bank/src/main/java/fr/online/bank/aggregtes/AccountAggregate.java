package fr.online.bank.aggregtes;

import fr.online.bank.commands.CreateAccountCommand;
import fr.online.bank.events.CreatedAccountEvent;
import fr.online.bank.exceptions.NegativeBalanceException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String id;
    private String currency;
    private double initialBalance;

    public AccountAggregate(){
        // this is for AXON
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command){
        if(command.getInitialBalance()<0){
            throw new NegativeBalanceException("NEGATIVE BALANCE");
        }

        AggregateLifecycle.apply(new CreatedAccountEvent(
                command.getId(),
                command.getCurrency(),
                command.getInitialBalance()
        ));
    }

    @EventSourcingHandler
    public void on(CreatedAccountEvent event){
        this.id=event.getId();
        this.currency=event.getCurrency();
        this.initialBalance=event.getInitialBalance();
    }
}
