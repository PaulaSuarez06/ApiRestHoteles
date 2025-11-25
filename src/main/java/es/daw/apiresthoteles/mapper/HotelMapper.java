package es.daw.apiresthoteles.mapper;


import es.daw.apiresthoteles.dto.HotelDTO;
import es.daw.apiresthoteles.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    @Mapping(source="categoria", target="categoria")
    HotelDTO hotelToHotelDTO(Hotel hotel);

    @Mapping(target="categoria", ignore = true)
    Hotel hotelDTOToHotel(HotelDTO hotelDTO);

    List<HotelDTO> hotelListToHotelDTOList(List<Hotel> hotelList);
    List<Hotel> hotelDTOListToHotelList(List<HotelDTO> hotelDTOList);
}
