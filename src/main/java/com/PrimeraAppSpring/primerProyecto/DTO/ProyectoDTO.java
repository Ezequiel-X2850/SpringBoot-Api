package com.PrimeraAppSpring.primerProyecto.DTO;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoDTO implements Serializable{
  
  private Long id;
  private String nombre;
  private String descripcion;
  private Date fecha_inicio;
  private Date fecha_fin;
  private String img;
}
