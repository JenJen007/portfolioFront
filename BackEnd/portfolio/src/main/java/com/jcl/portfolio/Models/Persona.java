
package com.jcl.portfolio.Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    @Column(name="apellido")
    private String apellido;

    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    @Column(name="domicilio")
    private String domicilio;

    @NotNull
    @Size(min = 1, max = 200, message = "no cumple con la longitud")
    @Column(name="email")
    private String email;

    @NotNull
    @Size(min = 1, max = 70, message = "no cumple con la longitud")
    @Column(name="titulo")
    private String titulo;

    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    @Column(name="about_me")
    private String aboutMe;

    @NotNull
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    @Column(name="foto_perfil")
    private String fotoPerfil;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencia> experienciaList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProye")
    private List<Proyecto> proyectoList;
    
    @Builder
    public Persona(String nombre,String apellido,String domicilio,String email,String titulo,String aboutMe,String fotoPerfil){
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.email = email;
        this.titulo = titulo;
        this.aboutMe = aboutMe;
        this.fotoPerfil = fotoPerfil;
        
        
    }
}

