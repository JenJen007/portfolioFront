
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
public class EducacionRequestDTO {
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nameEdu;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String titleEdu;

    @NotNull
    private int fechaEduIni;

    @NotNull
    private int fechaEduFin;

    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    private String imgEdu;
}
