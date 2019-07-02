package com.projeto.model;

public class Clube extends Usuario {
	private long idClube;
	private Usuario usuario;

	public Clube() {
		super();
		usuario = new Usuario();
	}

	public Clube(long idClube, String nome, Usuario usuario) {
		super();
		this.idClube = idClube;
		this.usuario = usuario;
	}

	public long getIdClube() {
		return idClube;
	}

	public void setIdClube(long idClube) {
		this.idClube = idClube;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
	}
}