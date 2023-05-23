package com.PrimeraAppSpring.primerProyecto.security;

import lombok.Data;

@Data
public class AuthCredentials {
  //Esta clase recibe tanto el email como el password
  
  private String email;
  private String password;
}
