package com.projeto.model;

public class Posicao {
	private long idPosicao;
	private int peso1;
	private int peso2;
	private String posJog1;
	private String posJog2;

	public Posicao() {
		super();
	}

	public Posicao(long idPosicao, int peso1, int peso2, String posJog1, String posJog2) {
		super();
		this.idPosicao = idPosicao;
		this.peso1 = peso1;
		this.peso2 = peso2;
		this.posJog1 = posJog1;
		this.posJog2 = posJog2;
	}

	public long getIdPosicao() {
		return idPosicao;
	}

	public void setIdPosicao(long idPosicao) {
		this.idPosicao = idPosicao;
	}

	public int getPeso1() {
		return peso1;
	}

	public void setPeso1(int peso1) {
		this.peso1 = peso1;
	}

	public int getPeso2() {
		return peso2;
	}

	public void setPeso2(int peso2) {
		this.peso2 = peso2;
	}

	public String getPosJog1() {
		return posJog1;
	}

	public void setPosJog1(String posJog1) {
		this.posJog1 = posJog1;
	}

	public String getPosJog2() {
		return posJog2;
	}

	public void setPosJog2(String posJog2) {
		this.posJog2 = posJog2;
	}
}