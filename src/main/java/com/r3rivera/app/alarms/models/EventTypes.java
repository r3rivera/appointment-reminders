package com.r3rivera.app.alarms.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EventTypes {

    SENT("TransactionalSendEvents.SmsSent"),
    NOT_SENT("TransactionalSendEvents.SmsNotSent"),
    BOUNCED("TransactionalSendEvents.SmsBounced"),
    DELIVERED("TransactionalSendEvents.SmsDelivered");
    
    private final String type;
    
    
    EventTypes(final String type){
        this.type = type;
    }

    @JsonValue
    public String getType(){
        return this.type;
    }

    @JsonCreator
    public static EventTypes fromValue(String value){
        EventTypes type = null;
        for (EventTypes eventTypes : EventTypes.values()){
            if (eventTypes.getType().equals(value)){
                type = eventTypes;
                break;
            }
        }

        if(type == null){
            throw new IllegalArgumentException("Not valid type");
        }
        return type;
    }

    @Override
    public String toString(){
        return this.type;
    }
}
