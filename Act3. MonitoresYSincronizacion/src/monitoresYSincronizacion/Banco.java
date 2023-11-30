package monitoresYSincronizacion;

public class Banco {

    private int clientes;

    public Banco() {
        clientes = 0;
    }

    public synchronized void ingresarBanco(cliente c) {
        while (clientes == 2) {
            try {
                System.out.println(c.getIdClient() + " está esperando a ingresar al banco.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clientes++;
        System.out.println(c.getIdClient() + " ha ingresado al banco.");
    }

    public synchronized void salirBanco(cliente c) {
        clientes--;
        System.out.println(c.getIdClient() + " ha salido del banco.");
        notify();
    }
}