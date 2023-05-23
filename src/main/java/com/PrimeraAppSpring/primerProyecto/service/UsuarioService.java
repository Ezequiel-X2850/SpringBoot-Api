package com.PrimeraAppSpring.primerProyecto.service;

import com.PrimeraAppSpring.primerProyecto.model.Persona;
import com.PrimeraAppSpring.primerProyecto.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.PrimeraAppSpring.primerProyecto.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
  
  @Autowired
  public UsuarioRepository usuRepo;
  
          
  @Override
  public List<Usuario> verUsuarios() {
    return usuRepo.findAll();
  }

  @Override
  public void crearUsuario(Usuario usu){
    Usuario usuario = new Usuario();
    usuario.setPassword(new BCryptPasswordEncoder().encode(usu.getPassword()));
    usuario.setNombre(usu.getNombre());
    usuario.setEmail(usu.getEmail());
    usuRepo.save(usuario);
  }
  
  @Override
  public void borrarUsuasrio(Long id){
    usuRepo.deleteById(id);
  }

  @Override
  public Usuario buscarUsuario(Long id) {
    return usuRepo.findById(id).orElse(null);
  }

  @Override
  public void updateUser(Long id, Persona persona) {
    Optional<Usuario> users = usuRepo.findById(id);
    Usuario user = users.get();
    user.setPersona(persona);
  }
  
  
  @Override
  public Optional<Usuario> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final String username = authentication.getName();

        // Buscar el usuario en la base de datos o en un repositorio
        Optional<Usuario> user = usuRepo.findOneByEmail(username);

        return user;
    }

  @Override
  public Optional<Usuario> findByUsername(String username) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

 
}
