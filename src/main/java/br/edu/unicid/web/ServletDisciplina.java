package br.edu.unicid.web;

import java.io.IOException;
import java.util.List;

import br.edu.unicid.bean.Curso;
import br.edu.unicid.bean.Disciplina;
import br.edu.unicid.dao.CursoDao;
import br.edu.unicid.dao.DisciplinaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletDisciplina")
public class ServletDisciplina extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
		String cmd = request.getParameter("cmd");
		String idCurso = request.getParameter("idCurso");
		String idDisciplina = request.getParameter("idDisciplina");
		// cria um objeto dao - CRUD
		DisciplinaDao dao;
		CursoDao Cursodao;
		// cria um objeto do tipo curso
		Disciplina disciplina = new Disciplina();
		if (cmd != null) {
			try {
				// inicializa os atributos da classe Cursos
				disciplina.setIdDisciplina(Integer.parseInt(request.getParameter("idDisciplina")));
				disciplina.setNomeDisciplina(request.getParameter("nomeDisciplina"));
				disciplina.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
				disciplina.setNomeCurso(request.getParameter("nomeCurso"));
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		try {
			// cria a instancia do objeto dao
			dao = new DisciplinaDao();
			Cursodao = new CursoDao();
			RequestDispatcher rd = null;
			// lista todos os cursos
			if (cmd.equalsIgnoreCase("listar")) {
				List<Disciplina> disciplinasList;				
					disciplinasList = dao.todosDisciplinas();
				//List<Curso> cursoList = Cursodao.todosCursos();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("disciplinasList", disciplinasList);
				//request.setAttribute("cursoList", cursoList);
				// redireciona para a JSP mostraCursosCads
				rd = request.getRequestDispatcher("/mostrarDisciplinaCads.jsp");
			}
			
			
			if (cmd.equalsIgnoreCase("filtrar")) {
				List<Disciplina> disciplinasList;
				if (idCurso == null) {
					disciplinasList = dao.todosDisciplinas();
				}
				else {
					disciplinasList = dao.filtroDisciplinas(idCurso);
				}
				//List<Curso> cursoList = Cursodao.todosCursos();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("disciplinasList", disciplinasList);
				//request.setAttribute("cursoList", cursoList);
				// redireciona para a JSP mostraCursosCads
				//rd = request.getRequestDispatcher("/filtrarDisciplina.jsp");
			}

			// incluir curso
			else if (cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(disciplina);
				rd = request.getRequestDispatcher("ServletDisciplina?cmd=listar");

				// consulta curso para exclusão
			 } else if (cmd.equalsIgnoreCase("exc")) {
                disciplina = dao.procurarDisciplina(Integer.parseInt(idDisciplina));
                HttpSession session = request.getSession(true);
                session.setAttribute("disciplina", disciplina);
                rd = request.getRequestDispatcher("/formExcDisciplina.jsp");
             
            // exclui curso
            } else if (cmd.equalsIgnoreCase("excluir")) {
                dao.excluir(disciplina);
                rd = request.getRequestDispatcher("ServletDisciplina?cmd=listar");

				// consulta curso para alteração
			} else if (cmd.equalsIgnoreCase("atu")) {
				disciplina = dao.procurarDisciplina(Integer.parseInt(idDisciplina));
				HttpSession session = request.getSession(true);
				session.setAttribute("disciplina", disciplina);
				rd = request.getRequestDispatcher("/formAttDisciplina.jsp");

				// consulta curso
			} else if (cmd.equalsIgnoreCase("con")) {
				disciplina = dao.procurarDisciplina(disciplina.getIdDisciplina());
				HttpSession session = request.getSession(true);
				session.setAttribute("disciplina", disciplina);
				rd = request.getRequestDispatcher("/formConDisciplina.jsp");

				// altera curso
			} else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(disciplina);
				rd = request.getRequestDispatcher("ServletDisciplina?cmd=listar");

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