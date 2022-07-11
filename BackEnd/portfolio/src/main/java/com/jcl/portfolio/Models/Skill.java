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
@Table(name = "skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skill")
    private Long idSkill;
    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    @Column(name = "img_skill")
    private String imgSkill;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    @Column(name = "porcentaje")
    private int porcentaje;

    @Builder
    public Skill(String imgSkill, int porcentaje){
        this.idSkill = idSkill;
        this.imgSkill = imgSkill;
        this.porcentaje = porcentaje;
    }
}
