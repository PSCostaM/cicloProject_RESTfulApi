package com.ciclo.Dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ParkingRequestDto {
    @NotBlank
    @NotNull
    private Long id;
}
