package org.example;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

public class Proceso implements Comparable<Proceso> {
    private final UUID uuid = UUID.randomUUID();
    private int prioridad;
    private int quantum;

    private LocalDateTime fecha_creacion = LocalDateTime.now();

    public Proceso(){
        this.prioridad = (int)(Math.random() * (8 - 0) + 1);
        this.quantum = (int)(Math.random() * (100 - 0) + 1);
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "uuid=" + uuid +
                ", prioridad=" + prioridad +
                ", fecha_creacion=" + fecha_creacion  +
                ", quantum=" + quantum  +
                '}';
    }

    @Override
    public int compareTo(Proceso otroProceso) {
        if(this.prioridad > otroProceso.prioridad){
            return 1;
        } else if (this.prioridad == otroProceso.prioridad) {
            if(this.fecha_creacion.isAfter(otroProceso.fecha_creacion)){
                return 1;
            }else if(this.fecha_creacion.isBefore(otroProceso.fecha_creacion)){
                return -1;
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getQuantum() {
        return quantum;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
