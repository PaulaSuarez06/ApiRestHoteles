package es.daw.apiresthoteles.repository;

import es.daw.apiresthoteles.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    //--> buscar habitacion libre por codigo hotel y libre
    List<Habitacion> findByHotel_CodigoAndOcupadaFalse(String codigoHotel);


}
