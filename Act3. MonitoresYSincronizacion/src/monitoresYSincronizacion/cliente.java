package monitoresYSincronizacion;

public class cliente implements Runnable {

    private String Idlient;

    private Banco banco;

    public cliente(int id, Banco banco) {
        this.Idlient = "cliente" + id;
        this.banco = banco;
    }

    public String getIdClient() {
        return Idlient;
    }

    @Override
    public void run() {
    	
    	//aqui hago el proceso de ingreso al banco
        banco.ingresarBanco(this);
        try {
        	//aqui hago que los clientes estén durante un tiempo aleatorio dentro del banco
            Thread.sleep((int) (Math.random() * 5000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        banco.salirBanco(this);
    }
}