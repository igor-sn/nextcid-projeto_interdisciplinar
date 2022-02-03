package br.edu.unicid.web;

import java.io.IOException;
import java.util.List;

import br.edu.unicid.bean.Curso;
import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.CursoDao;
import br.edu.unicid.dao.QuestaoDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletQuestao")
public class ServletQuestao extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
		String cmd = request.getParameter("cmd");
		String idCurso = request.getParameter("idCurso");
		String anoQuestao = request.getParameter("anoQuestao");
		String idQuestao = request.getParameter("idQuestao");
		String idDisciplina = request.getParameter("idDisciplina");
		// cria um objeto dao - CRUD
		QuestaoDao dao;
		CursoDao Cursodao;
		// cria um objeto do tipo questao
		Questao questao = new Questao();
		if (cmd != null) {
			try {
				// inicializa os atributos da classe Cursos
				questao.setIdQuestao(Integer.parseInt(request.getParameter("idQuestao")));
				questao.setAnoQuestao(request.getParameter("anoQuestao"));
				questao.setnQuestao(request.getParameter("nQuestao"));
				questao.setTpQuestao(request.getParameter("tpQuestao"));
				questao.setEnunciado(request.getParameter("enunciado"));
				questao.setImg(request.getParameter("img"));
				questao.setAltA(request.getParameter("altA"));
				questao.setAltB(request.getParameter("altB"));
				questao.setAltC(request.getParameter("altC"));
				questao.setAltD(request.getParameter("altD"));
				questao.setAltE(request.getParameter("altE"));
				questao.setRespAlt(request.getParameter("respAlt"));
				questao.setRespDiss(request.getParameter("respDiss"));
				questao.setIdDisciplina1(Integer.parseInt(request.getParameter("idDisciplina1")));
				questao.setNomeDisciplina1(request.getParameter("nomeDisciplina1"));
				questao.setIdDisciplina2(Integer.parseInt(request.getParameter("idDisciplina2")));
				questao.setNomeDisciplina2(request.getParameter("nomeDisciplina2"));
				questao.setIdDisciplina3(Integer.parseInt(request.getParameter("idDisciplina3")));
				questao.setNomeDisciplina3(request.getParameter("nomeDisciplina3"));
				questao.setIdDisciplina4(Integer.parseInt(request.getParameter("idDisciplina4")));
				questao.setNomeDisciplina4(request.getParameter("nomeDisciplina4"));
				questao.setNomeCurso(request.getParameter("nomeCurso"));

				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		try {
			// cria a instancia do objeto dao
			dao = new QuestaoDao();
			Cursodao = new CursoDao();
			RequestDispatcher rd = null;
			// lista todos os questaos
			if (cmd.equalsIgnoreCase("listar")) {
				List<Questao> questoesList;				
				questoesList = dao.todasQuestoes();
				//List<Curso> questaoList = Cursodao.todosCursos();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("questoesList", questoesList);
				//request.setAttribute("questaoList", questaoList);
				// redireciona para a JSP mostraCursosCads
				rd = request.getRequestDispatcher("/mostrarQuestaoCads.jsp");
			}
			
			/*if (cmd.equalsIgnoreCase("listarDiss")) {
				List<Questao> questoesList;				
				questoesList = dao.todasQuestoesDiss();
				//List<Curso> questaoList = Cursodao.todosCursos();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("questaosList", questoesList);
				//request.setAttribute("questaoList", questaoList);
				// redireciona para a JSP mostraCursosCads
				rd = request.getRequestDispatcher("/mostrarQuestaoCads.jsp");
			}*/
			
			
			if (cmd.equalsIgnoreCase("filtrarQuestoes")) {
				List<Questao> questoesList;
				
				int idCursoFiltro = Integer.parseInt(idCurso);
				int idDisciplinaFiltro = Integer.parseInt(idDisciplina);
				
				if (idCursoFiltro == 0 && idDisciplinaFiltro == 0 && anoQuestao.equals(""))  {
					questoesList = dao.todasQuestoes();
				}
				else {
					questoesList = dao.filtroQuestoes(idCursoFiltro, idDisciplinaFiltro, anoQuestao);
				}
		
				
				
				
				//List<Curso> questaoList = Cursodao.todosCursos();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("questoesList", questoesList);
				//request.setAttribute("questaoList", questaoList);
				// redireciona para a JSP mostraCursosCads
				rd = request.getRequestDispatcher("/filtrarQuestoes.jsp");
			}

			// incluir questao
			else if (cmd.equalsIgnoreCase("incluirAlt")) {
				dao.salvarAlt(questao);
				rd = request.getRequestDispatcher("ServletQuestao?cmd=listar");
				
			}else if (cmd.equalsIgnoreCase("incluirDiss")) {
					dao.salvarDiss(questao);
					rd = request.getRequestDispatcher("ServletQuestao?cmd=listar");

				// consulta questao para exclusão
			 } else if (cmd.equalsIgnoreCase("exc")) {
                questao = dao.procurarQuestao(Integer.parseInt(idQuestao));
                HttpSession session = request.getSession(true);
                session.setAttribute("questao", questao);
                rd = request.getRequestDispatcher("/formExcQuestao.jsp");
             
            // exclui questao
            } else if (cmd.equalsIgnoreCase("excluir")) {
                dao.excluir(questao);
                rd = request.getRequestDispatcher("ServletQuestao?cmd=listar");

				// consulta questao para alteração
			} else if (cmd.equalsIgnoreCase("atu")) {
				questao = dao.procurarQuestao(Integer.parseInt(idQuestao));
				HttpSession session = request.getSession(true);
				session.setAttribute("questao", questao);
				rd = request.getRequestDispatcher("/formAttQuestao.jsp");

				// consulta questao
			} else if (cmd.equalsIgnoreCase("con")) {
				questao = dao.procurarQuestao(questao.getIdQuestao());
				HttpSession session = request.getSession(true);
				session.setAttribute("questao", questao);
				rd = request.getRequestDispatcher("/formConQuestao.jsp");

				// altera questao
			} else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(questao);
				rd = request.getRequestDispatcher("ServletQuestao?cmd=listar");

				// direciona para a página principal
			} else if (cmd.equalsIgnoreCase("principal")) {
				rd = request.getRequestDispatcher("/index.jsp");
			}
			// executa a ação de direcionar para a página JSP
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}