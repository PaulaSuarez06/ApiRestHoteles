package es.daw.apiresthoteles.dto;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "codigo", "nombre", "descripcion", "piscina", "localidad", "categoria" })

public class HotelDTO {

    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean piscina;
    private String localidad;
    private CategoriaDTO categoria;
}
