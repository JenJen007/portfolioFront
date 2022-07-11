
package com.jcl.portfolio.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExperienciaResponseDTO extends ExperienciaRequestDTO{
    
    private Long idExp;
    
    @Builder
    public ExperienciaResponseDTO(String nameExp,String cargoExp,String logrosExp,int fechaExpIni,int fechaExpFin,String imgExp,Long idExp){
        super(nameExp,cargoExp,logrosExp,fechaExpIni,fechaExpFin,imgExp);
        this.idExp = idExp;
    }
    
}
