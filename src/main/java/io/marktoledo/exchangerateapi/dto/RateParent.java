package io.marktoledo.exchangerateapi.dto;

import lombok.Data;

@Data
public class RateParent {
    private boolean success;

    private boolean historical;

    private String date;

    private int timestamp;

    private String base;
}
