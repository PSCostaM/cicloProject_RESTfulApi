package com.ciclo.Util;

import com.ciclo.Dto.UserRequest;
import com.ciclo.exception.IncorrectReportRequestException;

public class UserValidator {
    public static boolean validateCreate(UserRequest userRequest) {
        if(userRequest.getUsername() == null || userRequest.getUsername().isEmpty() || userRequest.getUsername().isBlank()) {
            throw new IncorrectReportRequestException("El nombre de usuario no puede ser vacio o nulo");
        }
        if(userRequest.getPassword() == null || userRequest.getPassword().isEmpty() || userRequest.getPassword().isBlank()){
            throw new IncorrectReportRequestException("La contraseña no puede ser vacia o nula");
        }
        return true;
    }
}
