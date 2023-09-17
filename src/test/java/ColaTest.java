import org.example.Cola;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Proceso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ColaTest {

    @Test
    @DisplayName("Test de añadir un proceso a la cola")
    public void testAddToCola() {
        Cola cola = new Cola();
        assertEquals(true, cola.addToCola(new Proceso()));
        assertFalse(cola.isEmpty());
    }

    @Test
    @DisplayName("Test de sacar un proceso de la cola con procesos de diferentes prioridades")
    public void testSacarCola1(){
        Cola cola = new Cola();
        Proceso p1 = new Proceso();
        p1.setPriority(8);
        Proceso p2 = new Proceso();
        p2.setPriority(2);
        Proceso p3 = new Proceso();
        p3.setPriority(4);
        cola.addToCola(p1);
        cola.addToCola(p2);
        cola.addToCola(p3);

        Proceso proceso_sacado = cola.extract();
        assertEquals(p2, proceso_sacado);
    }

    @Test
    @DisplayName("Test de sacar un proceso de la cola en el que hay procesos con la misma prioridad")
    public void testSacarCola2(){
        Cola cola = new Cola();
        Proceso p1 = new Proceso();
        p1.setPriority(3);
        Proceso p2 = new Proceso();
        p2.setPriority(4);
        Proceso p3 = new Proceso();
        p3.setPriority(3);
        p3.setDate_last_modify(LocalDateTime.now().minusSeconds(10));
        cola.addToCola(p1);
        cola.addToCola(p2);
        cola.addToCola(p3);
        Proceso proceso_sacado = cola.extract();
        assertEquals(p3, proceso_sacado);
        proceso_sacado = cola.extract();
        assertEquals(p1, proceso_sacado);
    }

    @Test
    @DisplayName("Teste de sacar un proceso de la cola en el que hay uno de mayor prioridad con un quantum de 0 y otros de la misma prioridad")
    public void testSacarCola3(){
        Cola cola = new Cola();
        Proceso p1 = new Proceso();
        p1.setPriority(3);
        p1.setQuantum(10);
        Proceso p2 = new Proceso();
        p2.setPriority(4);
        Proceso p3 = new Proceso();
        p3.setPriority(3);
        p3.setQuantum(10);
        Proceso p4 = new Proceso();
        p4.setPriority(1);
        p4.setQuantum(1);
        cola.addToCola(p1);
        cola.addToCola(p2);
        cola.addToCola(p3);
        cola.addToCola(p4);

        Proceso proceso_sacado = cola.extract();
        assertEquals(p4, proceso_sacado);
        proceso_sacado = cola.extract();
        assertEquals(p1, proceso_sacado);
        proceso_sacado = cola.extract();
        assertEquals(p3, proceso_sacado);
        proceso_sacado = cola.extract();
        assertEquals(p1, proceso_sacado);
    }

    @Test
    @DisplayName("Test de que una vez se saca el proceso de la cola, cambia su fecha y quantum")
    public void testSacarCola4(){
        Cola cola = new Cola();
        Proceso p1 = new Proceso();
        cola.addToCola(p1);
        LocalDateTime fecha = p1.getDate_last_modify();
        int quantum = p1.getQuantum();
        Proceso proceso_sacado = cola.extract();
        assertTrue(fecha.isBefore(proceso_sacado.getDate_last_modify()));
        assertTrue(quantum > proceso_sacado.getQuantum());
    }

    @Test
    @DisplayName("Test de que la cola esta vacia")
    public void testIsEmpty(){
        Cola cola = new Cola();
        assertTrue(cola.isEmpty());
        Proceso p1 = new Proceso();
        p1.setQuantum(1);
        cola.addToCola(p1);
        cola.extract();
        assertTrue(cola.isEmpty());
    }


}
