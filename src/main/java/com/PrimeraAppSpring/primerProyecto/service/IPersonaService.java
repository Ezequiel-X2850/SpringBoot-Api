package com.PrimeraAppSpring.primerProyecto.service;

import com.PrimeraAppSpring.primerProyecto.DTO.EducacionDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.Experiencia_laboralDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.HabilidadDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.Metodo_contactoDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.PersonaDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.ProyectoDTO;
import com.PrimeraAppSpring.primerProyecto.model.Persona;
import java.util.List;


public interface IPersonaService {
  
  public List<Persona> verPersonas();
  public void crearPersona(PersonaDTO per);
  public void borrarPersona(Long id);
  public Persona buscarPersona(Long id);
  public void actualizarPersona(PersonaDTO persona);
  public void crearContacto(Metodo_contactoDTO contacto);
  public void actualizarContacto(Metodo_contactoDTO contacto);
  public void eliminarContacto(Long id);
  public void crearEstudio(EducacionDTO edu);
  public void actualizarEstudio(EducacionDTO edu);
  public void eliminarEstudio(Long id);
  public void crearExperiencia(Experiencia_laboralDTO exp);
  public void actualizarExperiencia(Experiencia_laboralDTO exp);
  public void eliminarExperiencia(Long id);
  public void crearProyecto(ProyectoDTO proy);
  public void actualizarProyecto(ProyectoDTO proy);
  public void eliminarProyecto(Long id);
  public void crearHabilidad(HabilidadDTO skill);
  public void actualizarHabilidad(HabilidadDTO skill);
  public void eliminarHabilidad(Long id);
}
