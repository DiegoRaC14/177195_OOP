package stacks.queues;

public class Ejecutar {
	
	public void iniciarProgama() {
		
		MyStacks StackEjercicio = new MyStacks(5);// Crear objetos para llamar a sus métodos
		MyQueues QueuesEjercicio = new MyQueues(5);// Crear objetos para llamar a sus métodos
		
		
		StackEjercicio.pop();//Para clase MyStack
		
		//QueuesEjercicio.insert('a');
		//QueuesEjercicio.insert('b');
		//QueuesEjercicio.insert('c');
		//QueuesEjercicio.insert('d');

	

		System.out.println("Element deleted: " + QueuesEjercicio.delete());
		System.out.println("Element deleted: " + QueuesEjercicio.delete());
		System.out.println("");
		 
		String miCadena = "hola";
		StackEjercicio.invertirCadena(miCadena);
		QueuesEjercicio.invertirCadena(miCadena);

		
	}

}
