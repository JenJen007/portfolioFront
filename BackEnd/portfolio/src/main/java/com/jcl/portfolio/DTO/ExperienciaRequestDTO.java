
package com.jcl.portfolio.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExperienciaRequestDTO {
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nameExp;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String cargoExp;
    
    @NotNull
    @Size(min = 1, max = 1500, message = "no cumple con la longitud")
    private String logrosExp;
    
    @NotNull
    private int fechaExpIni;
    
    @NotNull
    private int fechaExpFin;
    
    
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    private String imgExp;
}
