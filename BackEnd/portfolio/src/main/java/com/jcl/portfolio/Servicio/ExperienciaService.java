
package com.jcl.portfolio.Servicio;

import com.jcl.portfolio.DTO.ExperienciaRequestDTO;
import com.jcl.portfolio.DTO.ExperienciaResponseDTO;
import java.util.List;


public interface ExperienciaService {
    
    public List<ExperienciaResponseDTO> getAll();

    public ExperienciaResponseDTO save(ExperienciaRequestDTO experienciaDTO);

    public ExperienciaResponseDTO findById(Long idExp);

    public ExperienciaResponseDTO update(ExperienciaRequestDTO experienciaDTO, Long idExp);

    public void delete(Long idExp);
}
