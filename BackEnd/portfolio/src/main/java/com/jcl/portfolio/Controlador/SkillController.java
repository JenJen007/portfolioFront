
package com.jcl.portfolio.Controlador;

import com.jcl.portfolio.DTO.SkillRequestDTO;
import com.jcl.portfolio.DTO.SkillResponseDTO;
import com.jcl.portfolio.Servicio.SkillService;
import java.util.List;
import javax.validation.Valid;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SkillController {
      @Autowired
    private final SkillService skillService;
    
    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }
    
    @GetMapping("/skills")
    public ResponseEntity<List<SkillResponseDTO>>all(){
        List<SkillResponseDTO>listaSkill = skillService.getAll();
        return new ResponseEntity(listaSkill,HttpStatus.OK);
    }
    
    @GetMapping("/skills/{idSkill}")
    public ResponseEntity<SkillResponseDTO>oneSkill(@PathVariable("idSkill")Long idSkill){
        SkillResponseDTO skillId = skillService.findById(idSkill);
        return ResponseEntity.ok().body(skillId);
    }
    
    @PostMapping("/skills/nueva")
    public ResponseEntity<SkillResponseDTO>newSkill(@Valid @RequestBody SkillRequestDTO newSkill){
        try {
            return new ResponseEntity<>(skillService.save(newSkill),HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/skills/{idSkill}")
    public SkillResponseDTO replaceSkill(@Valid @RequestBody SkillRequestDTO newSkill,
                                               @PathVariable("idSkill")Long idSkill){
        return skillService.update(newSkill, idSkill);
    }
    
    @DeleteMapping("/skills/{idSkill}")
    public void deleteSkill(@PathVariable("idSkill")Long idSkill){
        skillService.delete(idSkill);
    }
    
}
