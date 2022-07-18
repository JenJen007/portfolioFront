
package com.jcl.portfolio.Controlador;

import com.jcl.portfolio.DTO.ExperienciaRequestDTO;
import com.jcl.portfolio.DTO.ExperienciaResponseDTO;
import com.jcl.portfolio.Servicio.ExperienciaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class ExperienciaController {
    @Autowired
    private final ExperienciaService experienciaService;
    
    public ExperienciaController(ExperienciaService experienciaService){
        this.experienciaService = experienciaService;
    }
    
    @GetMapping("experiencias")
    public ResponseEntity<List<ExperienciaResponseDTO>>all(){
        List<ExperienciaResponseDTO>listaExperiencia = experienciaService.getAll();
        return new ResponseEntity(listaExperiencia,HttpStatus.OK);
    }
    
    @GetMapping("/experiencias/{idExp}")
    public ResponseEntity<ExperienciaResponseDTO>oneExperiencia(@PathVariable("idExp")Long idExp){
        ExperienciaResponseDTO experienciaId = experienciaService.findById(idExp);
        return ResponseEntity.ok().body(experienciaId);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencias/nueva")
    public ResponseEntity<ExperienciaResponseDTO>newExperiencia(@Valid @RequestBody ExperienciaRequestDTO newExperiencia){
        try {
            return new ResponseEntity<>(experienciaService.save(newExperiencia),HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experiencias/{idExp}")
    public ExperienciaResponseDTO replaceExperiencia(@Valid @RequestBody ExperienciaRequestDTO newExperiencia,
                                                        @PathVariable("idExp")Long idExp){
        return experienciaService.update(newExperiencia, idExp);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencias/{idExp}")
    public void deleteExperiencia(@PathVariable("idExp")Long idExp){
        experienciaService.delete(idExp);
    }
}
