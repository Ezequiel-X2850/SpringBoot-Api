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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DTOtoPersona implements IMapperService<Persona, PersonaDTO>{
  
  private static final SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
  private static final SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
  
  @Override
  public PersonaDTO map(Persona in) {
    PersonaDTO persona = new PersonaDTO();
    persona.setId(in.getId());
    persona.setNombre(in.getNombre());
    persona.setApellido(in.getApellido());
    persona.setDescripcion(in.getDescripcion());
    persona.setFoto(in.getFoto());
    try {
      persona.setEducacion(listaEducacion(in));
    } catch (ParseException ex) {
      Logger.getLogger(DTOtoPersona.class.getName()).log(Level.SEVERE, null, ex);
    }
    persona.setExperiencia(listaTrabajo(in));
    persona.setContacto(listaContacto(in));
    persona.setSkills(listaHabilidad(in));
    persona.setProyectos(listaProyectos(in));
    return persona;
  }
  
  public List<EducacionDTO> listaEducacion(Persona e) throws ParseException{
    ModelMapper mapper = new ModelMapper();
    List<EducacionDTO> educacion = new ArrayList();
    for(Educacion edu: e.getEducacion()){
      EducacionDTO ed = mapper.map(edu, EducacionDTO.class);
      ed.setFecha_inicio_estudio(edu.getFecha_inicio());
      if(edu.getFecha_fin() != null){
        ed.setFecha_fin_estudio(edu.getFecha_fin());
      }
      educacion.add(ed);
    }
    return educacion;
  }
  
  public List<Experiencia_laboralDTO> listaTrabajo(Persona e){
    ModelMapper mapper = new ModelMapper();
    List<Experiencia_laboralDTO> experiencia = new ArrayList();
    for(Experiencia_laboral exp: e.getExperiencia()){
      Experiencia_laboralDTO ex = mapper.map(exp, Experiencia_laboralDTO.class);
      experiencia.add(ex);
    }
    return experiencia;
  }
  
  public List<Metodo_contactoDTO> listaContacto(Persona e){
    ModelMapper mapper = new ModelMapper();
    List<Metodo_contactoDTO> contacto = new ArrayList();
    for(Metodo_contacto con: e.getContacto()){
      Metodo_contactoDTO metContacto = mapper.map(con, Metodo_contactoDTO.class);
      contacto.add(metContacto);
    }
    return contacto;
  }
  
  public List<HabilidadDTO> listaHabilidad(Persona e){
    ModelMapper mapper = new ModelMapper();
    List<HabilidadDTO> skill = new ArrayList();
    for(Habilidad s: e.getSkills()){
      HabilidadDTO sk = mapper.map(s, HabilidadDTO.class);
      skill.add(sk);
    }
    return skill;
  }
  
  public List<ProyectoDTO> listaProyectos(Persona e){
    ModelMapper mapper = new ModelMapper();
    List<ProyectoDTO> proyecto = new ArrayList();
    for(Proyecto p: e.getProyectos()){
      ProyectoDTO proy = mapper.map(p, ProyectoDTO.class);
      proyecto.add(proy);
    }
    return proyecto;
  }
}
