package es.daw.apiresthoteles.controller;


import es.daw.apiresthoteles.dto.HotelCrearDTO;
import es.daw.apiresthoteles.dto.HotelDTO;
import es.daw.apiresthoteles.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hoteles") //esto es la raiz de la api
@RequiredArgsConstructor
public class HotelController {

private final HotelService hotelService;


@GetMapping("/buscar")
    public ResponseEntity <List<HotelDTO>> buscar (@RequestParam(required = false) String codigoCategoria,
                                                   @RequestParam(required = false) String localidad){
    return ResponseEntity.ok(hotelService.findAll(codigoCategoria,localidad));

}

@PostMapping
    public ResponseEntity<HotelDTO> crear(@RequestBody HotelCrearDTO hotelCrearDTO){
        Optional<HotelDTO> hotelCreado = hotelService.crear(hotelCrearDTO);
        // me manda en el body el hoteldto personalizado, me lo guardo en el hotelcreado y llamo al servicio
    // para que me haga toda la conversion de hoteldto a hotel y guardarlo en la bd
        return hotelCreado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());


}

}
