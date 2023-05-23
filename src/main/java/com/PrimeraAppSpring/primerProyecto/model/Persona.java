package com.PrimeraAppSpring.primerProyecto.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @NotNull
  @NotBlank
  private String nombre;
  @NotNull
  @NotBlank
  private String apellido;
  
  @Size(max = 500)
  private String descripcion;
  @Size(max = 500)
  private String foto;
  
  @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
  private Usuario usuario;

  @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Metodo_contacto> contacto = new ArrayList<>();

  @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Educacion> educacion = new ArrayList<>();

  @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Experiencia_laboral> experiencia = new ArrayList<>();

  @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Habilidad> skills = new ArrayList<>();

  @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Proyecto> proyectos = new ArrayList<>();
}
