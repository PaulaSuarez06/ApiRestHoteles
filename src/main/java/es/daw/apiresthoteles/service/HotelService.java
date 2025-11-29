package es.daw.apiresthoteles.service;


import es.daw.apiresthoteles.dto.HotelCrearDTO;
import es.daw.apiresthoteles.dto.HotelDTO;
import es.daw.apiresthoteles.entity.Categoria;
import es.daw.apiresthoteles.entity.Hotel;
import es.daw.apiresthoteles.exception.HotelNotFoundException;
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


    public List<HotelDTO> findAll(String codigoCategoria, String localidad) {
        List<Hotel> hoteles;

        //filtrar por localidad
        if (localidad != null) {
            hoteles = hotelRepository.findByLocalidad(localidad);
        }
        //filtrar por categoria
        else if (codigoCategoria != null) {
            hoteles = hotelRepository.findByCategoria_Codigo(codigoCategoria);
        } else {
            hoteles = hotelRepository.findAll();
        }

        return hotelMapper.hotelListToHotelDTOList(hoteles);
    }

    public Optional<HotelDTO> crear(HotelCrearDTO hotelDTO) {
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

        //me lo guardo como entity en el repositorio
        //lo DEVUELVO como dto SIEMPRE

    }

    public void delete(String codigoHotel) {

        Hotel hotel = hotelRepository.findByCodigo(codigoHotel)
                .orElseThrow(() -> new HotelNotFoundException(codigoHotel));
        hotelRepository.delete(hotel);

    }


    //no devuelvo nada
    public Optional<HotelDTO> actualizar(String codigoHotel, HotelCrearDTO hotelDTO) {
        Hotel hotel = hotelRepository.findByCodigo(codigoHotel)
                .orElseThrow(() -> new HotelNotFoundException(codigoHotel));


        //el nombre del hotel va a ser el nombre que venga del hoteldto
        hotel.setCodigo(hotelDTO.getCodigo());
        hotel.setNombre(hotelDTO.getNombre());
        hotel.setDescripcion(hotelDTO.getDescripcion());
        hotel.setPiscina(hotelDTO.getPiscina());
        hotel.setLocalidad(hotelDTO.getLocalidad());
        hotel.setCategoria(categoriaRepository.findByCodigo(hotelDTO.getCategoriaCodigo())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada")));

        Hotel hotelGuardado = hotelRepository.save(hotel);

        return Optional.of(hotelMapper.hotelToHotelDTO(hotelGuardado));
        // CUANDO HACEMOS PUT ACTUALIZAMOS TO DO EL OBJETO

    }

}
