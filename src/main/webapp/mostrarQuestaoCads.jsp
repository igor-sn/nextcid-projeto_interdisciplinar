<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.edu.unicid.bean.Disciplina"%>
<%@ page import="br.edu.unicid.bean.Questao"%>
<%@ page import="br.edu.unicid.bean.Curso"%>
<%@ page import="br.edu.unicid.dao.CursoDao"%>
<%@ page import="br.edu.unicid.dao.DisciplinaDao"%>
<%@ page import="br.edu.unicid.dao.QuestaoDao"%>

<!DOCTYPE html>

<html lang="pt-br">
<script>

</script>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Fontes -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap"
	rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="./css/css.css">
<link rel="stylesheet" type="text/css" href="./css/cssrelatorio.css">
<title>Nextcid | Listar Questões</title>
</head>
<!-- id = # / class = . -->

<body>

	<header>
		<!-- Barra Menu -->
		<div class="container" id="nav-container">
			<nav class="navbar navbar-expand-lg  fixed-top">
				<a class="navbar-brand" href="index.jsp"><img id="logo"
					src="./imgs/logo_novo.png" alt="NextCid"
					style="width: 30%; height: 30%;"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbar-links" aria-controls="navbar-links"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</nav>
		</div>
		<!-- Fim da barra menu -->
	</header>

	<br>
	<!-- Conteudo -->
	<!-- Div principal -->
	<div class="parallax">
		<br>
		<div class = "wrapper " style = "min-height : 850px;">
			<br>
			<!-- Sidebar  -->
			<nav id="sidebar">

				<div class="sidebar-header" style="height: auto;"></div>
				<ul class="list-unstyled components" style="height: auto;">
					<li><a href="#homeSubmenu" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-mortarboard"
								viewBox="0 0 16 16">
                            <path
									d="M8.211 2.047a.5.5 0 0 0-.422 0l-7.5 3.5a.5.5 0 0 0 .025.917l7.5 3a.5.5 0 0 0 .372 0L14 7.14V13a1 1 0 0 0-1 1v2h3v-2a1 1 0 0 0-1-1V6.739l.686-.275a.5.5 0 0 0 .025-.917l-7.5-3.5ZM8 8.46 1.758 5.965 8 3.052l6.242 2.913L8 8.46Z" />
                            <path
									d="M4.176 9.032a.5.5 0 0 0-.656.327l-.5 1.7a.5.5 0 0 0 .294.605l4.5 1.8a.5.5 0 0 0 .372 0l4.5-1.8a.5.5 0 0 0 .294-.605l-.5-1.7a.5.5 0 0 0-.656-.327L8 10.466 4.176 9.032Zm-.068 1.873.22-.748 3.496 1.311a.5.5 0 0 0 .352 0l3.496-1.311.22.748L8 12.46l-3.892-1.556Z" />
                            </svg> &nbsp;Curso
					</a>
						<ul class="collapse list-unstyled" id="homeSubmenu">
							<li><a href="incluirCurso.jsp"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-file-plus"
										viewBox="0 0 16 16">
                                    <path
											d="M8.5 6a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V10a.5.5 0 0 0 1 0V8.5H10a.5.5 0 0 0 0-1H8.5V6z" />
                                    <path
											d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1z" />
                                    </svg> &nbsp;Incluir Curso
							</a></li>
							<li><a href="ServletCurso?cmd=listar"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-file-earmark-text"
										viewBox="0 0 16 16">
                                    <path
											d="M5.5 7a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zM5 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5z" />
                                    <path
											d="M9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.5L9.5 0zm0 1v2A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5z" />
                                    </svg> &nbsp;Listar Curso
							</a></li>
						</ul></li>
					<li><a href="#pageSubmenu" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
                            <path
									d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z" />
                            </svg> &nbsp;Disciplina
					</a>
						<ul class="collapse list-unstyled" id="pageSubmenu">
							<li><a href="incluirDisciplina.jsp"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-file-plus"
										viewBox="0 0 16 16">
                                    <path
											d="M8.5 6a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V10a.5.5 0 0 0 1 0V8.5H10a.5.5 0 0 0 0-1H8.5V6z" />
                                    <path
											d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1z" />
                                    </svg> &nbsp;Incluir Disciplina
							</a></li>
							<li><a href="ServletDisciplina?cmd=listar"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-file-earmark-text"
										viewBox="0 0 16 16">
                                    <path
											d="M5.5 7a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zM5 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5z" />
                                    <path
											d="M9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.5L9.5 0zm0 1v2A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5z" />
                                    </svg> &nbsp;Listar Disciplina
							</a></li>
						</ul></li>
					<li><a href="#pageSubmenu1" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-list-check" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
									d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3.854 2.146a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708L2 3.293l1.146-1.147a.5.5 0 0 1 .708 0zm0 4a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708L2 7.293l1.146-1.147a.5.5 0 0 1 .708 0zm0 4a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 0 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0z" />
                            </svg> &nbsp;Questões
					</a>
						<ul class="collapse list-unstyled" id="pageSubmenu1">
							<li><a href="#pageSubmenu2" data-toggle="collapse"
								aria-expanded="false" class="dropdown-toggle"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-file-plus"
										viewBox="0 0 16 16">
                                    <path
											d="M8.5 6a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V10a.5.5 0 0 0 1 0V8.5H10a.5.5 0 0 0 0-1H8.5V6z" />
                                    <path
											d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1z" />
                                    </svg> &nbsp;Incluir Questões
							</a>
								<ul class="collapse list-unstyled" id="pageSubmenu2">
									<li><a style="margin-left: 15px"
										href="incluirQuestaoDiss.jsp">Questões Dissertativas</a></li>
									<li><a style="margin-left: 15px"
										href="incluirQuestaoAlt.jsp">Questões Objetivas</a></li>
								</ul></li>
							
							<li><a href="ServletQuestao?cmd=listar"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-file-earmark-text"
										viewBox="0 0 16 16">
                                    <path
											d="M5.5 7a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zM5 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5z" />
                                    <path
											d="M9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.5L9.5 0zm0 1v2A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5z" />
                                    </svg> &nbsp;Listar Questões
							</a></li>
						</ul></li>
					<li><a href="#pageSubmenu4" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-journal-text"
								viewBox="0 0 16 16">
                            <path
									d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z" />
                            <path
									d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z" />
                            <path
									d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z" />
                            </svg> &nbsp;Relatorios
					</a>
						<ul class="collapse list-unstyled" id="pageSubmenu4">
							<li><a href="relatorio.jsp"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-funnel" viewBox="0 0 16 16">
                                    <path
											d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5v-2zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2h-11z" />
                                    </svg> &nbsp;Pesquisar
							</a></li>
						</ul></li>
				</ul>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
			</nav>

			<div class="container" style="width: auto;">

				<br>
				<br>

				<div class="row" style="width: 1200px;">
					<div class="col-sm-12">
						<div class="card">
							
								<h4 class="card-title">
									<b>Lista de Questões Objetivas</b>
								</h4>
								
								<hr>
								<div class = "questao">

								
								
								<%
                                List <Questao> lista = new ArrayList<Questao>();
                                lista = (ArrayList)request.getAttribute("questoesList");
                                for(Questao a: lista){
                                	if(a.getTpQuestao().equals("Objetiva")){
                                	%>
									<h1>
										<br> Cód:
										<%=a.getIdQuestao()%>
										-  Questao
										<%=a.getTpQuestao()%>
										Nº
										<%=a.getnQuestao()%></h1>
									<div class = "infoquestao">	
											<p id="titulo">Ano:</p>
											<p><%=a.getAnoQuestao()%></p>
											<p id="titulo">Curso:</p>
											<p><%=a.getNomeCurso()%></p>
											<p id="titulo">Disciplina 1:</p>
											<p><%=a.getNomeDisciplina1()%></p>
											<p id="titulo">Disciplina 2:</p>
											<p><%=a.getNomeDisciplina2()%></p>
											<p id="titulo">Disciplina 3:</p>
											<p><%=a.getNomeDisciplina3()%></p>
											<p id="titulo">Disciplina 4:</p>
											<p><%=a.getNomeDisciplina4()%></p>
								</div>
								<p><span id = "enunciado">Enunciado:</span>
								 <%=a.getEnunciado()%></p>
								<img src="./imgs/<%=a.getImg()%>" style="width: 60%; height: 60%;">
							
								 <p id= "alternativas"><span id = "circulos">A </span><%=a.getAltA()%></p>
								
								  <p id= "alternativas"><span id = "circulos">B </span> <%=a.getAltB()%> </p>
								
								  <p id= "alternativas"><span id = "circulos">C </span> <%=a.getAltC()%> </p>
								
								  <p id= "alternativas"><span id = "circulos">D </span><%=a.getAltD()%> </p>
								
								 <p id= "alternativas"><span id = "circulos">E </span> <%=a.getAltE()%></p>
								
								<p id="respcorreta"> Resposta correta:
								<%=a.getRespAlt()%></p>
								
								<a type="button" class="btn-lg btn-success" style="height: auto; widght: auto; font-size: 13px" href=<%="ServletQuestao?cmd=atu&idQuestao=".concat(String.valueOf(a.getIdQuestao()))%>>Alterar</a>
                                <a type="button" class="btn-lg btn-danger" style="height: auto; widght: auto; font-size: 13px" href=<%="ServletQuestao?cmd=exc&idQuestao=".concat(String.valueOf(a.getIdQuestao()))%>>Excluir</a>
								<hr id="linhabranca">
								

								<%}
                                    }
                                    %>

							</div>
							
							<hr>
						</div>
					</div>
				</div>
				
				
								<div class="row" style="width: 1200px;">
					<div class="col-sm-12">
						<div class="card">
							
								<h4 class="card-title">
									<b>Lista de Questões Dissertativas</b>
								</h4>
								
								<hr>
								<div class = "questao">

								
								
								<%
                                //List <Questao> lista = new ArrayList<Questao>();
                                lista = (ArrayList)request.getAttribute("questoesList");
                                for(Questao a: lista){
                                	if(a.getTpQuestao().equals("Dissertativa")){
                                	%>
									<h1>
										<br> Cód:
										<%=a.getIdQuestao()%>
										-  Questao
										<%=a.getTpQuestao()%>
										Nº
										<%=a.getnQuestao()%></h1>
									<div class = "infoquestao">	
											<p id="titulo">Ano:</p>
											<p><%=a.getAnoQuestao()%></p>
											<p id="titulo">Curso:</p>
											<p><%=a.getNomeCurso()%></p>
											<p id="titulo">Disciplina 1:</p>
											<p><%=a.getNomeDisciplina1()%></p>
											<p id="titulo">Disciplina 2:</p>
											<p><%=a.getNomeDisciplina2()%></p>
											<p id="titulo">Disciplina 3:</p>
											<p><%=a.getNomeDisciplina3()%></p>
											<p id="titulo">Disciplina 4:</p>
											<p><%=a.getNomeDisciplina4()%></p>
								</div>
								<p><span id = "enunciado">Enunciado:</span>
								 <%=a.getEnunciado()%></p>
								<img src="./imgs/<%=a.getImg()%>" style="width: 60%; height: 60%;">
								
								<p id="respcorreta"> Resposta correta:
								<%=a.getRespDiss()%></p>
								
								
								<a type="button" class="btn-lg btn-success" style="height: auto; widght: auto; font-size: 13px" href=<%="ServletQuestao?cmd=atu&idQuestao=".concat(String.valueOf(a.getIdQuestao()))%>>Alterar</a>
                                <a type="button" class="btn-lg btn-danger" style="height: auto; widght: auto; font-size: 13px" href=<%="ServletQuestao?cmd=exc&idQuestao=".concat(String.valueOf(a.getIdQuestao()))%>>Excluir</a> 
								<hr id="linhabranca">
								<%}
                                    }
                                    %>

							</div>
							
							<hr>
						</div>
					</div>
				</div>



			</div>
		</div>
		<!-- Footer -->
		<footer class="text-center text-white"
			style="background-color: black;">
			<!-- Copyright -->
			<div class="text-center p-3"
				style="background-color: rgba(0, 0, 0, 0.2);">
				<b>© 2021 Copyright:</b> <a class="text-white"
					href="https://nextcid.com.br/"><b>NEXTCID</b></a>
			</div>
			<!-- Copyright -->
		</footer>
		<!-- Fim do footer -->


		<!-- Scripts -->
		<!-- JavaScript Opcional do Bootstrap-->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="/js/js.js"></script>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
</body>

</html>