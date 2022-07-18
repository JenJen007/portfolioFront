
package com.jcl.portfolio.Controlador;

import com.jcl.portfolio.DTO.PersonaRequestDTO;
import com.jcl.portfolio.DTO.PersonaResponseDTO;
import com.jcl.portfolio.Servicio.PersonaService;
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
public class PersonaController {
    @Autowired
    private final PersonaService personaService;
    
    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }
   
    @GetMapping("/personas")
    public ResponseEntity<List<PersonaResponseDTO>>all(){
        List<PersonaResponseDTO>listaPersona = personaService.getAll();
        return new ResponseEntity(listaPersona,HttpStatus.OK);
    }
  
    @GetMapping("/personas/{idUser}")
    public ResponseEntity<PersonaResponseDTO>onePersona(@PathVariable("idUser")Long idUser){
        PersonaResponseDTO personaId = personaService.findById(idUser);
        return ResponseEntity.ok().body(personaId);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/nueva")
    public ResponseEntity<PersonaResponseDTO>newPersona(@Valid @RequestBody PersonaRequestDTO newPersona){
        try {
            return new ResponseEntity<>(personaService.save(newPersona),HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/{idUser}")
    public PersonaResponseDTO replacePersona(@Valid @RequestBody PersonaRequestDTO newPersona,
                                               @PathVariable("idUser")Long idUser){
        return personaService.update(newPersona, idUser);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/{idUser}")
    public void deletePersona(@PathVariable("idUser")Long idUser){
        personaService.delete(idUser);
    }
    
    
}
