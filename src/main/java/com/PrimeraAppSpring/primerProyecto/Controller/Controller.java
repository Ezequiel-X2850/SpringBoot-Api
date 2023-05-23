package com.PrimeraAppSpring.primerProyecto.Controller;

import com.PrimeraAppSpring.primerProyecto.DTO.EducacionDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.Experiencia_laboralDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.HabilidadDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.Metodo_contactoDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.PersonaDTO;
import com.PrimeraAppSpring.primerProyecto.DTO.ProyectoDTO;
import com.PrimeraAppSpring.primerProyecto.model.Persona;
import com.PrimeraAppSpring.primerProyecto.model.Usuario;
import com.PrimeraAppSpring.primerProyecto.service.DTOtoPersona;
import com.PrimeraAppSpring.primerProyecto.service.IPersonaService;
import com.PrimeraAppSpring.primerProyecto.service.IUsuarioService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//@RestController marca la clase como un controlador donde cada método devuelve un objeto de dominio en lugar de una vista
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class Controller {
  
  List<Persona> listaPersonas = new ArrayList();
  
  //Inyeccion de Dependencias
  @Autowired
  private final IPersonaService persoServ;
  
  @Autowired
  private final IUsuarioService usuServ;
  
  @Autowired
  private final DTOtoPersona recPer; 
  
  //Esta anotacion tiene otra ayuda de la anotacion @RequestBody. Esta anotacion permite recibir objetos de dominio completos y
  // los convierte en objetos Java
  @PostMapping("/registrar/usuario")
  public ResponseEntity<String> guardarDatos(@RequestBody Usuario usu){
    // Accion del metodow
    //listaPersonas.add(pers);
    try{
      usuServ.crearUsuario(usu);
      return ResponseEntity.ok("Datos guardados correctamente");
    }catch(Exception e){
      return ResponseEntity.badRequest().body("error de Request");
    }
  }
  
  
  //-----------------------------  Persona  ------------------------------------
  
  //Create
  @PostMapping("/new/persona")
  public ResponseEntity<String> guardarPersona(@RequestBody PersonaDTO pers){
    // Accion del metodow
    //listaPersonas.add(pers);
    try{
      persoServ.crearPersona(pers);
      return ResponseEntity.ok("Datos guardados correctamente");
    }catch(Exception e){
      return ResponseEntity.badRequest().body(" error de Request");
    }
  }
  
  //Update
  @PutMapping("/actualizar/persona")
  @ResponseBody
  public ResponseEntity<String> actualizarPersona(@RequestBody PersonaDTO persona){
    try {
      persoServ.actualizarPersona(persona);
      return ResponseEntity.ok("Datos actualizados con exito");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al actualizar los datos");
    }
  }
  
  //Read
  // Estamos enviando la lista que creamos dentro del metodo traerPerso()
  @GetMapping("/ver/datos")
  @ResponseBody
  public List<PersonaDTO> verPerso(){
    List<PersonaDTO> persoList = new ArrayList();
    for(Persona per : persoServ.verPersonas()){
      persoList.add(recPer.map(per));
    }
    return persoList;
  }
  
  /*
  Tambien podemos enviar datos con el metodo ResponseEntity
  @GetMapping("/pruebaresponse")
  ResponseEntity<String>traerRespuesta(){
    return new ResponseEntity<String>("Este es un envio de estado", HttpStatus.OK);
  }*/
  
  //Delete
  @DeleteMapping("/delete/{id}")
  public void borrarPersona(@PathVariable Long id){
    persoServ.borrarPersona(id);
  }
  
  //------------------------------  Contacto  ----------------------------------
  
  @PostMapping("/guardar/contacto")
  @ResponseBody
  public ResponseEntity<String> guardarContact(@RequestBody Metodo_contactoDTO contacto){
    try {
      persoServ.crearContacto(contacto);
      return ResponseEntity.ok("Contacto guardado con exito");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al cargar el contacto");
    }
  }
  
  @PutMapping("/acutalizar/contacto")
  @ResponseBody
  public ResponseEntity<String> actualizarContacto(@RequestBody Metodo_contactoDTO contacto){
    try {
      persoServ.actualizarContacto(contacto);
      return ResponseEntity.ok("Datos de contacto actualizado correctamente");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al actualizar");
    }
  }
  
  @DeleteMapping("/eliminar/contacto/{id}")
  public ResponseEntity<String> eliminarContacto(@PathVariable Long id){
    try {
      persoServ.eliminarContacto(id);
      return ResponseEntity.ok("Contacto eliminado con exito");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al eliminar contacto");
    }
  }
  
  //-----------------------------  Educacion  ----------------------------------
  
  @PostMapping("/guardar/education")
  @ResponseBody
  public ResponseEntity<String> guardarEstudio(@RequestBody EducacionDTO edu){
    try {
      persoServ.crearEstudio(edu);
      return ResponseEntity.ok("Datos guardados correctamente");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error en la carga de datos");
    }
  }
  
  @PutMapping("/actualizar/educacion")
  @ResponseBody
  public ResponseEntity<String> actualizarEstudio(@RequestBody EducacionDTO edu){
    try {
      persoServ.actualizarEstudio(edu);
      return ResponseEntity.ok("Datos de educacion actualizados correctametne");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al actualizar datos de educacion");
    }
  }
  
  @DeleteMapping("/delete/education/{id}")
  public void borrarEstudio(@PathVariable Long id){
    persoServ.eliminarEstudio(id);
  }
  
  
  //----------------------------  Experiencia Laboral  -------------------------
  
  @PostMapping("/guardar/trabajo")
  @ResponseBody
  public ResponseEntity<String> guardarExperiencia(@RequestBody Experiencia_laboralDTO exp){
    try {
      persoServ.crearExperiencia(exp);
      return ResponseEntity.ok("Experiencia laboral guardada correctamente");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al guardar el trabajo");
    }
  }
  
  @PutMapping("/actualizar/trabajo")
  @ResponseBody
  public ResponseEntity<String> actualizarExperiencia(@RequestBody Experiencia_laboralDTO exp){
    try {
      persoServ.actualizarExperiencia(exp);
      return ResponseEntity.ok("Datos actualizados correctamente");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al actualizar experiencia laboral");
    }
  }
  
  @DeleteMapping("/delete/exp/{id}")
  public void borrarExperiencia(@PathVariable Long id){
    persoServ.eliminarExperiencia(id);
  }
  
  //------------------------------  Proyectos  ---------------------------------
  
  @PostMapping("/guardar/proyecto")
  @ResponseBody
  public ResponseEntity<String> guardarProyecto(@RequestBody ProyectoDTO proyecto){
    try {
      persoServ.crearProyecto(proyecto);
      return ResponseEntity.ok("Proyecto guardado correctamente");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al guardar el proyecto");
    }
  }
  
  @PutMapping("/actualizar/proyecto")
  @ResponseBody
  public ResponseEntity<String> actualizarProyecto(@RequestBody ProyectoDTO proyecto){
    try {
      persoServ.actualizarProyecto(proyecto);
      return ResponseEntity.ok("Datos de proyecto actualizado con exito");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al actualizar datos del proyecto");
    }
  }
  
  @DeleteMapping("/eliminar/proyecto/{id}")
  @ResponseBody
  public ResponseEntity<String> eliminarProyecto(@PathVariable Long id){
    try {
      persoServ.eliminarProyecto(id);
      return ResponseEntity.ok("Proyecto eliminado con exito");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al eliminar el proyecto");
    }
  }
  
  //---------------------------  Habilidad  ------------------------------------
  
  @PostMapping("/guardar/skill")
  @ResponseBody
  public ResponseEntity<String> guardarHabilidad(@RequestBody HabilidadDTO habilidad){
     try {
      persoServ.crearHabilidad(habilidad);
      return ResponseEntity.ok("Habilidad guardada correctamente");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al guardar la habilidad");
    }
  }
  
  @PutMapping("/actualizar/skill")
  @ResponseBody
  public ResponseEntity<String> actualizarHabilidad(@RequestBody HabilidadDTO habilidad){
     try {
      persoServ.actualizarHabilidad(habilidad);
      return ResponseEntity.ok("Habilidad actualizada correctamente");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al actualizar la habilidad");
    }
  }
  
  @DeleteMapping("/eliminar/skill/{id}")
  @ResponseBody
  public ResponseEntity<String> guardarHabilidad(@PathVariable Long id){
    try {
      persoServ.eliminarHabilidad(id);
      return ResponseEntity.ok("Habilidad eliminada correctamente");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error al eliminar habilidad");
    }
  }
}
