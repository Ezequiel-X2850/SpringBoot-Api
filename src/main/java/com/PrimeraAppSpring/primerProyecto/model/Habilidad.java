package com.PrimeraAppSpring.primerProyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "habilidad")
public class Habilidad {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nombre;
  private String descripcion;
  private String img;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "persona_id", referencedColumnName = "id")
  private Persona persona;
  
}
