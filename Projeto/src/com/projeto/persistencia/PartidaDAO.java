package com.projeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.projeto.model.Clube;
import com.projeto.model.Esporte;
import com.projeto.model.Partida;

public class PartidaDAO {
	private ConexaoMysql conexao = new ConexaoMysql();

	public PartidaDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto");
	}

	public void criarPartida(Partida partida, Clube clube, Esporte esporte) {
		this.conexao.abrirConexao();
		String insert = "INSERT INTO partida VALUES (null, ?,?,?,?,?,?)";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(insert);
			statement.setNull(1, java.sql.Types.NUMERIC);
			statement.setString(2, partida.getData());
			statement.setString(3, partida.getEndereco());
			statement.setInt(4, partida.getStatusPartida());
			statement.setLong(5, clube.getIdClube());
			statement.setLong(6, esporte.getId_esporte());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void editarPartida(Partida partida, Esporte esporte) {
		this.conexao.abrirConexao();
		String sqlUpdate = " UPDATE partida SET faltas = ?, data_hora=? ,endereco=?, status_partida = ? , id_esporte =? WHERE id_partida = ?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setInt(1, partida.getFaltas());
			statement.setString(2, partida.getData());
			statement.setString(3, partida.getEndereco());
			statement.setInt(4, partida.getStatusPartida());
			statement.setLong(5, esporte.getId_esporte());
			statement.setLong(6, partida.getIdPartida());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	public void adcionarFaltas(Partida partida) {
		this.conexao.abrirConexao();
		String sqlUpdate = " UPDATE partida SET faltas = ? WHERE id_partida = ?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setInt(1, partida.getFaltas());
			statement.setLong(2, partida.getIdPartida());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long id_partida) {
		this.conexao.abrirConexao();
		String sqlDelete = " DELETE FROM partida  WHERE id_partida=?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, id_partida);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public int checarStatusPartida(Long idPartida) {
		Partida partida = new Partida();
		this.conexao.abrirConexao();
		String sqlSelect = "SELECT status_partida FROM partida WHERE id_partida=?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			statement.setLong(1, idPartida);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				partida.setStatusPartida(rs.getInt("status_partida"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return partida.getStatusPartida();
	}
}
