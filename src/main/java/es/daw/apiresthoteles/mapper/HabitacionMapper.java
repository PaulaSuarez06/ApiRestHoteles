package es.daw.apiresthoteles.mapper;


import es.daw.apiresthoteles.dto.HabitacionDTO;
import es.daw.apiresthoteles.entity.Habitacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HabitacionMapper {

    @Mapping(source="hotel.codigo", target="hotelCodigo")
    HabitacionDTO habitacionToHabitacionDTO(Habitacion habitacion);
    @Mapping(target="hotel", ignore = true)
    Habitacion habitacionDTOToHabitacion(HabitacionDTO habitacionDTO);

    List<HabitacionDTO> habitacionListToHabitacionDTOList(List<Habitacion> habitacionList);
    List<Habitacion> habitacionDTOListToHabitacionList(List<HabitacionDTO> habitacionDTOList);
}
