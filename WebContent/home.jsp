<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- Materialize CSS -->
<link rel="stylesheet" href="materialize/css/materialize.min.css">
<link rel="stylesheet" href="materialize/css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div class="row container ">

		<div class="col blue s8 white-text push-s2">
			<div>
				<h3 class="white-text center-align">DICIONÁRIO DE IMAGENS</h3>			
				<h6 class="white-text center-align">Palavras de Difícil Compreensão Para os Alunos Surdos</h6>
			</div>
		</div>

		<div class="col grey blue-grey lighten-2 s8 black-text push-s2">
			<div id="login" class="row">			
				<form class="col s10 " method="post" action="ServletExibirImagem">
								
					<div class="row">
						<div class="input-field col s10">
							<i class="material-icons prefix">mode_edit</i>
							<input id="palavra" type="text" name="palavra" class="validate" value="${arquivo.palavra}">
							<label for="palavra">Palavra</label>
						</div>
					</div>
					
					<div class="row center-align">
						<button id="botaoEnviar" class="btn pink waves-effect waves-light "
							type="submit" name="action">
							Buscar<i class="material-icons right">search</i>
						</button>
					</div>
					
					<div class="row"> 
						<div class="input-field col s10">
							<i class="material-icons prefix">chat_bubble_outline</i> 
							<input id="significado" type="text" name="significado"class="validate" value="${arquivo.significado}">
							<label for="significado">Significado</label>
						</div>
					</div>
			 		
			 		<img class="responsive-img" src="imagens/${arquivo.nomeSistemaArquivo}"><br>
			 													
					<a class="black-text" href="home.jsp">Nova Busca!</a>												
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