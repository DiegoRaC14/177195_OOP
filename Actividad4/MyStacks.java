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
    
    
    public void push(char value) {
        if (top < MAX - 1) {
            top++;
            stack[top] = value;
        } else {
            System.out.println("Stack is full.");
        }
    }
    

    public char pop() { // Retira los datos
        if (top == -1) {

            return '#'; // Devuelve '#' para indicar que no hay elementos disponibles
        } else {
            char data = stack[top]; // Extraer el elemento del top
            top--;// Decrementar el índice del top antes de extraer el elemento
            return data;
        }
    }
    
    
     public String invertirCadena(String cadena) {
            int longitudArreglo = cadena.length();
          
            for (int i = 1; i < longitudArreglo; i++) {
                push(cadena.charAt(i)); // Usamos el método push que acepta chars
            }
            
            StringBuilder reversed = new StringBuilder();
            for (int i = 0; i < longitudArreglo; i++) {// Sacar los caracteres del stack
                reversed.append(pop()); // Usamos el método pop
            }
            return reversed.toString();
        }
     
     
     public boolean checarPalindromo(String cadena) {
         int tamanoCadena = cadena.length();
      
         for (int i = 0; i < tamanoCadena / 2; i++) {// Divide la cadena a la mitad 
             push(cadena.charAt(i));
         }
 
         int indice = (tamanoCadena + 1) / 2; 
         for (int i = indice; i < tamanoCadena; i++) {//Iteraciones para ver si cada caracter es el mismo
             if (cadena.charAt(i) != pop()) {
            	 return true;
             }
         }
         return false;
     }
    
}



