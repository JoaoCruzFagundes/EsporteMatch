package com.projeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.projeto.model.Clube;

public class ClubeDAO {
	private ConexaoMysql conexao;
	public ClubeDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto");
	}

	public void cadastrar(Clube clube) {
		this.conexao.abrirConexao();
		String insert = "INSERT INTO clube VALUES (null, ?)";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(insert);
			statement.setString(1, clube.getNome());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void editar(String nome, Long idClube) {
		
		this.conexao.abrirConexao();
		String sqlUpdate = " UPDATE clube SET  nome = ? WHERE id_clube = ?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, nome);
			statement.setLong(2, idClube);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long idClube) {
		this.conexao.abrirConexao();
		String sqlDelete = " DELETE FROM clube WHERE id_clube=?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, idClube);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
}
