package com.PrimeraAppSpring.primerProyecto.DTO;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia_laboralDTO implements Serializable{
  
  private Long id;
  private String empresa;
  private String puesto;
  private Date fecha_inicio;
  private Date fecha_fin;
  private String descripcion;
  private String img;
}
