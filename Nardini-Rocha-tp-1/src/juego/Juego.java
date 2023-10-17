package juego;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;	
	private Laika laika;
	private Calle[] calles;
	private Rayo rayo;

	// Variables y métodos propios de cada grupo
	// ...

	Juego() {
		Random rand = new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, " Plantas Invasoras - Grupo ... - v1", 800, 600);

		// Inicializar lo que haga falta para el juego
		
		this.calles = crearArregloDeCalles();
		this.laika = new Laika(entorno);


		// Inicia el juego!
		this.entorno.iniciar();
		

		
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		this.laika.moverPersonaje(decideDirection(), this.calles);
		Calle.dibujarCalles(this.calles, entorno);
		this.laika.dibujarPersonaje();
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			rayo = this.laika.disparar();
		}
		if (this.rayo != null)
			rayo.dibujarRayo();

		
		
		
		// ...
	}
	
	private char decideDirection() {
		if (entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			return 'D';
		} else if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			return 'U';
		} else if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			return 'R';
		} else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			return 'L';
		}
		return 'W';
	}
	
	private Calle[] crearArregloDeCalles() {
		Calle[] calles = new Calle[7];
		calles[0] = new Calle(this.entorno, true, 25);
		calles[1] = new Calle(this.entorno, true, 275);
		calles[2] = new Calle(this.entorno, true, 525);
		calles[3] = new Calle(this.entorno, false, 25);
		calles[4] = new Calle(this.entorno, false, 300);
		calles[5] = new Calle(this.entorno, false, 575);
		calles[6] = new Calle(this.entorno, true, 775);

		
		return calles;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
