
package com.jcl.portfolio.Repositorio;

import com.jcl.portfolio.Models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia,Long>{
    
}
