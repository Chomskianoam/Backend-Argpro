
package com.portfolio.rim.Service;

import com.portfolio.rim.Entity.Persona;
import com.portfolio.rim.Interface.IPersonaService;
import com.portfolio.rim.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{    
    //Queremos traer una dependencia a esta, esta es, el repositorio. Utilizamos la annotation Autowired que nos permite inyectar dependencias dentro de otras, de forma sencilla
    @Autowired IPersonaRepository ipersonaRepository; //Tipo y nombre de variable. Sintaxis de siempre.
     
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll(); //La variable persona va a contener una lista de Personas. 
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona; 
    }
    
    
}
