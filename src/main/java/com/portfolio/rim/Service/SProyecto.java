
package com.portfolio.rim.Service;

import com.portfolio.rim.Entity.Proyecto;
import com.portfolio.rim.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    @Autowired
    RProyecto rProyecto;
    
     public List<Proyecto> list(){    //Esto arma una lista con todas las experiencias que encuentre.
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){    //Busca uno en particular por id.
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombreP(String nombreP){  //Busca uno en particular por nombre.
        return rProyecto.findByNombreP(nombreP);
    }
    
    public void save(Proyecto pro){
        rProyecto.save(pro);
    }

    public void delete(int id){
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){            //Este método y el de abajo son para ver si existe dicho objeto (sirve para las validaciones)
        return rProyecto.existsById(id);
    }
    
    public boolean existsByNombreP(String nombreP){
        return rProyecto.existsByNombreP(nombreP);
    }
}
