package es.daw.apiresthoteles.controller;


import es.daw.apiresthoteles.dto.HabitacionCrearDTO;
import es.daw.apiresthoteles.dto.HabitacionDTO;
import es.daw.apiresthoteles.service.HabitacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<HabitacionDTO> crear (@Valid @RequestBody HabitacionCrearDTO habitacionCrearDTO, @PathVariable String codigoHotel){
        Optional<HabitacionDTO> habitacionCreada = habitacionService.crear(codigoHotel,habitacionCrearDTO);
        return habitacionCreada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(400).build());
    }

    // no devolvemos nada para borrar
    //siempre usamos response entity
    // usamos pathvariable y tambien lo podemos validar
    //despues de crear el servicio lo llamo, pasandole como parametro el codigo de la habitacion que quiero borrar
    // le devuelvo una respuesta http
    @DeleteMapping("{codigoHabitacion}")
    public ResponseEntity<Void> delete(@PathVariable String codigoHabitacion){
        habitacionService.delete(codigoHabitacion);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
