package juego;

import java.awt.Color;
import entorno.Entorno;

public class Rayo {
	private Entorno entorno;
	private int xActual;
	private int yActual;
	private boolean vertical;
	private boolean positivo;
	
	
	public Rayo(Entorno entorno, int xActual, int yActual, boolean vertical, boolean positivo) {
		this.entorno = entorno;
		this.xActual = xActual;
		this.yActual = yActual;
		this.positivo = positivo;
		this.vertical = vertical;
	}
	
	public void dibujarRayo() {
		entorno.dibujarCirculo(this.xActual, this.yActual, 25.0, Color.yellow);
		this.mover();
	}
	
	private void mover() {
		if (vertical) {
			if (positivo) {
				yActual = yActual + 10;
			} else {
				yActual = yActual - 10;
			}
		} else {
			if (positivo) {
				xActual = xActual + 10;
			} else {
				xActual = xActual - 10;
			}

		}
	}
}
