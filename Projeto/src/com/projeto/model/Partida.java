package com.projeto.model;

import java.util.ArrayList;

public class Partida {
	private long idPartida;
	private int faltas;
	private String data;
	private String endereco;
	private Clube clube;
	private Esporte esporte;
	private ArrayList<Usuario> contadorPartida;
	private int statusPartida;

	public Partida() {
		super();
		contadorPartida = new ArrayList<>();
		clube = new Clube();
		esporte = new Esporte();
	}

	public Partida(long idPartida, int faltas, String data, String endereco, int statusPartida, Clube clube) {
		super();
		this.idPartida = idPartida;
		this.faltas = faltas;
		this.data = data;
		this.endereco = endereco;
		this.statusPartida = statusPartida;
		this.clube = clube;
	}

	public long getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(long idPartida) {
		this.idPartida = idPartida;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getStatusPartida() {
		return statusPartida;
	}

	public void setStatusPartida(int statusPartida) {
		this.statusPartida = statusPartida;
	}

	public Clube getclube() {
		return clube;
	}

	public void setclube(Clube clube) {
		this.clube = clube;
	}

	public Esporte getEsporte() {
		return esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

	public ArrayList<Usuario> getContadorPartida() {
		return contadorPartida;
	}

	public void setContadorPartida(ArrayList<Usuario> contadorPartida) {
		this.contadorPartida = contadorPartida;
	}

}
