package com.PrimeraAppSpring.primerProyecto.DTO;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducacionDTO implements Serializable{
  
  private Long id;
  private String institucion;
  private String titulo;
  private Date fecha_inicio_estudio;
  private String descripcion_estudio;
  private Date fecha_fin_estudio;
  private String estado;
  private String img;
}
