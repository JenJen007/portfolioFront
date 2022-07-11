
package com.jcl.portfolio.Servicio;

import com.jcl.portfolio.DTO.EducacionRequestDTO;
import com.jcl.portfolio.DTO.EducacionResponseDTO;
import java.util.List;


public interface EducacionService {
    
    public List<EducacionResponseDTO> getAll();
    
    public EducacionResponseDTO save(EducacionRequestDTO educacionDTO);
    
    public EducacionResponseDTO findById(Long idEdu);
    
    public EducacionResponseDTO update(EducacionRequestDTO educacionDTO,Long idEdu);
    
    public void delete(Long idEdu);
}
