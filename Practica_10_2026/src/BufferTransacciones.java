import java.util.LinkedList;
import java.util.Queue;

public class BufferTransacciones {
    private Queue<String> buffer = new LinkedList<>();
    private int capacidad = 5;

    public synchronized void producir(String transaccion) throws InterruptedException {
        while (buffer.size() == capacidad) {
            System.out.println(Thread.currentThread().getName() + " | Buffer lleno, esperando...");
            wait();
        }
        buffer.add(transaccion);
        System.out.println(Thread.currentThread().getName() + " | Produjo: " + transaccion);
        notify();
    }

    public synchronized String consumir() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " | Buffer vacio, esperando...");
            wait();
        }
        String transaccion = buffer.poll();
        System.out.println(Thread.currentThread().getName() + " | Consumio: " + transaccion);
        notify();
        return transaccion;
    }
}