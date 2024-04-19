package com.znaji.springtransactions.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "currency")
@Component
public class CurrencyConfiguration {

    private String code;
    private String name;
    private String symbol;
    private String country;
}
