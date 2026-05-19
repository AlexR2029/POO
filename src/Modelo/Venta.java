package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @authors [NombreAutores_Y_Código]
 * @version 1.0 - 20260518
 */
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraActualizacion;
    private Cliente suCliente;
    private ArrayList<PaqueteTuristico> susPaquetesTuristicos;
    private char estado;

    public Venta(int numero, LocalDateTime fechaHoraGeneracion, LocalDateTime fechaHoraActualizacion,
            Cliente suCliente, ArrayList<PaqueteTuristico> susPaquetesTuristicos, char estado) {
        this.numero = numero;
        this.fechaHoraGeneracion = fechaHoraGeneracion;
        this.fechaHoraActualizacion = fechaHoraActualizacion;
        this.suCliente = suCliente;
        this.susPaquetesTuristicos = susPaquetesTuristicos;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaHoraGeneracion() {
        return fechaHoraGeneracion;
    }

    public void setFechaHoraGeneracion(LocalDateTime fechaHoraGeneracion) {
        this.fechaHoraGeneracion = fechaHoraGeneracion;
    }

    public LocalDateTime getFechaHoraActualizacion() {
        return fechaHoraActualizacion;
    }

    public void setFechaHoraActualizacion(LocalDateTime fechaHoraActualizacion) {
        this.fechaHoraActualizacion = fechaHoraActualizacion;
    }

    public Cliente getSuCliente() {
        return suCliente;
    }

    public void setSuCliente(Cliente suCliente) {
        this.suCliente = suCliente;
    }

    public ArrayList<PaqueteTuristico> getSusPaquetesTuristicos() {
        return susPaquetesTuristicos;
    }

    public void setSusPaquetesTuristicos(ArrayList<PaqueteTuristico> susPaquetesTuristicos) {
        this.susPaquetesTuristicos = susPaquetesTuristicos;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int calcularCantidadTotalUnidadesPaquetes() {
        if (susPaquetesTuristicos == null || susPaquetesTuristicos.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (PaqueteTuristico paquete : susPaquetesTuristicos) {
            if (paquete != null) {
                total += paquete.getCantidadUnidades();
            }
        }
        return total;
    }

    public int calcularValorTotalPaquetes() {
        if (susPaquetesTuristicos == null || susPaquetesTuristicos.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (PaqueteTuristico paquete : susPaquetesTuristicos) {
            if (paquete != null) {
                total += paquete.calcularValorTotal();
            }
        }
        return total;
    }

    public int calcularValorDescuento() {
        if (suCliente == null) {
            return 0;
        }
        int total = calcularValorTotalPaquetes();
        double porcentaje = suCliente.getPorcentajeDescuento() / 100.0;
        return (int) Math.round(total * porcentaje);
    }

    public int calcularValorTotalPagar() {
        return calcularValorTotalPaquetes() - calcularValorDescuento();
    }

    @Override
    public String toString() {
        return "Venta{" +
                "numero=" + numero +
                ", fechaHoraGeneracion=" + fechaHoraGeneracion +
                ", fechaHoraActualizacion=" + fechaHoraActualizacion +
                ", suCliente=" + suCliente +
                ", susPaquetesTuristicos=" + susPaquetesTuristicos +
                ", estado=" + estado +
                "}";
    }
}
