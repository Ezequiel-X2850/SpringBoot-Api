package com.PrimeraAppSpring.primerProyecto.security;

import com.PrimeraAppSpring.primerProyecto.model.Usuario;
import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

  private final Usuario usuario;
  
  @Override
  public String getPassword() {
    return usuario.getPassword();
  }

  @Override
  public String getUsername() {
    return usuario.getEmail();
  }
  
  public String getNombre(){
    return usuario.getNombre();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    //este metodo es muy util en el caso de  que el usuario tuviera permisos o roles
    return Collections.emptyList(); 
  }

  
  
}
