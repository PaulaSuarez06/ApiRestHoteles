package es.daw.apiresthoteles.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "HOTEL")
public class Hotel {

    @Id
    private String codigo;

    private String nombre;

    private String descripcion;

    private Boolean piscina;

    private String localidad;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;



}
