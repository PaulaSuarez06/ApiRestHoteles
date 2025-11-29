package es.daw.apiresthoteles.service;


import es.daw.apiresthoteles.dto.HabitacionCrearDTO;
import es.daw.apiresthoteles.dto.HabitacionDTO;
import es.daw.apiresthoteles.entity.Habitacion;
import es.daw.apiresthoteles.entity.Hotel;
import es.daw.apiresthoteles.mapper.HabitacionMapper;
import es.daw.apiresthoteles.repository.HabitacionRepository;
import es.daw.apiresthoteles.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;
    private final HotelRepository hotelRepository;
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

    public Optional<HabitacionDTO> crear(String codigoHotel, HabitacionCrearDTO habitacionCrearDTO){
//---> me traigo del repo de hotel y busco que el codigo que me pase el usuario exista
        //y me coincida con el que existe en la base de datos del hotel
    Hotel hotel = hotelRepository
            .findByCodigo(codigoHotel)
            .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));

    Habitacion habitacion = new Habitacion();
    // creo el entity y lo voy agregando al dto
    habitacion.setCodigo(habitacionCrearDTO.getCodigo());
    habitacion.setTamano(habitacionCrearDTO.getTamano());
    habitacion.setDoble(habitacionCrearDTO.getDoble());
    habitacion.setPrecio_noche(habitacionCrearDTO.getPrecio_noche());
    habitacion.setIncluye_desayuno(habitacionCrearDTO.getIncluye_desayuno());
    habitacion.setOcupada(false);
    habitacion.setHotel(hotel); //---> le asigno el hotel que me paso el usuario


    // Lo guardo en el repositorio
        Habitacion guardada = habitacionRepository.save(habitacion);
        return Optional.of(habitacionMapper.habitacionToHabitacionDTO(guardada));


    }

    public void delete(String codigoHabitacion){
        Habitacion habitacion = habitacionRepository.findByCodigo(codigoHabitacion)
                .orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));
        habitacionRepository.delete(habitacion);

    }

    public HabitacionDTO ocuparHabitacion(String codigoHabitacion){
        Habitacion habitacion = habitacionRepository.findByCodigo(codigoHabitacion)
                .orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));

        habitacion.setOcupada(true);
        return habitacionMapper.habitacionToHabitacionDTO(habitacionRepository.save(habitacion));

    }

}
