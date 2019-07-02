package com.projeto.model;

public class Escolhe {
	private long id_escolhe;
	private Usuario usuario;
	private Esporte esporte;

	public Escolhe() {
		super();
		usuario = new Usuario();
		esporte = new Esporte();
	}

	public Escolhe(long id_escolhe, Usuario usuario, Esporte esporte) {
		super();
		this.id_escolhe = id_escolhe;
		this.usuario = usuario;
		this.esporte = esporte;
	}

	public long getId_escolhe() {
		return id_escolhe;
	}

	public void setId_escolhe(long id_escolhe) {
		this.id_escolhe = id_escolhe;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Esporte getEsporte() {
		return esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}
}
