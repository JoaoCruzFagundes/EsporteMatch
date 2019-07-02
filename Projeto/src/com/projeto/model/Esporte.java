package com.projeto.model;

public class Esporte {
	private long id_esporte;
	private String nome;
	private Partida partida;

	public Esporte() {
		super();
	}

	public Esporte(long id_esporte, String nome, Partida partida) {
		super();
		this.id_esporte = id_esporte;
		this.nome = nome;
		this.partida = partida;
	}

	public long getId_esporte() {
		return id_esporte;
	}

	public void setId_esporte(long id_esporte) {
		this.id_esporte = id_esporte;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
}
