package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Cola<T extends Proceso>{

    private ArrayList<T> cola = new ArrayList<T>();
    public Cola(){ }

    public boolean addToCola(T elem){
        return cola.add(elem);
    }

    public void sort(){
        Collections.sort(cola);
    }

    public T sacar(){
        T elem_deleted = cola.remove(0);
        elem_deleted.setFecha_creacion(LocalDateTime.now());
        elem_deleted.setQuantum(elem_deleted.getQuantum() - 1);

        if(elem_deleted.getQuantum() > 0){
            cola.add(elem_deleted);
        }
        return elem_deleted;
    }

    public boolean isEmpty(){
        return cola.isEmpty();
    }

    @Override
    public String toString() {
        return "Cola{" +
                "cola=" + cola +
                '}';
    }
}
