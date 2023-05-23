package com.PrimeraAppSpring.primerProyecto.configuration;

import com.PrimeraAppSpring.primerProyecto.security.JWTAuthenticationFilter;
import com.PrimeraAppSpring.primerProyecto.security.JWTAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {
  
  
  private final UserDetailsService userDetailsService;  //Administrador de credenciales de usuario
  private final JWTAuthorizationFilter jwtAuthorizationFilter;
  
  @Bean
  //filtros de seguridad, se encarga de manejar las solicitudes de autenticación y autorización en la aplicación
  SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
    JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
    jwtAuthenticationFilter.setAuthenticationManager(authManager);
    jwtAuthenticationFilter.setFilterProcessesUrl("/login"); //Establecemos la ruta para el inicio de sesion
    
    return http
            .cors()
            .and()
            .csrf().disable()         //desabilitamos el  cross site request forgery
            .authorizeHttpRequests()      //reglas de solicitudes
            .requestMatchers("api/ver/datos") //habilitacion de registro de un usuario
            .permitAll()
            .anyRequest()             //cualquier solicitud que ingrese a la api
            .authenticated()          //debe estar autenticada
//            .and()
//            .httpBasic()
            .and()                    //y ademas
            .sessionManagement()      //la gestion de sesiones
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)   //politica de gestion de sesiones STATELESSS, osea sin estado
            .and()      
            .addFilter(jwtAuthenticationFilter)  //agregamos un filtro
            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();                 //construir el security filter chain
  }
  
  @Bean
  AuthenticationManager authnManager(HttpSecurity http) throws Exception{
    return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
            .and()
            .build();
  } 
  
  //Implementacion de password encoder
  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  
//Prueba para la implementacion
//Crea un usuario en memoria para hacer las pruebas de sesion
//  @Bean
//  UserDetailsService userDetailsService(){
//    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//    manager.createUser(User.withUsername("admin")
//            .password(passwordEncoder().encode("admin"))
//            .roles()
//            .build());
//    return manager;
//  }
}
