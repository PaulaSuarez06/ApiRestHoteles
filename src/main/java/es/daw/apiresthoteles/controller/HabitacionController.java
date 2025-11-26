package es.daw.apiresthoteles.controller;


import es.daw.apiresthoteles.dto.HabitacionCrearDTO;
import es.daw.apiresthoteles.dto.HabitacionDTO;
import es.daw.apiresthoteles.service.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {

    private final HabitacionService habitacionService;

    @GetMapping("{codigoHotel}/buscar")
    public ResponseEntity<List<HabitacionDTO>> findAll(
            @PathVariable String codigoHotel,
            @RequestParam(required = false) Integer tamanoMinimo,
            @RequestParam(required = false) Double precioMinimo,
            @RequestParam(required = false) Double precioMaximo)
    {

        return ResponseEntity.ok(habitacionService.findAll(codigoHotel,tamanoMinimo,precioMinimo,precioMaximo));
    }


    @PostMapping("{codigoHotel}")
    public ResponseEntity<HabitacionDTO> crear (@RequestBody HabitacionCrearDTO habitacionCrearDTO, @PathVariable String codigoHotel){
        Optional<HabitacionDTO> habitacionCreada = habitacionService.crear(codigoHotel,habitacionCrearDTO);
        return habitacionCreada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(400).build());
    }
}
