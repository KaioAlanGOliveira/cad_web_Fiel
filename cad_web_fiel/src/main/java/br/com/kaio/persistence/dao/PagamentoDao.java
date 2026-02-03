package br.com.kaio.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.kaio.domain.Pagamento;
import br.com.kaio.domain.PagamentoFiel;
import br.com.kaio.persistence.ConnFactory;

public class PagamentoDao {

	public void adicionar(Pagamento pg) {
		String sql = "INSERT INTO Pagamento (valor, cpf, dataPagamento) VALUES (?,?,?)";

		try {
			Connection con = ConnFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBigDecimal(1, pg.getValor());
			stmt.setString(2, pg.getCpf());
			stmt.setDate(3, (Date) pg.getDataPagamento());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PagamentoFiel> Listar() throws Exception {
		List<PagamentoFiel> lista = new ArrayList<>();

		try {
			Connection con = ConnFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM vw_pagamento_fiel");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				PagamentoFiel pg = new PagamentoFiel();
				pg.setNomeFiel(rs.getString("nome"));
				pg.setCpf(rs.getString("cpf"));
				pg.setValor(rs.getInt("valor"));
				pg.setId(rs.getInt("id"));
				pg.setDataPagamento(rs.getDate("dataPagamento"));

				lista.add(pg);
			}
		} catch (SQLException e) {
			throw new Exception("Erro ao listar: " + e.getMessage());
		}
		return lista;
	}

	public void apagar(Pagamento pg) {
		String sql = "DELETE FROM Pagamento WHERE id = ? AND cpf = ?";

		try (Connection conn = ConnFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, pg.getId());
			stmt.setString(2, pg.getCpf());

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Apagado com sucesso!");
			} else {
				System.out.println("Não foi apagado: nenhum registro encontrado com o CPF: " + pg.getCpf());
			}

		} catch (Exception e) {
			System.err.println("Erro no banco de dados: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void editar(Pagamento pg) {
		String sql = "UPDATE Pagamento SET valor=?, datapagamento=? WHERE cpf=?";

		try (Connection con = ConnFactory.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setBigDecimal(1, pg.getValor());
			stmt.setDate(2, (Date) pg.getDataPagamento());
			stmt.setString(3, pg.getCpf());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
