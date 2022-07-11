
package com.jcl.portfolio.Servicio.Implement;

import com.jcl.portfolio.DTO.PersonaRequestDTO;
import com.jcl.portfolio.DTO.PersonaResponseDTO;
import com.jcl.portfolio.Excepcion.ResourceNotFoundException;
import com.jcl.portfolio.Models.Persona;
import com.jcl.portfolio.Repositorio.PersonaRepository;
import com.jcl.portfolio.Servicio.PersonaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{
    
    private final PersonaRepository personaRepository;
    
    public PersonaServiceImpl(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
    
    private PersonaResponseDTO alDTO(Persona persona){
        return PersonaResponseDTO.builder().idUser(persona.getIdUser())
                .nombre(persona.getNombre()).apellido(persona.getApellido())
                .domicilio(persona.getDomicilio()).email(persona.getEmail())
                .titulo(persona.getTitulo()).aboutMe(persona.getAboutMe())
                .fotoPerfil(persona.getFotoPerfil()).build();
    }
    
    private Persona toEntity(PersonaRequestDTO personaDTO){
        return Persona.builder().nombre(personaDTO.getNombre()).apellido(personaDTO.getApellido())
                .domicilio(personaDTO.getDomicilio()).email(personaDTO.getEmail())
                .titulo(personaDTO.getTitulo()).aboutMe(personaDTO.getAboutMe())
                .fotoPerfil(personaDTO.getFotoPerfil()).build();
    }

    @Override
    public List<PersonaResponseDTO> getAll() {
        return personaRepository.findAll().stream().map(per -> alDTO(per)).collect(Collectors.toList());
    }

    @Override
    public PersonaResponseDTO save(PersonaRequestDTO personaDTO) {
        Persona newPersona = this.personaRepository.save(toEntity(personaDTO));
        return alDTO(newPersona);
    }

    @Override
    public PersonaResponseDTO findById(Long idUser) {
        Persona persona = this.personaRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("id no encontrado"));
        return alDTO(persona);
    }

    @Override
    public PersonaResponseDTO update(PersonaRequestDTO personaDTO, Long idUser) {
       return this.personaRepository.findById(idUser).map(persona -> {
           persona.setNombre(personaDTO.getNombre());
           persona.setApellido(personaDTO.getApellido());
           persona.setDomicilio(personaDTO.getDomicilio());
           persona.setEmail(personaDTO.getEmail());
           persona.setTitulo(personaDTO.getTitulo());
           persona.setAboutMe(personaDTO.getAboutMe());
           persona.setFotoPerfil(personaDTO.getFotoPerfil());
           return alDTO(personaRepository.save(persona));
       }).orElseGet(() -> {
           Persona newPersona = toEntity(personaDTO);
           newPersona.setIdUser(idUser);
           return alDTO(this.personaRepository.save(newPersona));
       });
    }

    @Override
    public void delete(Long idUser) {
        this.personaRepository.deleteById(idUser);
    }
}
