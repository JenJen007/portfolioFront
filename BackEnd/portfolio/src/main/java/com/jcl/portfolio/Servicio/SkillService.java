
package com.jcl.portfolio.Servicio;

import com.jcl.portfolio.DTO.SkillRequestDTO;
import com.jcl.portfolio.DTO.SkillResponseDTO;
import java.util.List;


public interface SkillService {
      public List<SkillResponseDTO> getAll();

    public SkillResponseDTO save(SkillRequestDTO skillDTO);

    public SkillResponseDTO findById(Long idSkill);

    public SkillResponseDTO update(SkillRequestDTO skillDTO, Long idSkill);

    public void delete(Long idSkill);
}
