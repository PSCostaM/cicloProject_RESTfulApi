package com.ciclo.Util;

import com.ciclo.Dto.UserRequest;
import com.ciclo.Entities.User;
import com.ciclo.exception.IncorrectReportRequestException;

public class UserValidator {
    public static boolean validateCreate(UserRequest userRequest) {
        if(userRequest.getUsername() == null || userRequest.getUsername().isEmpty() || userRequest.getUsername().isBlank()) {
            throw new IncorrectReportRequestException("El nombre de usuario no puede ser vacio o nulo");
        }
        if(userRequest.getEmail() == null || userRequest.getEmail().isEmpty() || userRequest.getEmail().isBlank()){
            throw new IncorrectReportRequestException("Debe proporcionar un email");
        }
        if(userRequest.getPassword() == null || userRequest.getPassword().isEmpty() || userRequest.getPassword().isBlank()){
            throw new IncorrectReportRequestException("La contraseña no puede ser vacia o nula");
        }
        return true;
    }
    public static boolean validateUserEmail(User user){
        if(user != null)
            throw new IncorrectReportRequestException("La existe una cuenta con ese email");
        return true;
    }
    public static boolean validateLogIn(User user){
        if(user == null)
            throw new IncorrectReportRequestException("No existe una cuenta con esos datos");
        return true;
    }
}
