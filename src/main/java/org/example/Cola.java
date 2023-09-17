package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Cola<T extends Proceso>{

    private ArrayList<T> cola = new ArrayList<T>();
    public Cola(){}

    /**
     * Añade un elemento a la cola y la ordena
     * @param elem
     * @return boolean - true si se ha añadido correctamente
     */
    public boolean addToCola(T elem){
        boolean proceso_is_added = cola.add(elem);
        this.sort();
        return proceso_is_added;
    }

    public void sort(){
        Collections.sort(cola);
    }

    /**
     * Extrae el primer elemento de la cola que tiene mayor prioridad
     * y lo elimina en el caso de que su quantum sea 0, sino lo vuelve añadir a la cola y lo ordena
     * para su proxima ejecucion
     * @return T - elemento extraido
     */
    public T extract(){
        T elem_deleted = cola.remove(0);
        elem_deleted.setDate_last_modify(LocalDateTime.now().plusNanos(1));
        elem_deleted.setQuantum(elem_deleted.getQuantum() - 1);

        if(elem_deleted.getQuantum() > 0){
            cola.add(elem_deleted);
        }
        sort();
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
