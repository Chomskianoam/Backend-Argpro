
package com.portfolio.rim.Service;

import com.portfolio.rim.Entity.Experiencia;
import com.portfolio.rim.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){    //Esto arma una lista con todas las experiencias que encuentre.
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){    //Busca uno en particular por id.
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){  //Busca uno en particular por nombre.
        return rExperiencia.findByNombreE(nombreE);
    }
    
    public void save(Experiencia expe){
        rExperiencia.save(expe);
    }

    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){            //Este método y el de abajo son para ver si existe dicho objeto (sirve para las validaciones)
        return rExperiencia.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rExperiencia.existsByNombreE(nombreE);
    }
}
