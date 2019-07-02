package com.projeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.projeto.model.Avaliacao;
import com.projeto.model.Clube;
import com.projeto.model.Usuario;

public class AvaliacaoDAO {
	private ConexaoMysql conexao;

	public AvaliacaoDAO() {
		super();
		new Usuario();
		new Clube();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto");
	}

	public void avaliar(Avaliacao avaliacao, Usuario usuario, Clube clube) {
		this.conexao.abrirConexao();
		String insert = "INSERT INTO avaliacao VALUES (null, ?, ?,?,?,?)";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(insert);
			statement.setLong(1, avaliacao.getAvalDesemp());
			statement.setLong(2, avaliacao.getAvalCond());
			statement.setString(3, avaliacao.getDescricao());
			statement.setLong(4, usuario.getIdUsuario());
			statement.setLong(5, clube.getIdClube());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
}
