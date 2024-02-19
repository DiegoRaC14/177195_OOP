package stacks.queues;

public class MyQueues {

    //Atributos
    char[] queue;
    int MAX;
    int tail; // Índice en la posición disponible (indica espacio vacío)


    //Método constructor
    
    public MyQueues(int capacidad) {
    		    queue = new char[capacidad]; 
    		    MAX = capacidad;
    		    tail = 0;// Al principio la pila está vacía
    }
    
    public void insert(char data) { //Añadir elementos al final de la cola
        if (tail == MAX) {
            System.out.println("Queue is full");
        } else {
            queue[tail] = data;
            tail++;
        }
    }

    public char delete() {
        if (tail == 0) {
            return '#'; // Cola vacía
        } else {
            char value = queue[0];
            
            for (int i = 0; i < tail - 1; i++) {
                queue[i] = queue[i + 1];// Arrima los valores
            }
            tail--;
            return value;
        }
    }
    
    
}

