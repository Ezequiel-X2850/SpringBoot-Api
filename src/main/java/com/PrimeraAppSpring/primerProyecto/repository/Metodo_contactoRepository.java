package com.PrimeraAppSpring.primerProyecto.repository;

import com.PrimeraAppSpring.primerProyecto.model.Metodo_contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface Metodo_contactoRepository extends JpaRepository<Metodo_contacto, Long>{
  
}
