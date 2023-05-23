package com.PrimeraAppSpring.primerProyecto.service;

import com.PrimeraAppSpring.primerProyecto.model.Persona;
import com.PrimeraAppSpring.primerProyecto.model.Usuario;
import java.util.List;
import java.util.Optional;


public interface IUsuarioService {
  public List<Usuario> verUsuarios();
  public void crearUsuario(Usuario usu);
  public void borrarUsuasrio(Long id);
  public Usuario buscarUsuario(Long id);
  public void updateUser(Long id, Persona persona);
  public Optional<Usuario> findByUsername(String username);
  public Optional<Usuario> getCurrentUser();
}
