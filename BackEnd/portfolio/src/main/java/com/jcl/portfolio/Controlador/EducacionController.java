package com.jcl.portfolio.Controlador;

import com.jcl.portfolio.DTO.EducacionRequestDTO;
import com.jcl.portfolio.DTO.EducacionResponseDTO;
import com.jcl.portfolio.Servicio.EducacionService;
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
public class EducacionController {

    @Autowired
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }

    @GetMapping("/educaciones")
    public ResponseEntity<List<EducacionResponseDTO>> all() {
        List<EducacionResponseDTO> listaEducacion = educacionService.getAll();
        return new ResponseEntity(listaEducacion, HttpStatus.OK);
    }

    @GetMapping("/educaciones/{idEdu}")
    public ResponseEntity<EducacionResponseDTO> oneEducacion(@PathVariable("idEdu") Long idEdu) {
        EducacionResponseDTO educacionId = educacionService.findById(idEdu);
        return ResponseEntity.ok().body(educacionId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/educaciones/nueva")
    public ResponseEntity<EducacionResponseDTO> newEducacion(@Valid @RequestBody EducacionRequestDTO newEducacion) {
        try {
            return new ResponseEntity<>(educacionService.save(newEducacion), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/educaciones/{idEdu}")
    public EducacionResponseDTO replaceEducacion(@Valid @RequestBody EducacionRequestDTO newEducacion,
            @PathVariable("idEdu") Long idEdu) {
        return educacionService.update(newEducacion, idEdu);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educaciones/{idEdu}")
    public void deleteEducacion(@PathVariable("idEdu") Long idEdu) {
        educacionService.delete(idEdu);
    }

}
