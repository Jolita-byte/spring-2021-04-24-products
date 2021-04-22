package com.example.spring20210418products.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "lt.sda.store.stocks")
@Data
public class ProductInitialStock {
    private int apple;
    private int orange;
    private int carrot;
    private int potato;
}
