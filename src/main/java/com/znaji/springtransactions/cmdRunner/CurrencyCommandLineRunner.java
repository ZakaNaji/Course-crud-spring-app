package com.znaji.springtransactions.cmdRunner;

import com.znaji.springtransactions.configuration.CurrencyConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
public class CurrencyCommandLineRunner implements CommandLineRunner {

    private final CurrencyConfiguration currencyConfiguration;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Message from currency CMD" + currencyConfiguration);
    }
}
