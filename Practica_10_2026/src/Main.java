import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CuentaBanco cuenta = new CuentaBanco("1001", 10000);

        System.out.println("=== CAJEROS (Thread) ===");
        Cajero cajero1 = new Cajero("Cajero-1", cuenta, 2000, "retiro");
        Cajero cajero2 = new Cajero("Cajero-2", cuenta, 3000, "retiro");
        Cajero cajero3 = new Cajero("Cajero-3", cuenta, 1000, "deposito");

        cajero1.start();
        cajero2.start();
        cajero3.start();

        cajero1.join();
        cajero2.join();
        cajero3.join();

        System.out.println("\n=== CLIENTES (ExecutorService) ===");
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.submit(new Cliente("Cliente-Jesus", cuenta, 500));
        pool.submit(new Cliente("Cliente-Daniel", cuenta, 1000));
        pool.submit(new Cliente("Cliente-Maria", cuenta, 750));

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n=== PRODUCTOR-CONSUMIDOR ===");
        BufferTransacciones buffer = new BufferTransacciones();

        Thread p1 = new Thread(new Productor("Productor-1", buffer), "Productor-1");
        Thread p2 = new Thread(new Productor("Productor-2", buffer), "Productor-2");
        Thread c1 = new Thread(new Consumidor("Consumidor-1", buffer), "Consumidor-1");
        Thread c2 = new Thread(new Consumidor("Consumidor-2", buffer), "Consumidor-2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        p1.join();
        p2.join();
        c1.join();
        c2.join();

        System.out.println("\nSaldo final: " + cuenta.getSaldo());
    }
}