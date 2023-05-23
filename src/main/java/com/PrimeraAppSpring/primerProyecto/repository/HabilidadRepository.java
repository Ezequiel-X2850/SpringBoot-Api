package com.PrimeraAppSpring.primerProyecto.repository;

import com.PrimeraAppSpring.primerProyecto.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface HabilidadRepository extends JpaRepository<Habilidad, Long>{
  
}
