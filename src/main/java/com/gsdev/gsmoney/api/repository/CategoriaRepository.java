package com.gsdev.gsmoney.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gsdev.gsmoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
