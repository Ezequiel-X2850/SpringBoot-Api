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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experiencia_laboral")
public class Experiencia_laboral {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String empresa;
  private String puesto;
  private Date fecha_inicio;
  private Date fecha_fin;
  private String descripcion;
  @Size(max=500)
  private String img;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "persona_id", referencedColumnName = "id")
  private Persona persona;
  
}
