package fr.online.bank.events;

import lombok.Getter;

public class CreatedAccountEvent extends BaseEvent<String>{

    @Getter private String currency;
    @Getter private double initialBalance;

    public CreatedAccountEvent(String id, String currency, double initialBalance) {
        super(id);
        this.currency = currency;
        this.initialBalance = initialBalance;
    }
}
