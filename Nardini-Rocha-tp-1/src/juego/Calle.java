package juego;

import java.awt.Color;

import entorno.Entorno;

public class Calle {
	
	private boolean esVertical;
	private int anchoDeMano;
	private int origen;
	private int primerLimite;
	private int segundoLimite;
	
	public Calle(Entorno entorno, boolean esVertical, int origen) {
		this.esVertical = esVertical;
		this.anchoDeMano = 50;
		this.origen = origen;
		this.setLimites(origen);
	}
	
	public void setLimites(int posicion) {
		this.primerLimite =  (posicion - (this.anchoDeMano / 2));
		this.segundoLimite = (posicion + (this.anchoDeMano / 2));
		System.out.println("Primer limite: " + this.primerLimite);
		System.out.println("Segundo limite: " + this.segundoLimite);
	}
	
	public int getPrimerLimite() {
		return this.primerLimite;
	}
	
	public int getSegundoLimite() {
		return this.segundoLimite;
	}
	
	public boolean getEsVertical() {
		return this.esVertical;
	}
	public static void dibujarCalles(Calle[] calles, Entorno entorno) {
		
		int posicionX = 25;
		int posicionY = 25;
		
		for(Calle calle : calles) {
			if (calle.esVertical) {
				entorno.dibujarRectangulo(posicionX, entorno.alto() / 2, calle.anchoDeMano, entorno.alto(), 0, Color.gray);
				posicionX = posicionX + 250;
			} else {
				entorno.dibujarRectangulo(entorno.ancho() / 2, posicionY, entorno.ancho(), calle.anchoDeMano, 0, Color.gray);
				posicionY = posicionY + 275;
			}
		}
		

	}
	
}
