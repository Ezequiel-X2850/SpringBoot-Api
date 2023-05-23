package com.PrimeraAppSpring.primerProyecto.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadDTO implements Serializable{
  
  private Long id;
  private String nombre;
  private String descripcion;
  private String img;
}
