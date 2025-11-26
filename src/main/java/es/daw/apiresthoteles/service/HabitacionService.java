package es.daw.apiresthoteles.service;


import es.daw.apiresthoteles.dto.HabitacionDTO;
import es.daw.apiresthoteles.entity.Habitacion;
import es.daw.apiresthoteles.mapper.HabitacionMapper;
import es.daw.apiresthoteles.repository.HabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;
    private final HabitacionMapper habitacionMapper;

//--> lista con todas las habitaciones libres del hotel
    public List<HabitacionDTO> findAll(String codigoHotel, Integer tamanoMinimo, Double precioMinimo, Double precioMaximo){
        List<Habitacion> habitaciones = habitacionRepository.findByHotel_CodigoAndOcupadaFalse(codigoHotel);

//--> filtrar por tamano y precio

        if(tamanoMinimo != null){
            habitaciones = habitaciones.stream().filter(h -> h.getTamano() >= tamanoMinimo).toList();
        }

        if(precioMinimo != null){
            habitaciones = habitaciones.stream().filter(h -> h.getPrecio_noche() >= precioMinimo).toList();
        }

        if(precioMaximo != null){
            habitaciones = habitaciones.stream().filter(h -> h.getPrecio_noche() <= precioMaximo).toList();
        }

        return habitacionMapper.habitacionListToHabitacionDTOList(habitaciones);

    }

}
