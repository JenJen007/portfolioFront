
package com.jcl.portfolio.Servicio;

import com.jcl.portfolio.DTO.ProyectoRequestDTO;
import com.jcl.portfolio.DTO.ProyectoResponseDTO;
import java.util.List;


public interface ProyectoService {
    
     public List<ProyectoResponseDTO> getAll();

    public ProyectoResponseDTO save(ProyectoRequestDTO proyectoDTO);

    public ProyectoResponseDTO findById(Long idProye);

    public ProyectoResponseDTO update(ProyectoRequestDTO proyectoDTO, Long idProye);

    public void delete(Long idProye);
}
