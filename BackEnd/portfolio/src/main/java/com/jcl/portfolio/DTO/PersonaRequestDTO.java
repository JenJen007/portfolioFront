
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
public class PersonaRequestDTO {

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;

    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    private String domicilio;

    @NotNull
    @Size(min = 1, max = 200, message = "no cumple con la longitud")
    private String email;

    @NotNull
    @Size(min = 1, max = 70, message = "no cumple con la longitud")
    private String titulo;

    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    private String aboutMe;

    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    private String fotoPerfil;

}
