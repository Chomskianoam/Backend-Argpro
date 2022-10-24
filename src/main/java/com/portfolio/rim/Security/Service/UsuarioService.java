
package com.portfolio.rim.Security.Service;

import com.portfolio.rim.Security.Entity.Usuario;
import com.portfolio.rim.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    //Para comprobar si el nombre de usuario ya existe
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    //Para comprobar si el email existe
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }

    //Para guardar el usuario nuevo, por eso es void
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
    
}
