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
import com.PrimeraAppSpring.primerProyecto.model.Usuario;
import com.PrimeraAppSpring.primerProyecto.repository.EducacionRepository;
import com.PrimeraAppSpring.primerProyecto.repository.ExperienciaLaboralRepository;
import com.PrimeraAppSpring.primerProyecto.repository.HabilidadRepository;
import com.PrimeraAppSpring.primerProyecto.repository.Metodo_contactoRepository;
import com.PrimeraAppSpring.primerProyecto.repository.PersonaRepository;
import com.PrimeraAppSpring.primerProyecto.repository.ProyectoRepository;
import com.PrimeraAppSpring.primerProyecto.repository.UsuarioRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
  public class PersonaService implements IPersonaService{
  
  
  @Autowired
  public PersonaRepository persoRepo;
  
  @Autowired
  private PersonaDTOService mapper;
  
  @Autowired
  private IUsuarioService usu;
  
  @Autowired
  private UsuarioRepository usuRepo;
  
  @Autowired
  private Metodo_contactoRepository contactoRepo;
  
  @Autowired
  private EducacionRepository eduRepo;
  
  @Autowired
  private ExperienciaLaboralRepository expRepo;
  
  @Autowired
  private HabilidadRepository skillRepo;
  
  @Autowired
  private ProyectoRepository proRepo;
  
  @Override
  public List<Persona> verPersonas() {
    return persoRepo.findAll();
  }

  @Override
  public void crearPersona(PersonaDTO per) {
    Usuario usuario = new Usuario();
    usuario = usu.buscarUsuario(usu.getCurrentUser().get().getId());
    Persona persona = new Persona();
    persona.setUsuario(usuario);
    persona = mapper.map(per);
    persoRepo.save(persona);
    usuario.setPersona(persona);
    usuRepo.save(usuario);
  }
  
  @Override
  public void borrarPersona(Long id) {
    persoRepo.deleteById(id);
  }

  @Override
  public Persona buscarPersona(Long id) {
    return persoRepo.findById(id).orElse(null);
  }

  //Actualizar o Update de los datos de la persona
  @Override
  public void actualizarPersona(PersonaDTO persona) {
    Usuario usuario = usu.getCurrentUser().get();
    Persona per = usuario.getPersona();
    if(persona.getApellido().isEmpty()){
      per.setApellido(per.getApellido());
    }else{
      per.setApellido(persona.getApellido());
    }
    if(persona.getNombre().isBlank()){
      per.setApellido(per.getNombre());
    }else{
      per.setNombre(persona.getNombre());
    }
    if( persona.getDescripcion().isBlank()){
      per.setApellido(per.getDescripcion());
    }else{
      per.setDescripcion(persona.getDescripcion());
    }
    if(persona.getFoto().isBlank()){
      per.setApellido(per.getFoto());
    }else{
      per.setFoto(persona.getFoto());
    }
    per.setContacto(per.getContacto());
    per.setEducacion(per.getEducacion());
    per.setExperiencia(per.getExperiencia());
    per.setSkills(per.getSkills());
    per.setProyectos(per.getProyectos());
    persoRepo.save(per);
  }
  
  //----------------------------  CONTACTO  ------------------------------------
  // Creacion de la entidad Metodo_contacto
  @Override
  public void crearContacto(Metodo_contactoDTO contacto) {
    Metodo_contacto contact = new Metodo_contacto();
    contact.setTipo_contacto(contacto.getTipo_contacto());
    contact.setValor_contacto(contacto.getValor_contacto());
    contact.setImg(contacto.getImg());
    Usuario usuario = usu.getCurrentUser().get();
    Persona persona = usuario.getPersona();
    contact.setPersona(persona);
    this.contactoRepo.save(contact);
  }
  
  @Override
  public void actualizarContacto(Metodo_contactoDTO contacto) {
    Metodo_contacto contact = contactoRepo.findById(contacto.getId()).get();
    if(contacto.getTipo_contacto().isBlank()){
      contact.setTipo_contacto(contact.getTipo_contacto());
    }else{
      contact.setTipo_contacto(contacto.getTipo_contacto());
    }
    if(contacto.getValor_contacto().isBlank()){
      contact.setValor_contacto(contact.getValor_contacto());
    }else{
      contact.setValor_contacto(contacto.getValor_contacto());
    }
    if(contacto.getImg().isBlank()){
      contact.setImg(contact.getImg());
    }else{
      contact.setImg(contacto.getImg());
    }
    Usuario usuario = usu.getCurrentUser().get();
    Persona persona = usuario.getPersona();
    contact.setPersona(persona);
    this.contactoRepo.save(contact);
  }

  @Override
  public void eliminarContacto(Long id) {
    contactoRepo.deleteById(id);
  }

  //---------------------------- ESTUDIO  --------------------------------------
  //Creacion de nuevo estudio
  @Override
  public void crearEstudio(EducacionDTO edu) {
    Educacion educacion = new Educacion();
    educacion.setInstitucion(edu.getInstitucion());
    educacion.setTitulo(edu.getTitulo());
    educacion.setEstado(edu.getEstado());
    educacion.setFecha_inicio(edu.getFecha_inicio_estudio());
    educacion.setFecha_fin(edu.getFecha_fin_estudio());
    Usuario usuario = usu.getCurrentUser().get();
    Persona persona = usuario.getPersona();
    educacion.setPersona(persona);
    eduRepo.save(educacion);
  }
  
  //Actualizacion de un estudio
  @Override
  public void actualizarEstudio(EducacionDTO edu) {
    Educacion educacion = eduRepo.findById(edu.getId()).get();
    if(edu.getInstitucion().isBlank()){
      educacion.setInstitucion(educacion.getInstitucion());
    }else{
      educacion.setInstitucion(edu.getInstitucion());
    }
    if(edu.getTitulo().isBlank()){
      educacion.setTitulo(educacion.getTitulo());
    }else{
      educacion.setTitulo(edu.getTitulo());
    }
    if(edu.getEstado().isBlank()){
      educacion.setEstado(educacion.getEstado());
    }else{
      educacion.setEstado(edu.getEstado());
    }
    if(edu.getFecha_inicio_estudio() != null){
      educacion.setFecha_inicio(edu.getFecha_inicio_estudio());
    }{
      educacion.setFecha_inicio(educacion.getFecha_inicio());
    }
    if(edu.getFecha_fin_estudio()!= null){
      educacion.setFecha_fin(edu.getFecha_fin_estudio());
    }else{
      educacion.setFecha_fin(educacion.getFecha_fin());
    }
    if(edu.getImg().isBlank()){
      educacion.setImg(educacion.getImg());
    }else{
      educacion.setImg(edu.getImg());
    }
    eduRepo.save(educacion);
  }

  @Override
  public void eliminarEstudio(Long id) {
    eduRepo.deleteById(id);
  }

  //----------------------------  EXPERIENCIA  ---------------------------------
  @Override
  public void crearExperiencia(Experiencia_laboralDTO exp) {
    Experiencia_laboral trabajo = new Experiencia_laboral();
    trabajo.setEmpresa(exp.getEmpresa());
    trabajo.setPuesto(exp.getPuesto());
    trabajo.setDescripcion(exp.getDescripcion());
    trabajo.setFecha_inicio(exp.getFecha_inicio());
    trabajo.setFecha_fin(exp.getFecha_fin());
    trabajo.setImg(exp.getImg());
    Usuario usuario = usu.getCurrentUser().get();
    Persona persona = usuario.getPersona();
    trabajo.setPersona(persona);
    expRepo.save(trabajo);
  }

  @Override
  public void actualizarExperiencia(Experiencia_laboralDTO exp) {
    Experiencia_laboral trabajo = expRepo.findById(exp.getId()).get();
    if(exp.getEmpresa().isBlank()){
      trabajo.setEmpresa(trabajo.getEmpresa());
    }else{
      trabajo.setEmpresa(exp.getEmpresa());
    }
    if(exp.getPuesto().isBlank()){
      trabajo.setPuesto(trabajo.getPuesto());
    }else{
      trabajo.setPuesto(exp.getPuesto());
    }
    if(exp.getDescripcion().isBlank()){
      trabajo.setDescripcion(trabajo.getDescripcion());
    }else{
      trabajo.setDescripcion(exp.getDescripcion());
    }
    if(exp.getFecha_inicio()!= null){
      trabajo.setFecha_inicio(exp.getFecha_inicio());
    }else{
      trabajo.setFecha_inicio(trabajo.getFecha_inicio());
    }
    if(exp.getFecha_fin()!= null){
      trabajo.setFecha_fin(exp.getFecha_fin());
    }else{
      trabajo.setFecha_fin(trabajo.getFecha_fin());
    }
    if(exp.getImg().isEmpty()){
      trabajo.setImg(trabajo.getImg());
    }else{
      trabajo.setImg(exp.getImg());
    }
    expRepo.save(trabajo);
  }

  @Override
  public void eliminarExperiencia(Long id) {
    expRepo.deleteById(id);
  }

  
  //----------------------------  PROYECTO  ------------------------------------
  @Override
  public void crearProyecto(ProyectoDTO proy) {
    Proyecto proyecto = new Proyecto();
    proyecto.setNombre(proy.getNombre());
    proyecto.setDescripcion(proy.getDescripcion());
    proyecto.setFecha_inicio(proy.getFecha_inicio());
    proyecto.setFecha_fin(proy.getFecha_fin());
    proyecto.setImg(proy.getImg());
    Usuario usuario = usu.getCurrentUser().get();
    Persona persona = usuario.getPersona();
    proyecto.setPersona(persona);
    proRepo.save(proyecto);
  }

  @Override
  public void actualizarProyecto(ProyectoDTO proy) {
    Proyecto proyecto = proRepo.findById(proy.getId()).get();
    if(proy.getNombre().isBlank()){
      proyecto.setNombre(proyecto.getNombre());
    }else{
      proyecto.setNombre(proy.getNombre());
    }
    if(proy.getDescripcion().isBlank()){
      proyecto.setDescripcion(proyecto.getDescripcion());
    }else{
      proyecto.setDescripcion(proy.getDescripcion());
    }
    if(proy.getFecha_inicio() != null){
      proyecto.setFecha_inicio(proy.getFecha_inicio());
      
    }else{
      proyecto.setFecha_inicio(proyecto.getFecha_inicio());
    }
    if(proy.getFecha_fin() != null){
      proyecto.setFecha_fin(proy.getFecha_fin());
    }else{
      proyecto.setFecha_fin(proyecto.getFecha_fin());
    }
    if(proy.getImg().isBlank()){
      proyecto.setImg(proy.getImg());
    }else{
      proyecto.setImg(proy.getImg());
    }
    Usuario usuario = usu.getCurrentUser().get();
    Persona persona = usuario.getPersona();
    proyecto.setPersona(persona);
    proRepo.save(proyecto);
  }

  @Override
  public void eliminarProyecto(Long id) {
    proRepo.deleteById(id);
  }

  
  //-----------------------------  HABILIDAD  ----------------------------------
  @Override
  public void crearHabilidad(HabilidadDTO skill) {
    Habilidad habilidad = new Habilidad();
    habilidad.setNombre(skill.getNombre());
    habilidad.setDescripcion(skill.getDescripcion());
    habilidad.setImg(skill.getImg());
    Usuario usuario = usu.getCurrentUser().get();
    Persona persona = usuario.getPersona();
    habilidad.setPersona(persona);
    skillRepo.save(habilidad);
  }

  @Override
  public void actualizarHabilidad(HabilidadDTO skill) {
    Habilidad habilidad = skillRepo.findById(skill.getId()).get();
    if(skill.getNombre().isBlank()){
      habilidad.setNombre(habilidad.getNombre());
    }else{
      habilidad.setNombre(skill.getNombre());
    }
    if(skill.getDescripcion().isBlank()){
      habilidad.setDescripcion(habilidad.getDescripcion());
    }else{
      habilidad.setDescripcion(skill.getDescripcion());
    }
    if(skill.getImg().isBlank()){
      habilidad.setImg(habilidad.getImg());
    }else{
      habilidad.setImg(skill.getImg());
    }
    Usuario usuario = usu.getCurrentUser().get();
    Persona persona = usuario.getPersona();
    habilidad.setPersona(persona);
    skillRepo.save(habilidad);
  }

  @Override
  public void eliminarHabilidad(Long id) {
    skillRepo.deleteById(id);
  }
}
