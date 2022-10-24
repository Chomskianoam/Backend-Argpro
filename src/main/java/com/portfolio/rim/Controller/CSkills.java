
package com.portfolio.rim.Controller;


import com.portfolio.rim.Dto.dtoSkills;
import com.portfolio.rim.Entity.Skills;
import com.portfolio.rim.Security.Controller.Mensaje;
import com.portfolio.rim.Service.SSkills;
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
@RequestMapping("/skills")
//CrossOrigin(origins = {"http://localhost:4200", "https://frontend-argpro-50ba2.web.app"})
@CrossOrigin(origins = "https://frontend-argpro-50ba2.web.app")
public class CSkills {
    @Autowired
    SSkills sSkills;

    @GetMapping("/lista")
   public ResponseEntity<List<Skills>> list(){
       List<Skills> list = sSkills.list();
       return new ResponseEntity(list, HttpStatus.OK);  
   }
   
   @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoSkills dtosk){
       if(StringUtils.isBlank(dtosk.getNombreS())) {
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
       if (sSkills.existsByNombreS(dtosk.getNombreS())) {
           return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
       }
       Skills skills = new Skills(dtosk.getNombreS(), dtosk.getPorcentaje());
       sSkills.save(skills);
       
       return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
   }
    
   @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtosk){
        if(!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sSkills.existsByNombreS(dtosk.getNombreS()) && sSkills.getByNombreS(dtosk.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtosk.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = sSkills.getOne(id).get();
        skills.setNombreS(dtosk.getNombreS());
        skills.setPorcentaje(dtosk.getPorcentaje());
        
    
        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

      @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
}
