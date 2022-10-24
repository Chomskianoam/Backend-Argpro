
package com.portfolio.rim.Repository;


import com.portfolio.rim.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RSkills extends JpaRepository<Skills, Integer>{
   Optional<Skills> findByNombreS(String nombreS);
   public boolean existsByNombreS(String nombreS);
}
