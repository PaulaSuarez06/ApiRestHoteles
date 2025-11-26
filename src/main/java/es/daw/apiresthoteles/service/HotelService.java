package es.daw.apiresthoteles.service;


import es.daw.apiresthoteles.dto.HotelCrearDTO;
import es.daw.apiresthoteles.dto.HotelDTO;
import es.daw.apiresthoteles.entity.Categoria;
import es.daw.apiresthoteles.entity.Hotel;
import es.daw.apiresthoteles.mapper.HotelMapper;
import es.daw.apiresthoteles.repository.CategoriaRepository;
import es.daw.apiresthoteles.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<HotelDTO> crear(HotelCrearDTO hotelDTO){
        // Validar que la categoria existe
        Categoria categoria = categoriaRepository
                .findByCodigo(hotelDTO.getCategoriaCodigo())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        Hotel hotel = new Hotel();
        hotel.setCodigo(hotelDTO.getCodigo());
        hotel.setNombre(hotelDTO.getNombre());
        hotel.setDescripcion(hotelDTO.getDescripcion());
        hotel.setPiscina(hotelDTO.getPiscina());
        hotel.setLocalidad(hotelDTO.getLocalidad());
        hotel.setCategoria(categoria);

        Hotel saved = hotelRepository.save(hotel);
        return Optional.of(hotelMapper.hotelToHotelDTO(saved));

    }


}
