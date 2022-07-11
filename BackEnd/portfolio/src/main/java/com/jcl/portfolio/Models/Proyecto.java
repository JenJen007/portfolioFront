
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
@Table(name="proyecto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proye")
    private Long idProye;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    @Column(name = "name_proye")
    private String nameProye;
    
    @NotNull
    @Size(min = 1, max = 500, message = "no cumple con la longitud")
    @Column(name = "descrip_proye")
    private String descripProye;
    
    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    @Column(name = "enlace_proye")
    private String enlaceProye;
    
    @NotNull
    @Column(name = "fecha_proye")
    private int fechaProye;
     
    
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    @Column(name = "img_proye")
    private String imgProye;
    
    @Builder
    public Proyecto(String nameProye,String descripProye,String enlaceProye,int fechaProye,String imgProye){
        this.idProye = idProye;
        this.nameProye = nameProye;
        this.descripProye = descripProye;
        this.enlaceProye = enlaceProye;
        this.fechaProye = fechaProye;
        this.imgProye = imgProye;
    }
}
