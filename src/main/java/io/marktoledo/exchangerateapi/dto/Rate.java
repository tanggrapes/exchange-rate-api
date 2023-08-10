package io.marktoledo.exchangerateapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Data
public class Rate {

    private boolean success;

    private boolean historical;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;

    private int timestamp;

    private String base;

    private Map<String, BigDecimal> rates;
}
