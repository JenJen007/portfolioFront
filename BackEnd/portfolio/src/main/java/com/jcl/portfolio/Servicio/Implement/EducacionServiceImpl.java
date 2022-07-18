
package com.jcl.portfolio.Servicio.Implement;

import com.jcl.portfolio.DTO.EducacionRequestDTO;
import com.jcl.portfolio.DTO.EducacionResponseDTO;
import com.jcl.portfolio.Excepcion.ResourceNotFoundException;
import com.jcl.portfolio.Models.Educacion;
import com.jcl.portfolio.Repositorio.EducacionRepository;
import com.jcl.portfolio.Servicio.EducacionService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionServiceImpl implements EducacionService{
    
    private final EducacionRepository educacionRepository;
    
    public EducacionServiceImpl(EducacionRepository educacionRepository){
        this.educacionRepository = educacionRepository;
    }
    
    private EducacionResponseDTO alDTO(Educacion educacion){
        return EducacionResponseDTO.builder().idEdu(educacion.getIdEdu())
                .nameEdu(educacion.getNameEdu()).titleEdu(educacion.getTitleEdu())
                .fechaEduIni(educacion.getFechaEduIni()).fechaEduFin(educacion.getFechaEduFin())
                .imgEdu(educacion.getImgEdu()).build();
    }
    
    private Educacion toEntity(EducacionRequestDTO educacionDTO){
        return Educacion.builder().nameEdu(educacionDTO.getNameEdu()).titleEdu(educacionDTO.getTitleEdu())
                .fechaEduIni(educacionDTO.getFechaEduIni()).fechaEduFin(educacionDTO.getFechaEduFin())
                .imgEdu(educacionDTO.getImgEdu()).build();
    }

    @Override
    public List<EducacionResponseDTO> getAll() {
         return educacionRepository.findAll().stream().map(edu -> alDTO(edu)).collect(Collectors.toList());
    }

    @Override
    public EducacionResponseDTO save(EducacionRequestDTO educacionDTO) {
       Educacion newEducacion = this.educacionRepository.save(toEntity(educacionDTO));
       return alDTO(newEducacion);
    }

    @Override
    public EducacionResponseDTO findById(Long idEdu) {
       Educacion educacion = this.educacionRepository.findById(idEdu).orElseThrow(() -> new ResourceNotFoundException("id no encontrado"));
       return alDTO(educacion);
    }

    @Override
    public EducacionResponseDTO update(EducacionRequestDTO educacionDTO, Long idEdu) {
    return this.educacionRepository.findById(idEdu).map(educacion -> {
        educacion.setNameEdu(educacionDTO.getNameEdu());
        educacion.setTitleEdu(educacionDTO.getTitleEdu());
        educacion.setFechaEduIni(educacionDTO.getFechaEduIni());
        educacion.setFechaEduFin(educacionDTO.getFechaEduFin());
        educacion.setImgEdu(educacionDTO.getImgEdu());
        return alDTO(educacionRepository.save(educacion));
    }).orElseGet(() -> {
        Educacion newEducacion = toEntity(educacionDTO);
        newEducacion.setIdEdu(idEdu);
        return alDTO(this.educacionRepository.save(newEducacion));
    });
    }

    @Override
    public void delete(Long idEdu) {
       this.educacionRepository.deleteById(idEdu);
    }
}
