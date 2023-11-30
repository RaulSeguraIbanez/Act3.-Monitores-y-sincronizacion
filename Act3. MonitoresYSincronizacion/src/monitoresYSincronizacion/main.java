package monitoresYSincronizacion;

public class main {
	 public static void main(String[] args) {
		 
		 Banco banco = new Banco();
	        
	     cliente[] clientes = new cliente[5];
	        
	     Thread[] hilos = new Thread[5];
	        
	        for (int i = 0; i < 5; i++) {
	            clientes[i] = new cliente(i + 1, banco);
	            hilos[i] = new Thread(clientes[i]);
	        }
	        for (int i = 0; i < 5; i++) {
	            hilos[i].start();
	        }
	    }
	}