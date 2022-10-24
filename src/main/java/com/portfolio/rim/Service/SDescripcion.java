package com.portfolio.rim.Service;

import com.portfolio.rim.Entity.Descripcion;
import com.portfolio.rim.Repository.RDescripcion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
@Transactional
public class SDescripcion {
    @Autowired
    RDescripcion rDescripcion;
    
    public List<Descripcion> list() {
        return rDescripcion.findAll();      
    }
    
    public Optional<Descripcion> getOne(int id){
        return rDescripcion.findById(id);
    }
    
    public Optional<Descripcion> getByNombreD(String nombreD){
        return rDescripcion.findByNombreD(nombreD);
    }
    
    public void save(Descripcion desc){
        rDescripcion.save(desc);
    }
    
    public void delete(int id){
        rDescripcion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rDescripcion.existsById(id);
    }
    
    public boolean existsByNombreD(String nombreD){
        return rDescripcion.existsByNombreD(nombreD);
    }
}
