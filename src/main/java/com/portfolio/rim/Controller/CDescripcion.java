package com.portfolio.rim.Controller;

import com.portfolio.rim.Dto.dtoDescripcion;
import com.portfolio.rim.Entity.Descripcion;
import com.portfolio.rim.Security.Controller.Mensaje;
import com.portfolio.rim.Service.SDescripcion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
//@CrossOrigin(origins = {"http://localhost:4200", "https://frontend-argpro-50ba2.web.app"})
@CrossOrigin(origins = "https://frontend-argpro-50ba2.web.app")
public class CDescripcion {
    @Autowired
    SDescripcion sDescripcion;
    
    @GetMapping("/lista")
   public ResponseEntity<List<Descripcion>> list(){
       List<Descripcion> list= sDescripcion.list();
       return new ResponseEntity(list, HttpStatus.OK);
   }
   
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoDescripcion dtodesc){
       if(StringUtils.isBlank(dtodesc.getNombreD()))
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(dtodesc.getImgperfilD()))
           return new ResponseEntity(new Mensaje("La imagen de perfil es obligatoria"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(dtodesc.getImgfondoD()))
           return new ResponseEntity(new Mensaje("La imagen de fondo es obligatoria"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(dtodesc.getInfoD()))
           return new ResponseEntity(new Mensaje("Una frase descriptiva es obligatoria"), HttpStatus.BAD_REQUEST);
       if(sDescripcion.existsByNombreD(dtodesc.getNombreD()))
           return new ResponseEntity(new Mensaje("Ese nombre ya está utilizado"), HttpStatus.BAD_REQUEST);
   
        Descripcion descripcion = new Descripcion(dtodesc.getNombreD(), dtodesc.getUbicacionD(), dtodesc.getPuestoD(), 
           dtodesc.getImgfondoD(),   dtodesc.getImgperfilD(), dtodesc.getInfoD(), dtodesc.getInfosD());
        sDescripcion.save(descripcion);
        
        return new ResponseEntity(new Mensaje("Información agregada"), HttpStatus.OK);
    }
   
   @PutMapping("/update/{id}")
   public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoDescripcion dtodesc){
       if(!sDescripcion.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
       if(sDescripcion.existsByNombreD(dtodesc.getNombreD())&& sDescripcion.getByNombreD(dtodesc.getNombreD()).get().getId() !=id) 
           return new ResponseEntity(new Mensaje("Esa tarjeta ya existe"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(dtodesc.getNombreD()))
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtodesc.getImgperfilD()))
           return new ResponseEntity(new Mensaje("La imagen de perfil es obligatoria"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(dtodesc.getImgfondoD()))
           return new ResponseEntity(new Mensaje("La imagen de fondo es obligatoria"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(dtodesc.getInfoD()))
           return new ResponseEntity(new Mensaje("Una frase descriptiva es obligatoria"), HttpStatus.BAD_REQUEST);
       
       Descripcion descripcion = sDescripcion.getOne(id).get();
       descripcion.setImgfondoD(dtodesc.getImgfondoD());
       descripcion.setImgperfilD(dtodesc.getImgperfilD());
       descripcion.setInfoD(dtodesc.getInfoD());
       descripcion.setInfosD(dtodesc.getInfosD());
       descripcion.setPuestoD(dtodesc.getPuestoD());
       descripcion.setUbicacionD(dtodesc.getUbicacionD());
       descripcion.setNombreD(dtodesc.getNombreD());
       
       sDescripcion.save(descripcion);
       return new ResponseEntity(new Mensaje("Sección About-me actualizada"), HttpStatus.OK);
   }
   
   @DeleteMapping("/detail/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id){
       if(!sDescripcion.existsById(id))
           return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
       
       Descripcion descripcion = sDescripcion.getOne(id).get();
       return new ResponseEntity(descripcion, HttpStatus.OK);
    }
   
   @GetMapping("/detail/{id}")
    public ResponseEntity<Descripcion> getById(@PathVariable("id") int id){
        if (!sDescripcion.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Descripcion descripcion = sDescripcion.getOne(id).get();
        return new ResponseEntity(descripcion, HttpStatus.OK);
    }
}
