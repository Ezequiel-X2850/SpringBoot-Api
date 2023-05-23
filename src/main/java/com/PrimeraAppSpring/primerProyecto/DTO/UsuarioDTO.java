package com.PrimeraAppSpring.primerProyecto.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable{
  
  private String nombre;
  private String password;
  
}
