package fr.online.bank.events;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseEvent <T>{

    @TargetAggregateIdentifier
    @Getter private String id;
    public BaseEvent(String id) {
        this.id = id;
    }
}
