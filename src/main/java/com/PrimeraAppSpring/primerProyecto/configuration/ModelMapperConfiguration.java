package com.PrimeraAppSpring.primerProyecto.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
  
  @Bean
  public ModelMapper modelMapper(){
    final ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setSkipNullEnabled(true);
    
    return mapper;
  }
}
