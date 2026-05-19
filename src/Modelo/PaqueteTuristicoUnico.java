package Modelo;

import java.util.ArrayList;

/**
 *
 * @authors [NombreAutores_Y_Código]
 * @version 1.0 - 20260518
 */
public final class PaqueteTuristicoUnico extends PaqueteTuristico {
    private static final long serialVersionUID = 1L;

    private String nombreHotel;
    private String tipoDesayuno;

    public PaqueteTuristicoUnico(String nombreHotel, String tipoDesayuno, String codigo, String nombre,
            String tipologiaTurismo, String descripcion, String origen, ArrayList<Destino> susDestinos,
            boolean hotel, boolean alimentacion, boolean alimentacionTodo, boolean vuelo, boolean asistencia,
            int tarifaDia, int cantidadUnidades) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestinos, hotel, alimentacion,
                alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
        this.nombreHotel = nombreHotel;
        this.tipoDesayuno = tipoDesayuno;
    }

    public PaqueteTuristicoUnico(String nombreHotel, String codigo, String nombre, String tipologiaTurismo,
            String descripcion, String origen, ArrayList<Destino> susDestinos, boolean hotel, boolean alimentacion,
            boolean alimentacionTodo, boolean vuelo, boolean asistencia, int tarifaDia, int cantidadUnidades) {
        this(nombreHotel, null, codigo, nombre, tipologiaTurismo, descripcion, origen, susDestinos, hotel,
                alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getTipoDesayuno() {
        return tipoDesayuno;
    }

    public void setTipoDesayuno(String tipoDesayuno) {
        this.tipoDesayuno = tipoDesayuno;
    }

    @Override
    public int calcularValorUnidad() {
        return tarifaDia * calcularDuracionTotalDias();
    }

    @Override
    public String toString() {
        return "PaqueteTuristicoUnico{" +
                "nombreHotel=" + nombreHotel +
                ", tipoDesayuno=" + tipoDesayuno +
                ", " + super.toString() +
                "}";
    }
}
