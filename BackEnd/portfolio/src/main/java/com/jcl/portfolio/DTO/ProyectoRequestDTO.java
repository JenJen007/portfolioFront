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
public class ProyectoRequestDTO {

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nameProye;

    @NotNull
    @Size(min = 1, max = 500, message = "no cumple con la longitud")
    private String descripProye;

    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    private String enlaceProye;

    @NotNull
    private int fechaProye;

    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    private String imgProye;
}
