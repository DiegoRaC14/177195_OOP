package imagenes;

public class Main {
	
	public static void main (String[] args) {

		// Como son métodos estáticos no necesitan crear un objeto
		Flamingo.crearFlamingo();
		Rana.crearRana();
		Pokebola.crearPokebola();
		SuperMarioFlower.crearSuperMarioFlower();
		Pinguino.crearPinguino();
		Caracol.crearCaracol();
		
		System.out.println();
		System.out.println("Se crearon con éxito las 6 imágenes.");
	}

}
