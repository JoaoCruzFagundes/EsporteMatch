package com.projeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.projeto.model.Posicao;

public class PosicaoDAO {
	private ConexaoMysql conexao;

	public PosicaoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto");
	}

	public void escolherPosicao(Posicao posicao) {
		this.conexao.abrirConexao();
		String insert = "INSERT INTO posicao VALUES (null, ?, ?,?,?)";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(insert);
			statement.setString(1, posicao.getPosJog1());
			statement.setInt(2, posicao.getPeso1());
			statement.setString(3, posicao.getPosJog2());
			statement.setInt(4, posicao.getPeso2());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void editarPosicao(Posicao posicao) {
		this.conexao.abrirConexao();
		String sqlUpdate = " UPDATE  posicao SET  pos_jog_1 =?, peso_1 =?, , pos_jog_2=?, peso_2 = ? WHERE id_posicao = ?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, posicao.getPosJog1());
			statement.setInt(2, posicao.getPeso1());
			statement.setString(3, posicao.getPosJog2());
			statement.setInt(4, posicao.getPeso2());
			statement.setLong(5, posicao.getIdPosicao());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
}
