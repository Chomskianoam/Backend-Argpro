package com.portfolio.rim.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter //Ambos provinen de lombok y nos "ahorra" la necesidad de escribir código.
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto significa que va a generarle de forma automática un número.
    private Long id;
    
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud") //Con esto indico el mínimo y el máximo, a la vez que un mensaje por si no cumple con las condiciones.
    private String nombre;
    
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String apellido;
    
    
    private String img;


}
