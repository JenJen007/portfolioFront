
package com.jcl.portfolio.Controlador;

import com.jcl.portfolio.DTO.ProyectoRequestDTO;
import com.jcl.portfolio.DTO.ProyectoResponseDTO;
import com.jcl.portfolio.Servicio.ProyectoService;
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
public class ProyectoController {
    @Autowired
    private final ProyectoService proyectoService;
    
    public ProyectoController(ProyectoService proyectoService){
        this.proyectoService = proyectoService;
    }
    
     @GetMapping("/proyectos")
    public ResponseEntity<List<ProyectoResponseDTO>>all(){
        List<ProyectoResponseDTO>listaProyecto = proyectoService.getAll();
        return new ResponseEntity(listaProyecto,HttpStatus.OK);
    }
    
    @GetMapping("/royectos/{idProye}")
    public ResponseEntity<ProyectoResponseDTO>oneProyecto(@PathVariable("idProye")Long idProye){
        ProyectoResponseDTO proyectoId = proyectoService.findById(idProye);
        return ResponseEntity.ok().body(proyectoId);
    }
    
    @PostMapping("/proyectos/nuevo")
    public ResponseEntity<ProyectoResponseDTO>newProyecto(@Valid @RequestBody ProyectoRequestDTO newProyecto){
        try {
            return new ResponseEntity<>(proyectoService.save(newProyecto),HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/proyectos/{idProye}")
    public ProyectoResponseDTO replaceProyecto(@Valid @RequestBody ProyectoRequestDTO newProyecto,
                                               @PathVariable("idProye")Long idProye){
        return proyectoService.update(newProyecto, idProye);
    }
    
    @DeleteMapping("/proyectos/{idProye}")
    public void deleteProyecto(@PathVariable("idProye")Long idProye){
        proyectoService.delete(idProye);
    }
    
}
