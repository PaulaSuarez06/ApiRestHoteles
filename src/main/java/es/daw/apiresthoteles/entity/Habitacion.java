package es.daw.apiresthoteles.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HABITACION")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String codigo;
    private Integer tamano;
    private Boolean doble;
    private Double precio_noche;
    private Boolean incluye_desayuno;
    private Boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

}
