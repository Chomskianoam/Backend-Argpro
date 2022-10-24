
package com.portfolio.rim.Controller;

import com.portfolio.rim.Entity.Persona;
import com.portfolio.rim.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//CrossOrigin(origins = {"http://localhost:4200", "https://frontend-argpro-50ba2.web.app"})
@CrossOrigin(origins = "https://frontend-argpro-50ba2.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService; //Llamamos del servicio del controlador al servicio. Vamos a hacerlo con la interfz del servicio, porque la interface llama al servicio.
        
    //Declaración de métodos: //A la variable declarada arriba (ipersonaService) la voy a llamar y le voy a pasar los distintos métodos.
    
    @GetMapping("/personas/traer") //Con esto, cuando ponga la URL correspondiente, va a ejecutar este método. El front diferencia con la URL.
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){ //recordemos en el método savePersona (iPersonaService) está como parámetro un objeto con todos sus respectivos atributos.
    ipersonaService.savePersona(persona);
    return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){ //@PathVariable implica un valor variable, valga la redundancia.
     ipersonaService.deletePersona(id);
     return "La persona fue eliminada correctamente";
    }
   
    //URL:PUERTO/personas/editar/id/nombre&apellido&img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")    //Primero encuentra a la persona vía id, cambia los nombres vía setters y por último, guardamos los cambios.
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre, 
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
           
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1); //Uno es para que el único perfil buscable sea el mío
    }
} 
    
 
