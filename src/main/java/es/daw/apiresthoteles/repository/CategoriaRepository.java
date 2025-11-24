package es.daw.apiresthoteles.repository;

import es.daw.apiresthoteles.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
