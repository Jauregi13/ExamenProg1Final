package modelo;

import java.util.ArrayList;

public class Parcela {
	private int id;
	private String numero;
	private int m_cuadrados;
	private double precio_dia;
	private ArrayList<Reserva> reservas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getM_cuadrados() {
		return m_cuadrados;
	}

	public void setM_cuadrados(int m_cuadrados) {
		this.m_cuadrados = m_cuadrados;
	}

	public double getPrecio_dia() {
		return precio_dia;
	}

	public void setPrecio_dia(double precio_dia) {
		this.precio_dia = precio_dia;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

}
