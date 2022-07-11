
package com.jcl.portfolio.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonaResponseDTO extends PersonaRequestDTO{
    private Long idUser;
    
    @Builder
    public PersonaResponseDTO(String nombre,String apellido,String domicilio,String email,String titulo,String aboutMe,String fotoPerfil,Long idUser){
        super(nombre,apellido,domicilio,email,titulo,aboutMe,fotoPerfil);
        this.idUser = idUser;
    }
}
