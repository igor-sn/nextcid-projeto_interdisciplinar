package br.edu.unicid.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import br.edu.unicid.bean.Disciplina;
import br.edu.unicid.bean.Questao;
import br.edu.unicid.util.ConnectionFactory;

public class QuestaoDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Questao questao;

	public QuestaoDao() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar questao alternativa
	public void salvarAlt(Questao questao) throws Exception {
		if (questao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO Questao (IDQUESTAO, ANOQUESTAO, NQUESTAO, TPQUESTAO, ENUNCIADO, IMG, ALTA, ALTB, ALTC, ALTD, ALTE, RESPALT, IDDISCIPLINA1, IDDISCIPLINA2, IDDISCIPLINA3, IDDISCIPLINA4) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, questao.getIdQuestao());
			ps.setString(2, questao.getAnoQuestao());
			ps.setString(3, questao.getnQuestao());
			ps.setString(4, questao.getTpQuestao());
			ps.setString(5, questao.getEnunciado());
			if(questao.getImg() == ""){
				ps.setNull(6, 0);
			}else {
				ps.setString(6, questao.getImg());
			}
			ps.setString(7, questao.getAltA());
			ps.setString(8, questao.getAltB());
			ps.setString(9, questao.getAltC());
			ps.setString(10, questao.getAltD());
			ps.setString(11, questao.getAltE());
			ps.setString(12, questao.getRespAlt());
			ps.setInt(13, questao.getIdDisciplina1());
			if(questao.getIdDisciplina2() == 0){
				ps.setNull(14, 0);
			}else {
				ps.setInt(14, questao.getIdDisciplina2());
			}
			if(questao.getIdDisciplina3() == 0){
				ps.setNull(15, 0);
			}else {
				ps.setInt(15, questao.getIdDisciplina3());
			}
			if(questao.getIdDisciplina4() == 0){
				ps.setNull(16, 0);
			}else {
				ps.setInt(16, questao.getIdDisciplina4());
			}


			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	// método de salvar questao dissertativa
	public void salvarDiss(Questao questao) throws Exception {
		if (questao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO Questao (IDQUESTAO, ANOQUESTAO, NQUESTAO, TPQUESTAO, ENUNCIADO, IMG, RESPDISS, IDDISCIPLINA1, IDDISCIPLINA2, IDDISCIPLINA3, IDDISCIPLINA4) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, questao.getIdQuestao());
			ps.setString(2, questao.getAnoQuestao());
			ps.setString(3, questao.getnQuestao());
			ps.setString(4, questao.getTpQuestao());
			ps.setString(5, questao.getEnunciado());
			if(questao.getImg() == ""){
				ps.setNull(6, 0);
			}else {
				ps.setString(6, questao.getImg());
			}
			
			ps.setString(7, questao.getRespDiss());
			ps.setInt(8, questao.getIdDisciplina1());
			if(questao.getIdDisciplina2() == 0){
				ps.setNull(9, 0);
			}else {
				ps.setInt(9, questao.getIdDisciplina2());
			}
			if(questao.getIdDisciplina3() == 0){
				ps.setNull(10, 0);
			}else {
				ps.setInt(10, questao.getIdDisciplina3());
			}
			if(questao.getIdDisciplina4() == 0){
				ps.setNull(11, 0);
			}else {
				ps.setInt(11, questao.getIdDisciplina4());
			}
		
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Questao questao) throws Exception {
		if (questao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			
			String tipoQuestao = questao.getTpQuestao();
			
			if(tipoQuestao.equals("Objetiva")) {
				String SQL = "UPDATE Questao set ANOQUESTAO = ?, NQUESTAO = ?, TPQUESTAO = ?, ENUNCIADO = ?, IMG = ?, ALTA = ?, ALTB = ?, ALTC = ?, ALTD = ?, ALTE = ?, RESPALT = ?, IDDISCIPLINA1 = ?, IDDISCIPLINA2 = ?, IDDISCIPLINA3 = ?, IDDISCIPLINA4 = ? WHERE idQuestao=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setString(1, questao.getAnoQuestao());
				ps.setString(2, questao.getnQuestao());
				ps.setString(3, questao.getTpQuestao());
				ps.setString(4, questao.getEnunciado());
				ps.setString(5, questao.getImg());
				ps.setString(6, questao.getAltA());
				ps.setString(7, questao.getAltB());
				ps.setString(8, questao.getAltC());
				ps.setString(9, questao.getAltD());
				ps.setString(10, questao.getAltE());
				ps.setString(11, questao.getRespAlt());
				ps.setInt(12, questao.getIdDisciplina1());
				if(questao.getIdDisciplina2() == 0){
					ps.setNull(13, 0);
				}else {
					ps.setInt(13, questao.getIdDisciplina2());
				}
				if(questao.getIdDisciplina3() == 0){
					ps.setNull(14, 0);
				}else {
					ps.setInt(14, questao.getIdDisciplina3());
				}
				if(questao.getIdDisciplina4() == 0){
					ps.setNull(15, 0);
				}else {
					ps.setInt(15, questao.getIdDisciplina4());
				}
				ps.setInt(16, questao.getIdQuestao());
				ps.executeUpdate();	
			}
			
			else {
				String SQL = "UPDATE Questao set ANOQUESTAO = ?, NQUESTAO = ?, TPQUESTAO = ?, ENUNCIADO = ?, IMG = ?, RESPDISS = ?, IDDISCIPLINA1 = ?, IDDISCIPLINA2 = ?, IDDISCIPLINA3 = ?, IDDISCIPLINA4 = ? WHERE idQuestao=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setString(1, questao.getAnoQuestao());
				ps.setString(2, questao.getnQuestao());
				ps.setString(3, questao.getTpQuestao());
				ps.setString(4, questao.getEnunciado());
				ps.setString(5, questao.getImg());
				ps.setString(6, questao.getRespDiss());
				ps.setInt(7, questao.getIdDisciplina1());
				if(questao.getIdDisciplina2() == 0){
					ps.setNull(8, 0);
				}else {
					ps.setInt(8, questao.getIdDisciplina2());
				}
				if(questao.getIdDisciplina3() == 0){
					ps.setNull(9, 0);
				}else {
					ps.setInt(9, questao.getIdDisciplina3());
				}
				if(questao.getIdDisciplina4() == 0){
					ps.setNull(10, 0);
				}else {
					ps.setInt(10, questao.getIdDisciplina4());
				}
				ps.setInt(11, questao.getIdQuestao());
				ps.executeUpdate();	
				
			}
			
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	

	// método de excluir
	public void excluir(Questao questao) throws Exception {
		if (questao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			//String SQL = ;
			conn = this.conn;
			ps = conn.prepareStatement("DELETE FROM QUESTAO WHERE IDQUESTAO = ?");
			ps.setInt(1, questao.getIdQuestao());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// procurar questao 
	public Questao procurarQuestao(int idQuestao) throws Exception {

		try {
			
			String SQL =("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
					+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
					+ "FROM QUESTAO AS Q "
					+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
					+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO WHERE Q.IDQUESTAO = ? "
					);
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idQuestao);
			rs = ps.executeQuery();
			if (rs.next()) {
				
				int codQuestao = rs.getInt(1);
				String anoQuestao = rs.getString(2);
				String tpQuestao = rs.getString(3);
				String nQuestao = rs.getString(4);
				String enunciado = rs.getString(5);
				String img = rs.getString(6);
				String altA = rs.getString(7);
				String altB = rs.getString(8);
				String altC = rs.getString(9);
				String altD = rs.getString(10);
				String altE = rs.getString(11);
				String respAlt = rs.getString(12);
				String respDiss = rs.getString(13);
				int idDisciplina1 = rs.getInt(14);
				String nmDisciplina1 = rs.getString(15);
				int idDisciplina2 = rs.getInt(16);
				String nmDisciplina2 = rs.getString(17);
				int idDisciplina3 = rs.getInt(18);
				String nmDisciplina3 = rs.getString(19);
				int idDisciplina4 = rs.getInt(20);
				String nmDisciplina4 = rs.getString(21);
				String nmCurso = rs.getString(22);
				
				
				questao = new Questao(codQuestao, anoQuestao, nQuestao, tpQuestao, enunciado, img,  altA, altB, altC, altD, altE, respAlt, respDiss, idDisciplina1, nmDisciplina1, idDisciplina2, nmDisciplina2, idDisciplina3, nmDisciplina3, idDisciplina4, nmDisciplina4, nmCurso);

			}
			return questao;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}


	// listar todos os questoes alternativas

	
	public List todasQuestoes() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
					+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
					+ "FROM QUESTAO AS Q "
					+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
					+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO "
					);
			rs = ps.executeQuery();
			List<Questao> list = new ArrayList<Questao>();
			while (rs.next()) {
				int codQuestao = rs.getInt(1);
				String anoQuestao = rs.getString(2);
				String tpQuestao = rs.getString(3);
				String nQuestao = rs.getString(4);
				String enunciado = rs.getString(5);
				String img = rs.getString(6);
				String altA = rs.getString(7);
				String altB = rs.getString(8);
				String altC = rs.getString(9);
				String altD = rs.getString(10);
				String altE = rs.getString(11);
				String respAlt = rs.getString(12);
				String respDiss = rs.getString(13);
				int idDisciplina1 = rs.getInt(14);
				String nmDisciplina1 = rs.getString(15);
				int idDisciplina2 = rs.getInt(16);
				String nmDisciplina2 = rs.getString(17);
				int idDisciplina3 = rs.getInt(18);
				String nmDisciplina3 = rs.getString(19);
				int idDisciplina4 = rs.getInt(20);
				String nmDisciplina4 = rs.getString(21);
				String nmCurso = rs.getString(22);
				list.add(new Questao(codQuestao, anoQuestao, nQuestao, tpQuestao, enunciado, img,  altA, altB, altC, altD, altE, respAlt, respDiss, idDisciplina1, nmDisciplina1, idDisciplina2, nmDisciplina2, idDisciplina3, nmDisciplina3, idDisciplina4, nmDisciplina4, nmCurso));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public List todosAnos() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT DISTINCT anoQuestao FROM QUESTAO;");
			rs = ps.executeQuery();
			List<String> list = new ArrayList<String>();
			while (rs.next()) {
				String anoQuestao = rs.getString(1);
				
				list.add(anoQuestao);
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public List filtroQuestoes(int idCurso, int idDisciplina, String ano) throws Exception {
		try {
			conn = this.conn;
			if(idCurso == 0 && idDisciplina == 0 && ano != "") {
				
				
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
					+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
					+ "FROM QUESTAO AS Q "
					+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
					+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
					+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO "
					+ "WHERE Q.ANOQUESTAO = ?");
				ps.setString(1, ano);
			}
			else if (idCurso != 0 && idDisciplina == 0 && ano == "") {
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
						+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
						+ "FROM QUESTAO AS Q "
						+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
						+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO "
						+ "WHERE D1.IDCURSO = ?");
					ps.setInt(1, idCurso);
			}
			else if (idCurso == 0 && idDisciplina != 0 && ano == "") {
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
						+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
						+ "FROM QUESTAO AS Q "
						+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
						+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO "
						+ "WHERE Q.IDDISCIPLINA1 = ? OR Q.IDDISCIPLINA2 = ? OR Q.IDDISCIPLINA3 = ?  OR Q.IDDISCIPLINA4 = ?");
					ps.setInt(1, idDisciplina);
					ps.setInt(2, idDisciplina);
					ps.setInt(3, idDisciplina);
					ps.setInt(4, idDisciplina);
				
			}
			else if (idCurso != 0 && idDisciplina != 0 && ano != "") {
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
						+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
						+ "FROM QUESTAO AS Q "
						+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
						+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO "
						+ "WHERE (Q.IDDISCIPLINA1 = ? OR Q.IDDISCIPLINA2 = ? OR Q.IDDISCIPLINA3 = ?  OR Q.IDDISCIPLINA4 = ?) AND D1.IDCURSO = ? AND Q.ANOQUESTAO = ?");
					ps.setInt(1, idDisciplina);
					ps.setInt(2, idDisciplina);
					ps.setInt(3, idDisciplina);
					ps.setInt(4, idDisciplina);
					ps.setInt(5, idCurso);
					ps.setString(6, ano);
					
			}
			else if (idCurso != 0 && idDisciplina == 0 && ano != "") {
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
						+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
						+ "FROM QUESTAO AS Q "
						+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
						+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO "
						+ "WHERE  D1.IDCURSO = ? AND Q.ANOQUESTAO = ?");
					ps.setInt(1, idCurso);
					ps.setString(2, ano);
			}
			else if (idCurso != 0 && idDisciplina != 0 && ano == "") {
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
						+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
						+ "FROM QUESTAO AS Q "
						+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
						+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO "
						+ "WHERE (Q.IDDISCIPLINA1 = ? OR Q.IDDISCIPLINA2 = ? OR Q.IDDISCIPLINA3 = ?  OR Q.IDDISCIPLINA4 = ?) AND D1.IDCURSO = ?");
					ps.setInt(1, idDisciplina);
					ps.setInt(2, idDisciplina);
					ps.setInt(3, idDisciplina);
					ps.setInt(4, idDisciplina);
					ps.setInt(5, idCurso);
			}
			else if (idCurso == 0 && idDisciplina != 0 && ano != "") {
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
						+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
						+ "FROM QUESTAO AS Q "
						+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
						+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO "
						+ "WHERE (Q.IDDISCIPLINA1 = ? OR Q.IDDISCIPLINA2 = ? OR Q.IDDISCIPLINA3 = ?  OR Q.IDDISCIPLINA4 = ?) AND Q.ANOQUESTAO = ?");
					ps.setInt(1, idDisciplina);
					ps.setInt(2, idDisciplina);
					ps.setInt(3, idDisciplina);
					ps.setInt(4, idDisciplina);
					ps.setString(5, ano);
				
			}
			else if (idCurso == 0 && idDisciplina == 0 && ano == "") {
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
						+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
						+ "FROM QUESTAO AS Q "
						+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
						+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO ");
			}
			else {
				ps = conn.prepareStatement("SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS, Q.IDDISCIPLINA1, "
						+ "D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO "
						+ "FROM QUESTAO AS Q "
						+ "LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA "
						+ "LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA "
						+ "LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO ");
			}
			rs = ps.executeQuery();
			List<Questao> list = new ArrayList<Questao>();
			while (rs.next()) {
				int codQuestao = rs.getInt(1);
				String anoQuestao = rs.getString(2);
				String tpQuestao = rs.getString(3);
				String nQuestao = rs.getString(4);
				String enunciado = rs.getString(5);
				String img = rs.getString(6);
				String altA = rs.getString(7);
				String altB = rs.getString(8);
				String altC = rs.getString(9);
				String altD = rs.getString(10);
				String altE = rs.getString(11);
				String respAlt = rs.getString(12);
				String respDiss = rs.getString(13);
				int idDisciplina1 = rs.getInt(14);
				String nmDisciplina1 = rs.getString(15);
				int idDisciplina2 = rs.getInt(16);
				String nmDisciplina2 = rs.getString(17);
				int idDisciplina3 = rs.getInt(18);
				String nmDisciplina3 = rs.getString(19);
				int idDisciplina4 = rs.getInt(20);
				String nmDisciplina4 = rs.getString(21);
				String nmCurso = rs.getString(22);
				list.add(new Questao(codQuestao, anoQuestao, nQuestao, tpQuestao, enunciado, img,  altA, altB, altC, altD, altE, respAlt, respDiss, idDisciplina1, nmDisciplina1, idDisciplina2, nmDisciplina2, idDisciplina3, nmDisciplina3, idDisciplina4, nmDisciplina4, nmCurso));
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
			String SQL = "SELECT MAX(idquestao) FROM questao";
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
