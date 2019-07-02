package com.projeto.model;

public class Participa {
	private long id_participa;
	private Usuario usuario;
	private Esporte esporte;
	private Posicao posicao;

	public Participa() {
		super();
		usuario = new Usuario();
		esporte = new Esporte();
		posicao = new Posicao();
	}

	public Participa(long id_participa, Usuario usuario, Esporte esporte, Posicao posicao) {
		super();
		this.id_participa = id_participa;
		this.usuario = usuario;
		this.esporte = esporte;
		this.posicao = posicao;
	}

	public long getId_participa() {
		return id_participa;
	}

	public void setId_participa(long id_participa) {
		this.id_participa = id_participa;
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

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
}