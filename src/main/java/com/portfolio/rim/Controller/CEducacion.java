
package com.portfolio.rim.Controller;

import com.portfolio.rim.Dto.dtoEducacion;
import com.portfolio.rim.Entity.Educacion;
import com.portfolio.rim.Security.Controller.Mensaje;
import com.portfolio.rim.Service.SEducacion;
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
@RequestMapping("/educ")
//CrossOrigin(origins = {"http://localhost:4200", "https://frontend-argpro-50ba2.web.app"})
@CrossOrigin(origins = "https://frontend-argpro-50ba2.web.app")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeduc){
        if(StringUtils.isBlank(dtoeduc.getNombreEd()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByNombreEd(dtoeduc.getNombreEd()))
            return new ResponseEntity(new Mensaje("Esta tarjeta ya existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoeduc.getNombreEd(), dtoeduc.getTituloEd(), dtoeduc.getYearEd(), dtoeduc.getImgEd());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Tarjeta de educación agregada"), HttpStatus.OK);
    }
     
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeduc){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByNombreEd(dtoeduc.getNombreEd()) && sEducacion.getByNombreEd(dtoeduc.getNombreEd()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Esa tarjeta ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeduc.getNombreEd()))  
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEd(dtoeduc.getNombreEd());
        educacion.setTituloEd(dtoeduc.getTituloEd());
        educacion.setYearEd(dtoeduc.getYearEd());
        educacion.setImgEd(dtoeduc.getImgEd());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Tarjeta actualizada"), HttpStatus.OK);
    }
     
      @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el ID
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
        
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if (!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }    
    
}
