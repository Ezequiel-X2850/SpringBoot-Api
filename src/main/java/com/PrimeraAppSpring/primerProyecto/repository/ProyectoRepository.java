package com.PrimeraAppSpring.primerProyecto.repository;

import com.PrimeraAppSpring.primerProyecto.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
  
}
