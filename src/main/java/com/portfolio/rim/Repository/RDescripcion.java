
package com.portfolio.rim.Repository;

import com.portfolio.rim.Entity.Descripcion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDescripcion extends JpaRepository<Descripcion, Integer>{
   public Optional<Descripcion> findByNombreD(String nombreD);
   public boolean existsByNombreD(String nombreD);     
}
