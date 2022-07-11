
package com.jcl.portfolio.Servicio.Implement;

import com.jcl.portfolio.DTO.SkillRequestDTO;
import com.jcl.portfolio.DTO.SkillResponseDTO;
import com.jcl.portfolio.Excepcion.ResourceNotFoundException;
import com.jcl.portfolio.Models.Skill;
import com.jcl.portfolio.Repositorio.SkillRepository;
import com.jcl.portfolio.Servicio.SkillService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService{
    
    private final SkillRepository skillRepository;
    
    public SkillServiceImpl(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }
    
    private SkillResponseDTO alDTO(Skill skill){
        return SkillResponseDTO.builder().idSkill(skill.getIdSkill())
                .imgSkill(skill.getImgSkill()).porcentaje(skill.getPorcentaje()).build();
    }
    
    private Skill toEntity(SkillRequestDTO skillDTO){
        return Skill.builder().imgSkill(skillDTO.getImgSkill())
                .porcentaje(skillDTO.getPorcentaje()).build();
    }

    @Override
    public List<SkillResponseDTO> getAll() {
       return skillRepository.findAll().stream().map(sk -> alDTO(sk)).collect(Collectors.toList());
    }

    @Override
    public SkillResponseDTO save(SkillRequestDTO skillDTO) {
        Skill newSkill = this.skillRepository.save(toEntity(skillDTO));
        return alDTO(newSkill);
    }

    @Override
    public SkillResponseDTO findById(Long idSkill) {
        Skill skill = this.skillRepository.findById(idSkill).orElseThrow(() -> new ResourceNotFoundException("id no encontrado"));
        return alDTO(skill);
    }

    @Override
    public SkillResponseDTO update(SkillRequestDTO skillDTO, Long idSkill) {
        return this.skillRepository.findById(idSkill).map(skill -> {
            skill.setImgSkill(skillDTO.getImgSkill());
            skill.setPorcentaje(skillDTO.getPorcentaje());
            return alDTO(skillRepository.save(skill));
        }).orElseGet(() -> {
            Skill newSkill = toEntity(skillDTO);
            newSkill.setIdSkill(idSkill);
            return alDTO(this.skillRepository.save(newSkill));
        });
    }

    @Override
    public void delete(Long idSkill) {
        this.skillRepository.deleteById(idSkill);
    }
}
