package com.PrimeraAppSpring.primerProyecto.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @NotNull
  @NotBlank
  private String nombre;
  
  @Email
  private String email;
  
  @NotBlank
  @Size(min=8, message="La contraseña debe tener un minimo de 8 caracteres")
  private String password;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "persona_id", referencedColumnName = "id")
  private Persona persona;
  
}
