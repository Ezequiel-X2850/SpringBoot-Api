package com.PrimeraAppSpring.primerProyecto.DTO;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO implements Serializable{
  
  private Long id;
  private String nombre;
  private String apellido;
  private String foto;
  private String descripcion;
  private List<Metodo_contactoDTO> contacto;
  private List<EducacionDTO> educacion;
  private List<Experiencia_laboralDTO> experiencia;
  private List<HabilidadDTO> skills;
  private List<ProyectoDTO> proyectos;
  
  
}
