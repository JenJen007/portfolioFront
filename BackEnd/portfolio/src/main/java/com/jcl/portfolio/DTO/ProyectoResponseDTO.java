
package com.jcl.portfolio.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProyectoResponseDTO extends ProyectoRequestDTO{
    private Long idProye;
    
    @Builder
    public ProyectoResponseDTO(String nameProye,String descripProye,String enlaceProye,int fechaProye,String imgProye,Long idProye){
        super(nameProye,descripProye,enlaceProye,fechaProye,imgProye);
        this.idProye = idProye;
    }
}
