package es.daw.apiresthoteles.controller;


import es.daw.apiresthoteles.dto.HotelDTO;
import es.daw.apiresthoteles.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hoteles") //esto es la raiz de la api
@RequiredArgsConstructor
public class HotelController {

private final HotelService hotelService;


@GetMapping
    public ResponseEntity<List<HotelDTO>> findAll(){
    return ResponseEntity.ok(hotelService.findAll());
}


}
