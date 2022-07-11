
package com.jcl.portfolio.Servicio.Implement;

import com.jcl.portfolio.DTO.ExperienciaRequestDTO;
import com.jcl.portfolio.DTO.ExperienciaResponseDTO;
import com.jcl.portfolio.Excepcion.ResourceNotFoundException;
import com.jcl.portfolio.Models.Experiencia;
import com.jcl.portfolio.Repositorio.ExperienciaRepository;
import com.jcl.portfolio.Servicio.ExperienciaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaServiceImpl implements ExperienciaService{
    
    private final ExperienciaRepository experienciaRepository;
    
    public ExperienciaServiceImpl(ExperienciaRepository experienciaRepository){
        this.experienciaRepository = experienciaRepository;
    }
    
    private ExperienciaResponseDTO alDTO(Experiencia experiencia){
        return ExperienciaResponseDTO.builder().idExp(experiencia.getIdExp())
                .nameExp(experiencia.getNameExp()).cargoExp(experiencia.getCargoExp())
                .logrosExp(experiencia.getLogrosExp()).fechaExpIni(experiencia.getFechaExpIni())
                .fechaExpFin(experiencia.getFechaExpFin()).imgExp(experiencia.getImgExp()).build();
    }
    
    private Experiencia toEntity(ExperienciaRequestDTO experienciaDTO){
        return Experiencia.builder().nameExp(experienciaDTO.getNameExp())
                .cargoExp(experienciaDTO.getCargoExp()).logrosExp(experienciaDTO.getLogrosExp())
                .fechaExpIni(experienciaDTO.getFechaExpIni()).fechaExpFin(experienciaDTO.getFechaExpFin())
                .imgExp(experienciaDTO.getImgExp()).build();
    }

    @Override
    public List<ExperienciaResponseDTO> getAll() {
       return experienciaRepository.findAll().stream().map(exp -> alDTO(exp)).collect(Collectors.toList());
    }

    @Override
    public ExperienciaResponseDTO save(ExperienciaRequestDTO experienciaDTO) {
        Experiencia newExperiencia = this.experienciaRepository.save(toEntity(experienciaDTO));
        return alDTO(newExperiencia);
    }

    @Override
    public ExperienciaResponseDTO findById(Long idExp) {
      Experiencia experiencia = this.experienciaRepository.findById(idExp).orElseThrow(() -> new ResourceNotFoundException("id no encontrado"));
      return alDTO(experiencia);
    }

    @Override
    public ExperienciaResponseDTO update(ExperienciaRequestDTO experienciaDTO, Long idExp) {
      return this.experienciaRepository.findById(idExp).map(experiencia -> {
          experiencia.setNameExp(experienciaDTO.getNameExp());
          experiencia.setCargoExp(experienciaDTO.getCargoExp());
          experiencia.setLogrosExp(experienciaDTO.getLogrosExp());
          experiencia.setFechaExpIni(experienciaDTO.getFechaExpIni());
          experiencia.setFechaExpFin(experienciaDTO.getFechaExpFin());
          experiencia.setImgExp(experienciaDTO.getImgExp());
          return alDTO(experienciaRepository.save(experiencia));
      }).orElseGet(() -> {
          Experiencia newExperiencia = toEntity(experienciaDTO);
          newExperiencia.setIdExp(idExp);
          return alDTO(this.experienciaRepository.save(newExperiencia));
      });
    }

    @Override
    public void delete(Long idExp) {
      this.experienciaRepository.deleteById(idExp);
    }
    
}
