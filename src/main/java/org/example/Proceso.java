package org.example;

import java.time.LocalDateTime;
import java.util.UUID;

public class Proceso implements Comparable<Proceso> {
    private final UUID uuid = UUID.randomUUID();
    private int priority;
    private int quantum;

    private LocalDateTime date_creation = LocalDateTime.now();

    private LocalDateTime date_last_modify = LocalDateTime.now();

    /**
     * Constructor de la clase Proceso
     * Genera un numero aleatorio entre 0 y 9 para la prioridad
     * Genera un numero aleatorio entre 1 y 100 para el quantum
     * */
    public Proceso(){
        this.priority = (int)(Math.random() * (9 - 0));
        this.quantum = (int)(Math.random() * (100 - 1) + 1);
    }

    /**
     * Getter del UUID del proceso
     * @return UUID - uuid del proceso
     * */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Getter de la prioridad del proceso
     * @return int - prioridad del proceso
     * */
    public int getPriority() {
        return priority;
    }

    /**
     * Getter del quantum del proceso
     * @return int - quantum del proceso
     * */
    public int getQuantum() {
        return quantum;
    }

    /**
     * Getter de la fecha de creacion del proceso
     * @return LocalDateTime - fecha de creacion del proceso
     * */
    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    /**
     * Setter de la prioridad del proceso
     * @param priority - prioridad del proceso
     * */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Setter del quantum del proceso
     * @param quantum - quantum del proceso
     * */
    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    /**
     * Setter de la fecha de creacion del proceso
     * @param date_creation - fecha de creacion del proceso
     * */
    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

    /**
     * Getter de la fecha de la ultima modificacion del proceso
     * @return LocalDateTime - fecha de la ultima modificacion del proceso
     * */
    public LocalDateTime getDate_last_modify() {
        return date_last_modify;
    }

    /**
     * Setter de la fecha de la ultima modificacion del proceso
     * @param date_last_modify - fecha de la ultima modificacion del proceso
     * */
    public void setDate_last_modify(LocalDateTime date_last_modify) {
        this.date_last_modify = date_last_modify;
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "uuid=" + uuid +
                ", priority=" + priority +
                ", date_creation=" + date_creation +
                ", quantum=" + quantum  +
                ", date_last_modify=" + date_last_modify +
                '}';
    }

    /**
     * Compara dos procesos por prioridad y por fecha de creacion
     * @param otroProceso
     * @return int - (1 si el proceso es mayor, 0 si son iguales y -1 si es menor)
     */
    @Override
    public int compareTo(Proceso otroProceso) {
        if(this.priority > otroProceso.priority){
            return 1;
        } else if (this.priority == otroProceso.priority) {
            if(this.date_last_modify.isAfter(otroProceso.date_last_modify)){
                return 1;
            }else if(this.date_last_modify.isBefore(otroProceso.date_last_modify)){
                return -1;
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }


}
