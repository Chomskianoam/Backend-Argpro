
package com.portfolio.rim.Security.Service;

import com.portfolio.rim.Security.Entity.Rol;
import com.portfolio.rim.Security.Enums.RolNombre;
import com.portfolio.rim.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //Trata de mantener lo que tenemos acá con la base de datos, o sea, brinda persistencia. Más que nada para los casos donde hay algún error, así la base de datos se mantiene igual a los registros del front.
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);    
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
    
}
