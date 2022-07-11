package com.jcl.portfolio.Servicio;

import com.jcl.portfolio.DTO.PersonaRequestDTO;
import com.jcl.portfolio.DTO.PersonaResponseDTO;
import java.util.List;

public interface PersonaService {

    public List<PersonaResponseDTO> getAll();

    public PersonaResponseDTO save(PersonaRequestDTO personaDTO);

    public PersonaResponseDTO findById(Long idUser);

    public PersonaResponseDTO update(PersonaRequestDTO personaDTO, Long idUser);

    public void delete(Long idUser);
}
