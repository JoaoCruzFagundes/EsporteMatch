package com.projeto.model;

public class Avaliacao {
	private long idAval;
	private long avalDesemp;
	private long avalCond;
	private String descricao;

	public Avaliacao() {
		super();
	}

	public Avaliacao(long idAval, int avalDesemp, int avalCond, String descricao) {
		super();
		this.idAval = idAval;
		this.avalDesemp = avalDesemp;
		this.avalCond = avalCond;
		this.descricao = descricao;
	}

	public long getIdAval() {
		return idAval;
	}

	public void setIdAval(long idAval) {
		this.idAval = idAval;
	}

	public long getAvalDesemp() {
		return avalDesemp;
	}

	public void setAvalDesemp(int avalDesemp) {
		this.avalDesemp = avalDesemp;
	}

	public long getAvalCond() {
		return avalCond;
	}

	public void setAvalCond(int avalCond) {
		this.avalCond = avalCond;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}