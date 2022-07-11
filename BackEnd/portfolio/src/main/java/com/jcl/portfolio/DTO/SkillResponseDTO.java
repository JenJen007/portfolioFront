
package com.jcl.portfolio.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SkillResponseDTO extends SkillRequestDTO{
    private Long idSkill;
    
    @Builder
    public SkillResponseDTO(String imgSkill,int porcentaje,Long idSkill){
        super(imgSkill,porcentaje);
        this.idSkill = idSkill;
    }
}
