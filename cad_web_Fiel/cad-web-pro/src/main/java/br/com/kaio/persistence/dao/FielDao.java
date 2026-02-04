package br.com.kaio.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.kaio.domain.Fiel;
import br.com.kaio.persistence.ConnFactory;

public class FielDao {

	public void adicionar(Fiel f) throws Exception {

		try {
			Connection con = ConnFactory.getConnection();

			String sql = "INSERT INTO Fiel (cpf, nome, idade, telefone) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, f.getCpf());
			stmt.setString(2, f.getNome());
			stmt.setInt(3, f.getIdade());
			stmt.setInt(4, f.getTelefone());

			stmt.executeUpdate();
			System.out.println("adicionado");
		} catch (Exception e) {
			throw e;
		}
	}

	public Fiel pegar(String cpf) throws Exception {

		try {
			Connection con = ConnFactory.getConnection();

			String sql = "select * from Fiel where cpf = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Fiel p = new Fiel();
			p.setCpf(rs.getString("cpf"));
			p.setNome(rs.getString("nome"));
			p.setIdade(rs.getInt("idade"));
			p.setTelefone(rs.getInt("telefone"));

			return p;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Fiel> listar() throws Exception {

		try {
			Connection con = ConnFactory.getConnection();

			String sql = "select * from Fiel";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Fiel> lista = new ArrayList<>();
			while (rs.next()) {
				Fiel p = new Fiel();
				p.setCpf(rs.getString("cpf"));
				p.setNome(rs.getString("nome"));
				p.setIdade(rs.getInt("idade"));
				p.setTelefone(rs.getInt("telefone"));

				lista.add(p);
			}
			return lista;
		} catch (Exception e) {
			throw e;
		}
	}

	public void apagar(Fiel f) throws Exception {

		try {
			Connection con = ConnFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM Fiel WHERE cpf = ? ");

			stmt.setString(1, f.getCpf());
			int linhas = stmt.executeUpdate();

			if (linhas == 0) {
				throw new Exception("Ninguem foi apagado");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void editar(Fiel f) {

		try {
			
			Connection con = ConnFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement("UPDATE Fiel SET nome = ?, telefone = ?, idade = ? WHERE cpf = ?;");

			stmt.setString(1, f.getNome());
			stmt.setInt(2, f.getTelefone());
			stmt.setInt(3, f.getIdade());
			stmt.setString(4, f.getCpf());

			int linhasAtualizadas = stmt.executeUpdate();
            System.out.println("Linhas atualizadas: " + linhasAtualizadas);
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
