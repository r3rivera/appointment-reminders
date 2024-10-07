package com.r3rivera.app.alarms.models;



import com.r3rivera.app.alarms.models.validation.ValidEnum;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AlarmEventRequest {

    @ValidEnum(enumClass=EventTypes.class)
    private String eventType;

    @NotBlank
    private String appName;

    private long timestampUtc;
    private AlarmInfo info;
}
    