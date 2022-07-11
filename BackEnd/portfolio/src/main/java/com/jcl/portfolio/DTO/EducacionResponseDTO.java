
package com.jcl.portfolio.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EducacionResponseDTO extends EducacionRequestDTO{
    private Long idEdu;
    
    @Builder
    public EducacionResponseDTO(String nameEdu,String titleEdu,int fechaEduIni,int fechaEduFin,String imgEdu,Long idEdu){
        super(nameEdu,titleEdu,fechaEduIni,fechaEduFin,imgEdu);
        this.idEdu = idEdu;
    }
}
