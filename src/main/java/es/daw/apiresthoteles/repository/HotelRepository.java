package es.daw.apiresthoteles.repository;

import es.daw.apiresthoteles.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, String> {
    List<Hotel> findByLocalidad(String localidad);
    List<Hotel> findByCategoria_Codigo(String codigoCategoria);
    Optional<Hotel> findByCodigo(String codigo);


}
