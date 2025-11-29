package es.daw.apiresthoteles.exception;

public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(String codigo) {
        super("hotel no encontrado " + codigo);
    }
}
