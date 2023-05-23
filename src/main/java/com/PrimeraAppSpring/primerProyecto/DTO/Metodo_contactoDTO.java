package com.PrimeraAppSpring.primerProyecto.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metodo_contactoDTO implements Serializable{
  
  private Long id;
  private String tipo_contacto;
  private String valor_contacto;
  private String img;
}
