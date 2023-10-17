package juego;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import entorno.Entorno;

public class Laika {
	
	private final int X_INICIAL = 25;
	private final int Y_INICIAL = 25;
	private int alto;
	private int ancho;
	private int xActual;
	private int yActual;
	private int vida;

	private double angulo;
		
	private Entorno entorno;
	
	// TODO: usar las características de vertical y positivo para determinar el bloqueo de movimientos
	private boolean vertical;
	private boolean positivo;
	
	public Laika(Entorno entorno) {
		this.xActual = this.X_INICIAL;
		this.yActual = this.Y_INICIAL;
		this.alto = 40;
		this.ancho = 20;
		this.angulo = 0;
		this.vida = 100;
		this.entorno = entorno;
		
		this.vertical = true;
		this.positivo = true;
		
	}
	
	public void dibujarPersonaje() {
		entorno.dibujarRectangulo(xActual, yActual, ancho, alto, angulo, Color.white);
	}
	
	public void moverPersonaje(char key, Calle[] calles) {
		
		switch (key) {
		case 'U':
			moverArriba(calles);
			break;
		case 'D':
			moverAbajo(calles);
			break;
		case 'R':
			moverDerecha(calles);
			break;
		case 'L':
			moverIzquierda(calles);
			break;
		default:
				break;
		}
	}
	
	private void moverArriba(Calle[] calles) {
		this.angulo = 0;
		this.vertical = true;
		this.positivo = false;
		if (estaEnCalleVertical(calles) && (yActual - alto/2 > 0)) { 
			this.yActual = this.yActual - 5;
		}
	}
	
	private void moverAbajo(Calle[] calles) {
		this.angulo = Math.PI;
		this.vertical = true;
		this.positivo = true;

		if (estaEnCalleVertical(calles) && (yActual + alto/2 < 600)) { 
			this.yActual = this.yActual + 5;
		}
	}
	
	private void moverIzquierda(Calle[] calles) {
		this.angulo = Math.PI / 2;
		this.vertical = false;
		this.positivo = false;


		if (estaEnCalleHorizontal(calles) && (xActual - alto/2 > 0)) { 
			this.xActual = this.xActual - 5;
		}
	}
	
	private void moverDerecha(Calle[] calles) {
		this.angulo = 3 * Math.PI / 2;
		this.vertical = false;
		this.positivo = true;

		if (estaEnCalleHorizontal(calles) && (xActual + alto/2 < 800)) { 
			this.xActual = this.xActual + 5;
		}
	}
	
	public Rayo disparar() {
		
		
		if (vertical) {
			if (positivo) {
				return new Rayo(entorno, xActual, yActual + alto/2, vertical, positivo);
			} else {
				return new Rayo(entorno, xActual, yActual - alto/2, vertical, positivo);
			}
		} else {
			if (positivo) {
				return new Rayo(entorno, xActual + alto/2, yActual, vertical, positivo);
			} else {
				return new Rayo(entorno, xActual - alto/2, yActual, vertical, positivo);
			}

		}
	}
	
	private boolean estaEnCalleVertical(Calle[] calles) {
		for (Calle calle : calles) {
			if (calle.getEsVertical() && this.xActual > calle.getPrimerLimite() && this.xActual < calle.getSegundoLimite()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean estaEnCalleHorizontal(Calle[] calles) {
		for (Calle calle : calles) {
			if (!calle.getEsVertical() && this.yActual > calle.getPrimerLimite() && this.yActual < calle.getSegundoLimite()) {
				return true;
			}
		}
		return false;
	}

}
