package guess.who.archivos;


public abstract class Pokemon {
    private String nombre;
    private String tipo;
    private String[] arrAtaques;
    
    public Pokemon(String nombre, String tipo, String[] arrAtaques) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.arrAtaques = arrAtaques;
    }
    

    
    // Setters y getters
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }

    
    public void setAtaques(String[] arrAtaques) {
        this.arrAtaques = arrAtaques;
    }
    
    public String[] getAtaques() {
        return arrAtaques;

    }

}

