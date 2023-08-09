package fr.online.bank.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand <T>{

    @TargetAggregateIdentifier
    @Getter private String id;

    public BaseCommand(String id) {
        this.id = id;
    }
}
