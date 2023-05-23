package com.PrimeraAppSpring.primerProyecto.security;

import com.PrimeraAppSpring.primerProyecto.model.Usuario;
import com.PrimeraAppSpring.primerProyecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Administrador de credenciales de usuario

@Service
public class UserDetailServiceImpl implements UserDetailsService{
  
  @Autowired
  private UsuarioRepository usuarioRepo;

  //Buscamos en la base de datos
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepo
            .findOneByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario con el email" +email+ "no existe"));
  
    return new UserDetailsImpl(usuario);
  }
  
}
