package br.edu.unicid.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import br.edu.unicid.bean.Disciplina;
import br.edu.unicid.bean.Curso;
import br.edu.unicid.util.ConnectionFactory;

public class DisciplinaDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Disciplina disciplina;

	public DisciplinaDao() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Disciplina disciplina) throws Exception {
		if (disciplina == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO Disciplina values (?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, disciplina.getIdDisciplina());
			ps.setString(2, disciplina.getNomeDisciplina());
			ps.setInt(3, disciplina.getIdCurso());

			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Disciplina disciplina) throws Exception {
		if (disciplina == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE Disciplina set nmDisciplina=?, idCurso = ? WHERE idDisciplina=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, disciplina.getNomeDisciplina());
			ps.setInt(2, disciplina.getIdCurso());
			ps.setInt(3, disciplina.getIdDisciplina());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de excluir
	public void excluir(Disciplina disciplina) throws Exception {
		if (disciplina == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM Disciplina WHERE idDisciplina = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, disciplina.getIdDisciplina());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// procurar disciplina
	public Disciplina procurarDisciplina(int idDisciplina) throws Exception {

		try {
			String SQL = "SELECT  D.IDDISCIPLINA, D.NMDISCIPLINA, D.IDCURSO, C.NMCURSO  FROM DISCIPLINA D INNER JOIN CURSO C ON D.IDCURSO = C.IDCURSO WHERE IDDISCIPLINA=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idDisciplina);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codDisciplina = rs.getInt(1);
				String nmDisciplina = rs.getString(2);
				int codCurso = rs.getInt(3);
				String nmCurso = rs.getString(4);

				disciplina = new Disciplina(codDisciplina, nmDisciplina, codCurso, nmCurso);
			}
			return disciplina;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// listar todos os disciplinas
	public List todosDisciplinas() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT  D.IDDISCIPLINA, D.NMDISCIPLINA, D.IDCURSO, C.NMCURSO  FROM DISCIPLINA D INNER JOIN CURSO C ON D.IDCURSO = C.IDCURSO");
			rs = ps.executeQuery();
			List<Disciplina> list = new ArrayList<Disciplina>();
			while (rs.next()) {
				int codDisciplina = rs.getInt(1);
				String nmDisciplina = rs.getString(2);
				int codCurso = rs.getInt(3);
				String nmCurso = rs.getString(4);
				list.add(new Disciplina(codDisciplina, nmDisciplina, codCurso, nmCurso));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public List filtroDisciplinas(String idCurso) throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM Produto WHERE idCurso = " + idCurso);
			rs = ps.executeQuery();
			List<Disciplina> list = new ArrayList<Disciplina>();
			while (rs.next()) {
				int codigoDisciplina = rs.getInt(1);
				String nomeDisciplina = rs.getString(2);
				int codigoCurso = rs.getInt(3);
				String nomeCurso = rs.getString(4);
				list.add(new Disciplina(codigoDisciplina, nomeDisciplina, codigoCurso, nomeCurso));
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
			String SQL = "SELECT MAX(iddisciplina) FROM Disciplina";
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
