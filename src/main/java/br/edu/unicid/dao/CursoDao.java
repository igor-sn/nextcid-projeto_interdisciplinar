package br.edu.unicid.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import br.edu.unicid.bean.Curso;
import br.edu.unicid.util.ConnectionFactory;

public class CursoDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Curso curso;
	private int maiorID;

	public CursoDao() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Curso curso) throws Exception {
		if (curso == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO Curso (idCurso, NMCurso) values (?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, curso.getIdCurso());
			ps.setString(2, curso.getNomeCurso());

			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Curso curso) throws Exception {
		if (curso == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE Curso set NMCurso=? WHERE idCurso=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, curso.getNomeCurso());
			ps.setInt(2, curso.getIdCurso());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de excluir
	public void excluir(Curso curso) throws Exception {
		if (curso == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM Curso WHERE idCurso = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, curso.getIdCurso());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// procurar curso
	public Curso procurarCurso(int idCurso) throws Exception {

		try {
			String SQL = "SELECT  * FROM Curso WHERE idCurso=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idCurso);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);

				curso = new Curso(codigo, nome);
			}
			return curso;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// listar todos os cursos
	public List todosCursos() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM Curso");
			rs = ps.executeQuery();
			List<Curso> list = new ArrayList<Curso>();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				list.add(new Curso(codigo, nome));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public int maiorID() throws Exception {

		try {
			String SQL = "SELECT MAX(idcurso) FROM Curso";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			int codigo = 0;
			if (rs.next()) {
				codigo = rs.getInt(1);
			}
			return codigo;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	
}
