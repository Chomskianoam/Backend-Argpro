
package com.portfolio.rim.Security.Repository;

import com.portfolio.rim.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario); //Estos booleans son para que nos devuelva true o false en caso de que exista
    boolean existsByEmail(String email);
}
