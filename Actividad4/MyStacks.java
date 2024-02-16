package stacks.queues;

public class MyStacks {

    // Atributos
    char[] stack;
    int MAX; // Tamaño del arreglo
    int top; // Índice en la posición disponible (indica espacio vacío)
    
    // Método constructor 
    public MyStacks(int capacidad) {
        stack = new char[capacidad]; // Crear objeto arreglo
        MAX = capacidad;
        top = 0; // Al principio la pila está vacía
    }
    
    public void push(char data) { // Ingresa los datos al stack
        if (top == MAX) {
            System.out.println("Stack is full");
        } else {
            stack[top] = data; // Insertar el nuevo elemento en la posición top
            top++; // Actualizar el índice del top
        }
    }

    public char pop() { // Retira los datos
        if (top == 0) {
            System.out.println("Stack is empty");
            return '#'; // Devuelve '#' para indicar que no hay elementos disponibles
        } else {
            top--; // Decrementar el índice del top antes de extraer el elemento
            char data = stack[top]; // Extraer el elemento del top
            return data;
        }
    }
    
    
    public String invertirCadena(String cadena) {
        for (int i = 0; i < cadena.length(); i++) { // Agregar cada carácter de la cadena al stack
            push(cadena.charAt(i));
        }

        // Crear un StringBuilder para almacenar la cadena invertida
        StringBuilder cadenaInvertida = new StringBuilder();

        while (top != 0) { // Sacar cada carácter del stack y añadirlo al inicio de cadenaInvertida para invertir la cadena
            char caracter = pop(); // Sacar el carácter del stack
            cadenaInvertida = cadenaInvertida.insert(0, caracter); // Insertar el carácter al inicio de cadenaInvertida
        }
        
        // Imprimir la cadena invertida
        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena invertida: " + cadenaInvertida.toString());
        
        return cadenaInvertida.toString(); // Devolver la cadena invertida
        
    }
    
    public void invertirCadena2(String cadena) {
    	
    	for (int i = 0; i < cadena.length(); i++) {
    		
    		
    		
    	}
    }


}
