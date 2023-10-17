package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
	//Constructor
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private int velocidad;
	private int direccion;
	private Image imagen;
	
	public Planta(double x, double y, int ancho, int alto, int velocidad, int d)
	{
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.direccion = d;
		this.imagen = Herramientas.cargarImagen("plantHor.png");
	}

	public void dibujar(Entorno entorno)
	{
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.green);
		entorno.dibujarImagen(imagen, x, y,0,0.50);
	}
	
	//Generador de Plantas.
	public static void crearUnaPlanta(Planta[] plantas, Entorno e) {
		int numeroRandom = ThreadLocalRandom.current().nextInt(200, 600);
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] == null) {
				plantas[i] = new Planta(numeroRandom, numeroRandom, 30, 50, 2, 1);
			return;
			}
		}
	}
	
	public void moverLat(Entorno e) {
		this.x += direccion * this.velocidad;
	}
	
	public void moverVert(Entorno e) {
		this.y -= direccion * this.velocidad;
		e.dibujarRectangulo(this.x, this.y, this.ancho*2, this.alto/2, 0, Color.green);
		this.imagen = Herramientas.cargarImagen("plantVert.png");
	}

	public void rebotar(Entorno e) {
		if (this.x + this.ancho / 2 > e.ancho()) { // mientras no choque a la derecha
			this.direccion = -1;
			this.imagen = Herramientas.cargarImagen("plantHorIzq.png");
		}
		if (this.x - this.ancho / 2 < 0) { // mientras no choque a la izquierda
			this.direccion = 1;
			this.imagen = Herramientas.cargarImagen("plantHor.png");
		}
		if (this.y + this.alto / 2 < 0) { // mientras no choque abajo
			this.direccion = -1;
			this.imagen = Herramientas.cargarImagen("plantVert.png");
		}
		if (this.y - this.alto / 2 > e.alto()) { // mientras no choque arriba
			this.direccion = 1;
			this.imagen = Herramientas.cargarImagen("plantVert.png");
		}
		
	}
	
	public double getX()
	{
		return this.x;
	}

	public int getAncho()
	{
		return this.ancho;
	}

	public double getY() {
		return y;
	}

	public int getAlto() {
		return alto;
	}

}
