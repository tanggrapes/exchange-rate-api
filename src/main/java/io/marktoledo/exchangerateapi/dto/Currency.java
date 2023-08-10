package io.marktoledo.exchangerateapi.dto;
import lombok.Data;

import java.util.Map;

@Data
public class Currency {

    private boolean success;

    private Map<String,String> symbols;
}