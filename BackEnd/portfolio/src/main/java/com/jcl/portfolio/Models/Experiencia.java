
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
@Table(name="experiencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experiencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exp")
    private Long idExp;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    @Column(name = "name_exp")
    private String nameExp;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    @Column(name = "cargo_exp")
    private String cargoExp;
    
    @NotNull
    @Size(min = 1, max = 1500, message = "no cumple con la longitud")
    @Column(name = "logros_exp")
    private String logrosExp;
    
    @NotNull
    @Column(name = "fecha_exp_ini")
    private int fechaExpIni;
    
    @NotNull
    @Column(name = "fecha_exp_fin")
    private int fechaExpFin;
    
    
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    @Column(name = "img_exp")
    private String imgExp;
    
    @Builder
    public Experiencia(String nameExp,String cargoExp,String logrosExp,String imgExp,int fechaExpIni,int fechaExpFin){
        this.idExp = idExp;
        this.nameExp = nameExp;
        this.cargoExp = cargoExp;
        this.logrosExp = logrosExp;
        this.fechaExpIni = fechaExpIni;
        this.fechaExpFin = fechaExpFin;
        this.imgExp = imgExp;
    }
    
}
