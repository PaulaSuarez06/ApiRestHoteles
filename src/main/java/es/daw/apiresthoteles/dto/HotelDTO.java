package es.daw.apiresthoteles.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class HotelDTO {

    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean piscina;
    private String localidad;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String categoria;
}
