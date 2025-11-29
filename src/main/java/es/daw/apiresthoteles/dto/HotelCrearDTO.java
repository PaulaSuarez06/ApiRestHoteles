package es.daw.apiresthoteles.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Data
public class HotelCrearDTO {

    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean piscina;
    private String localidad;
    private String categoriaCodigo;

}
