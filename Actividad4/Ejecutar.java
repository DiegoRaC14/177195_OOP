package stacks.queues;

public class Ejecutar {
	
	public void iniciarProgama() {
		
		MyStacks StackEjercicio = new MyStacks(10);// Crear objetos para llamar a sus métodos
		MyQueues QueuesEjercicio = new MyQueues(10);// Crear objetos para llamar a sus métodos
		
		
		
		QueuesEjercicio.insert('a');
		QueuesEjercicio.insert('b');
		QueuesEjercicio.insert('c');
		QueuesEjercicio.insert('d');

	
		System.out.println("Element deleted: " + QueuesEjercicio.delete());
		System.out.println("Element deleted: " + QueuesEjercicio.delete());
		System.out.println("Element deleted: " + QueuesEjercicio.delete());
		System.out.println("");
		 
		String miCadena = "holaaa";
		System.out.println(StackEjercicio.invertirCadena(miCadena));
		StackEjercicio.checarPalindromo(miCadena);
		
		if (StackEjercicio.checarPalindromo(miCadena) == false) {
			System.out.println(miCadena + " es un palíndromo");
		}else {
			System.out.println(miCadena + " NO es un palíndromo");
		}

		
	}

}
