<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"	rel="stylesheet">

<!-- Materialize CSS -->
<link rel="stylesheet" href="materialize/css/materialize.min.css">
<link rel="stylesheet" href="materialize/css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Inicial</title>
</head>

<body>
	<div class="row container ">

		<div class="col blue s8 white-text push-s2">
			<div id="text">
				<h3 class="white-text center-align">DICIONÁRIO DE IMAGENS</h3>			
				<h6 class="white-text center-align">Palavras de Difícil Compreensão Para os Alunos Surdos</h6>
			</div>
		</div>		

		<div class="col grey blue-grey lighten-2 s8 push-s2">

			<div class="container center-align ">
				<form method="post" action="home.jsp">
					<button id="home" class="btn blue waves-effect waves-light " type="submit"
						name="action">
						Buscar Palavra <i class="material-icons right">search</i>
					</button>
				</form>
			</div>

			<div class="container center-align ">
				<form method="post" action="login.jsp">
					<button id="botaoLogin" class="btn pink waves-effect waves-light " type="submit"
						name="action">
						Adicionar Palavra <i class="material-icons right">system_update_alt</i>
					</button>
				</form>
			</div>
		</div>

		<div id="rodape" class="col s8 black-text push-s2">

			<h6 class="right-align">
				Criador: José Henrique da Silveira Lima<br> Imagens: GOOGLE, Significados: Mini Aurélio 6ºEdição
			</h6>

			<img src="imagens/ifpb.png" alt="IFPB-Campus Campina Grande" height="30">
			<img src="imagens/lampeju.jpg" alt="Lampeju" height="30">
		</div>
	</div>
	<!-- Materialize JQuery -->
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

	<!-- Materialize JavaScript -->
	<script src="materialize/js/materialize.min.js"></script>

</body>
</html>