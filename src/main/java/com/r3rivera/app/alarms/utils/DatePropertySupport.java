package com.r3rivera.app.alarms.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DatePropertySupport extends PropertyEditorSupport{

    @Override
    public void setValue(Object value){
        if (value instanceof Long aLong){
            final long val = aLong;
            super.setValue(DateUtil.formatUTC(val, null));
        }else{
            super.setValue(null);
        }
    }
}
