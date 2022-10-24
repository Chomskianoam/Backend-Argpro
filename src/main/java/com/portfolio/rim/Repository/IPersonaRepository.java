package com.portfolio.rim.Repository;

import com.portfolio.rim.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository         
public interface IPersonaRepository extends JpaRepository<Persona, Long> { //Escribimos el tipo del id de la clase importada
    
}
