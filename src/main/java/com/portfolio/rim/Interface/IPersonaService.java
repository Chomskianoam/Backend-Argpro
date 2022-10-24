//La interfaz del servicio de Persona
package com.portfolio.rim.Interface;

import com.portfolio.rim.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer una lista <con objetos de Persona>
    public List<Persona> getPersona();
    
    //Guardar un objeto del tipo Persona
    public void savePersona(Persona persona); //(Lo que va en minúscula sería una variable persona, y en mayúscula indicamos los atributos que va a poseer)

    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id); //Nuevamente, tipo y luego el campo a utilizar. 
    
    //Buscar persona por ID
    public Persona findPersona(Long id);
}
