package es.daw.apiresthoteles.service;


import es.daw.apiresthoteles.dto.HotelDTO;
import es.daw.apiresthoteles.entity.Hotel;
import es.daw.apiresthoteles.mapper.HotelMapper;
import es.daw.apiresthoteles.repository.CategoriaRepository;
import es.daw.apiresthoteles.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

private final HotelRepository hotelRepository;
private final CategoriaRepository categoriaRepository;
private final HotelMapper hotelMapper;



    public List<HotelDTO> findAll(String codigoCategoria, String localidad){
        List<Hotel> hoteles;

        //filtrar por localidad
        if (localidad != null) {hoteles = hotelRepository.findByLocalidad(localidad);}
        //filtrar por categoria
        else if (codigoCategoria != null) {hoteles = hotelRepository.findByCategoria_Codigo(codigoCategoria);}
        else {hoteles = hotelRepository.findAll();}

        return hotelMapper.hotelListToHotelDTOList(hoteles);
    }


}
