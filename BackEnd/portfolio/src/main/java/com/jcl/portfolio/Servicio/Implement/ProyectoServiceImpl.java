
package com.jcl.portfolio.Servicio.Implement;

import com.jcl.portfolio.DTO.ProyectoRequestDTO;
import com.jcl.portfolio.DTO.ProyectoResponseDTO;
import com.jcl.portfolio.Excepcion.ResourceNotFoundException;
import com.jcl.portfolio.Models.Proyecto;
import com.jcl.portfolio.Repositorio.ProyectoRepository;
import com.jcl.portfolio.Servicio.ProyectoService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoServiceImpl implements ProyectoService{
    
    private final ProyectoRepository proyectoRepository;
    
    public ProyectoServiceImpl(ProyectoRepository proyectoRepository){
        this.proyectoRepository = proyectoRepository;
    }
    
    private ProyectoResponseDTO alDTO(Proyecto proyecto){
        return ProyectoResponseDTO.builder().idProye(proyecto.getIdProye())
                .nameProye(proyecto.getNameProye()).descripProye(proyecto.getDescripProye())
                .enlaceProye(proyecto.getEnlaceProye()).fechaProye(proyecto.getFechaProye())
                .imgProye(proyecto.getImgProye()).build();
    }
    
    private Proyecto toEntity(ProyectoRequestDTO proyectoDTO){
        return Proyecto.builder().nameProye(proyectoDTO.getNameProye())
                .descripProye(proyectoDTO.getDescripProye()).enlaceProye(proyectoDTO.getEnlaceProye())
                .fechaProye(proyectoDTO.getFechaProye()).imgProye(proyectoDTO.getImgProye()).build();
    }

    @Override
    public List<ProyectoResponseDTO> getAll() {
       return proyectoRepository.findAll().stream().map(proy -> alDTO(proy)).collect(Collectors.toList());
    }

    @Override
    public ProyectoResponseDTO save(ProyectoRequestDTO proyectoDTO) {
        Proyecto newProyecto = this.proyectoRepository.save(toEntity(proyectoDTO));
        return alDTO(newProyecto);
    }

    @Override
    public ProyectoResponseDTO findById(Long idProye) {
        Proyecto proyecto = this.proyectoRepository.findById(idProye).orElseThrow(() -> new ResourceNotFoundException("id no encontrado"));
        return alDTO(proyecto);
    }

    @Override
    public ProyectoResponseDTO update(ProyectoRequestDTO proyectoDTO, Long idProye) {
        return this.proyectoRepository.findById(idProye).map(proyecto -> {
            proyecto.setNameProye(proyectoDTO.getNameProye());
            proyecto.setDescripProye(proyectoDTO.getDescripProye());
            proyecto.setEnlaceProye(proyectoDTO.getEnlaceProye());
            proyecto.setFechaProye(proyectoDTO.getFechaProye());
            proyecto.setImgProye(proyectoDTO.getImgProye());
            return alDTO(proyectoRepository.save(proyecto));
        }).orElseGet(() -> {
            Proyecto newProyecto = toEntity(proyectoDTO);
            return alDTO(this.proyectoRepository.save(newProyecto));
        });
    }

    @Override
    public void delete(Long idProye) {
        this.proyectoRepository.deleteById(idProye);
    }
}
