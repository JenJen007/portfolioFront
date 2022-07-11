
package com.jcl.portfolio.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="educacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Educacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_edu")
    private Long idEdu;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    @Column(name = "name_edu")
    private String nameEdu;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    @Column(name = "title_edu")
    private String titleEdu;

    @NotNull
    @Column(name = "fecha_edu_ini")
    private int fechaEduIni;

    @NotNull
    @Column(name = "fecha_edu_fin")
    private int fechaEduFin;

    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    @Column(name = "img_edu")
    private String imgEdu;
    
    @Builder
    public Educacion(String nameEdu,String titleEdu,int fechaEduIni,int fechaEduFin,String imgEdu){
        this.idEdu = idEdu;
        this.nameEdu = nameEdu;
        this.titleEdu = titleEdu;
        this.fechaEduIni = fechaEduIni;
        this.fechaEduFin = fechaEduFin;
        this.imgEdu = imgEdu;
    }
}
