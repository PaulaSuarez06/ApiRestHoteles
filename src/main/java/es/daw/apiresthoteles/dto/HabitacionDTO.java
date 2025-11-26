package es.daw.apiresthoteles.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class HabitacionDTO {

    private String codigo;
    private Integer tamano;
    private Boolean doble;
    private double precio_noche;
    private Boolean incluye_desayuno;
    private Boolean ocupada;

    @JsonIgnore
    private String hotelCodigo;



}
