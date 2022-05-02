package com.ciclo.Dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CicloviaRequestDto {
    @NonNull
    private String nombreCiclovia;
}
