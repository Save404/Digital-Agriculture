package com.config.converter;

import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

public class StringToBigDecimalConverter implements Converter<String, BigDecimal> {

    @Override
    public BigDecimal convert(String source) {
        return new BigDecimal(source);
    }
}
