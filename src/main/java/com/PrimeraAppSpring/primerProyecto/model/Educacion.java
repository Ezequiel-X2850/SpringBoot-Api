package com.PrimeraAppSpring.primerProyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educacion")
public class Educacion {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String institucion;
  private String titulo;
  private Date fecha_inicio;
  private Date fecha_fin;
  private String estado;
  private String descripcion;
  @Size(max=2201)
  private String img;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "persona_id", referencedColumnName = "id")
  private Persona persona;
  
}
