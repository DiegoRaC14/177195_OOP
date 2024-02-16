package stacks.queues;

public class MyQueues {

    //Atributos
    char[] queue;
    int MAX;
    int tail; // Índice en la posición disponible (indica espacio vacío)
    int head; // Índice en la parte de adelante de la cola

    //Método constructor
    
    public MyQueues(int capacidad) {
    		    queue = new char[capacidad]; 
    		    MAX = capacidad;
    		    tail = 0;// Al principio la pila está vacía
    		    head = 0;
    }
    
    public void insert(char data) { //Añadir elementos al final de la cola
        if (tail == MAX) {
            System.out.println("Queue is full");
        } else {
            queue[tail] = data;
            tail++;
        }
    }

    public char delete() {//Eliminar elementos al principio de la cola
    	
        if (tail == 0) {
            System.out.println("Queue is empty");
            return '#'; // Devuelve '#' para indicar que no hay elementos disponibles
        } else {
            
        	char deletedElement = queue[0]; // Almacenamos el char que se eliminará
            
            for (int i = 0; i < tail - 1; i++) {// Movemos los elementos hacia la izquierda
                queue[i] = queue[i + 1];
            }
            tail--;
            
            
            return deletedElement; // Devolvemos el elemento eliminado
        }
    }
    
    public String invertirCadena(String cadena) {
        // Agregar cada carácter de la cadena al final de la cola
        for (int i = 0; i < cadena.length(); i++) {
            insert(cadena.charAt(i));
        }

        // Crear un StringBuilder para almacenar la cadena invertida
        StringBuilder cadenaInvertida = new StringBuilder();

        // Sacar cada carácter de la cola y añadirlo al inicio de cadenaInvertida para invertir la cadena
        while (tail != 0) {
            char caracter = delete(); // Sacar el carácter de la cola
            cadenaInvertida.insert(0, caracter); // Insertar el carácter al inicio de cadenaInvertida
        }

        // Devolver la cadena invertida
        return cadenaInvertida.toString();
    }
}

