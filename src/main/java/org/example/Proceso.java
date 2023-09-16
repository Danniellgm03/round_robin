package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

public class Proceso implements Comparable<Proceso> {
    UUID uuid = UUID.randomUUID();
    public int prioridad;
    LocalDate fecha_creacion = LocalDate.now();
    int quantum;

    LocalDateTime fecha2 = LocalDateTime.now();

    public Proceso(){
        this.prioridad = (int)(Math.random() * (8 - 0) + 1);
        this.quantum = (int)(Math.random() * (100 - 0) + 1);
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "uuid=" + uuid +
                ", prioridad=" + prioridad +
                ", fecha_creacion=" + fecha_creacion.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()  +
                ", quantum=" + quantum  +
                ", fecha2=" + fecha2.getNano()  +
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
}
