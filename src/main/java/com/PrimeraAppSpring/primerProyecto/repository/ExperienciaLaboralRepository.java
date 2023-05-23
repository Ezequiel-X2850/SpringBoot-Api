package com.PrimeraAppSpring.primerProyecto.repository;

import com.PrimeraAppSpring.primerProyecto.model.Experiencia_laboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ExperienciaLaboralRepository extends JpaRepository<Experiencia_laboral, Long>{
  
}
