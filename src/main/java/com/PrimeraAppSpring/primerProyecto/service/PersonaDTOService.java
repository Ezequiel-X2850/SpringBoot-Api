package com.PrimeraAppSpring.primerProyecto.service;

import com.PrimeraAppSpring.primerProyecto.DTO.EducacionDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.Experiencia_laboralDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.HabilidadDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.Metodo_contactoDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.PersonaDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.ProyectoDTO;
import com.PrimeraAppSpring.primerProyecto.model.Educacion;
import com.PrimeraAppSpring.primerProyecto.model.Experiencia_laboral;
import com.PrimeraAppSpring.primerProyecto.model.Habilidad;
import com.PrimeraAppSpring.primerProyecto.model.Metodo_contacto;
import com.PrimeraAppSpring.primerProyecto.model.Persona;
import com.PrimeraAppSpring.primerProyecto.model.Proyecto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonaDTOService implements IMapperService<PersonaDTO, Persona>{

  private static final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
  
  @Override
  public Persona map(PersonaDTO per) {
    Persona persona = new Persona();
    persona.setNombre(per.getNombre());
    persona.setApellido(per.getApellido());
    persona.setDescripcion(per.getDescripcion());
    persona.setFoto(per.getFoto());
    persona.setEducacion(listaEducacion(per));
    persona.setExperiencia(listaTrabajo(per));
    persona.setContacto(listaContacto(per));
    persona.setSkills(listaHabilidad(per));
    persona.setProyectos(listaProyectos(per));
    return persona;
  }
        
  public List<Educacion> listaEducacion(PersonaDTO e){
    ModelMapper mapper = new ModelMapper();
    List<Educacion> educacion = new ArrayList();
    for(EducacionDTO edu: e.getEducacion()){
      Educacion ed = mapper.map(edu, Educacion.class);
      ed.setFecha_inicio(edu.getFecha_inicio_estudio());
      ed.setPersona(mapper.map(e, Persona.class));
      educacion.add(ed);
    }
    return educacion;
  }
  
  public List<Experiencia_laboral> listaTrabajo(PersonaDTO e){
    ModelMapper mapper = new ModelMapper();
    List<Experiencia_laboral> experiencia = new ArrayList();
    for(Experiencia_laboralDTO exp: e.getExperiencia()){
      Experiencia_laboral ex = mapper.map(exp, Experiencia_laboral.class);
      ex.setPersona(mapper.map(e, Persona.class));
      experiencia.add(ex);
    }
    return experiencia;
  }
  
  public List<Metodo_contacto> listaContacto(PersonaDTO e){
    ModelMapper mapper = new ModelMapper();
    List<Metodo_contacto> contacto = new ArrayList();
    for(Metodo_contactoDTO con: e.getContacto()){
      Metodo_contacto metContacto = mapper.map(con, Metodo_contacto.class);
      metContacto.setPersona(mapper.map(e, Persona.class));
      contacto.add(metContacto);
    }
    return contacto;
  }
  
  public List<Habilidad> listaHabilidad(PersonaDTO e){
    ModelMapper mapper = new ModelMapper();
    List<Habilidad> skill = new ArrayList();
    for(HabilidadDTO s: e.getSkills()){
      Habilidad sk = mapper.map(s, Habilidad.class);
      sk.setPersona(mapper.map(e, Persona.class));
      skill.add(sk);
    }
    return skill;
  }
  
  public List<Proyecto> listaProyectos(PersonaDTO e){
    ModelMapper mapper = new ModelMapper();
    List<Proyecto> proyecto = new ArrayList();
    for(ProyectoDTO p: e.getProyectos()){
      Proyecto proy = mapper.map(p, Proyecto.class);
      proy.setPersona(mapper.map(e, Persona.class));
      proyecto.add(proy);
    }
    return proyecto;
  }
}
