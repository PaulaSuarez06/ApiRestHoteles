package es.daw.apiresthoteles.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class HabitacionCrearDTO {


    private String codigo;
    private Integer tamano;
    private Boolean doble;
    private double precio_noche;
    private Boolean incluye_desayuno;


}
