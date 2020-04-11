package com.study.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "conference")
public class ConferenceSettings {

    private int min_days_before_conference;
    private int min_talks_per_participant;

}
