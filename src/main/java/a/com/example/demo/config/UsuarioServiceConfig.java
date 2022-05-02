package a.com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class UsuarioServiceConfig {
    @Bean public ModelMapper modelMapper() { return new ModelMapper(); }
}
