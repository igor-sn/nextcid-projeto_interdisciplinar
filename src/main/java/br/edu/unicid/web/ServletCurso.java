package br.edu.unicid.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.unicid.bean.Curso;
import br.edu.unicid.dao.CursoDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet {

	 private Date strToDate(String data) throws Exception {
	        if (data == null) {
	            return null;
	        }

	        Date dataF = null;
	        try {
	            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	            long timestamp = dateFormat.parse(data).getTime();
	            dataF = new Date(timestamp);
	        } catch (ParseException pe) {
	            throw pe;
	        }
	        return dataF;
	    }

	    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        // a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
	        String cmd = request.getParameter("cmd");
	        String codigoCurso = request.getParameter("idCurso");
	        // cria um objeto dao - CRUD
	        CursoDao dao;
	        // cria um objeto do tipo curso
	        Curso curso = new Curso();
	        if (cmd != null) {
	            try {
	                // inicializa os atributos da classe Cursos
	            	curso.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));  
	            	curso.setNomeCurso(request.getParameter("nomeCurso"));
                } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	        try {
	        	// cria a instancia do objeto dao
	            dao = new CursoDao();
	            RequestDispatcher rd = null;
	            // lista todos os cursos
	            if (cmd.equalsIgnoreCase("listar")) {
	                List<Curso> cursosList = dao.todosCursos();
	                // cria uma sessão para encaminhar a lista para uma JSP
	                request.setAttribute("cursosList", cursosList);
	                // redireciona para a JSP mostraCursosCads
	                rd = request.getRequestDispatcher("/mostrarCursosCads.jsp");
	            }
	            
	            // incluir curso
	            else if (cmd.equalsIgnoreCase("incluir")) {
	                dao.salvar(curso);
	                rd = request.getRequestDispatcher("ServletCurso?cmd=listar");
	             
	            // consulta curso para exclusão    
	            } else if (cmd.equalsIgnoreCase("exc")) {
	                curso = dao.procurarCurso(Integer.parseInt(codigoCurso));
	                HttpSession session = request.getSession(true);
	                session.setAttribute("curso", curso);
	                rd = request.getRequestDispatcher("/formExcCurso.jsp");
	             
	            // exclui curso
	            } else if (cmd.equalsIgnoreCase("excluir")) {
	                dao.excluir(curso);
	                rd = request.getRequestDispatcher("ServletCurso?cmd=listar");
	            
	            // consulta curso para alteração
	            }  else if (cmd.equalsIgnoreCase("atu")) {
	                curso = dao.procurarCurso(Integer.parseInt(codigoCurso));
	                HttpSession session = request.getSession(true);
	                session.setAttribute("curso", curso);
	                rd = request.getRequestDispatcher("/formAttCurso.jsp");
	             
	            // consulta curso
	            } else if (cmd.equalsIgnoreCase("con")) {
	                curso = dao.procurarCurso(curso.getIdCurso());
	                HttpSession session = request.getSession(true);
	                session.setAttribute("curso", curso);
	                rd = request.getRequestDispatcher("/formConCurso.jsp");
	            
	             // altera curso    
	            } else if (cmd.equalsIgnoreCase("atualizar")) {
	                dao.atualizar(curso);
	                rd = request.getRequestDispatcher("ServletCurso?cmd=listar");
	            
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