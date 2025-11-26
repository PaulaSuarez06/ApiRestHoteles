package es.daw.apiresthoteles.repository;

import es.daw.apiresthoteles.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByCodigo(String codigo);
}
