package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ArquivoDAO;
import entidade.Arquivo;
import util.ArquivoUtil;

@WebServlet("/ServletArquivo")
@MultipartConfig
public class ServletArquivo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String pastaImagens = null;
	
	public void init() throws ServletException {
		super.init();
		pastaImagens = getServletContext().getInitParameter("pastaImagens");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String palavra = request.getParameter("palavra");
		String significado = request.getParameter("significado");
		
		// pegando a pasta do projeto
		String pastaProjeto = getServletContext().getRealPath("");

		// definir o caminho completo da pasta das imagens
		String salvarEm = pastaProjeto + File.separator + pastaImagens;
		System.out.println("Salvando arquivos em: " + salvarEm);

		// Verificar se existe a pasta, caso não exista é criada uma
		File pasta = new File(salvarEm);
		if (!pasta.exists()) {
			// cria pasta
			pasta.mkdir();
		}
		
		//pega arquivo selecionado
		Part arquivoSelecionado = request.getPart("imagem");
		String nomeRealArquivo = arquivoSelecionado.getSubmittedFileName();
		
		//nome arquivo 	
		//Usuario usuario = new Usuario();
		
		String nomeSistemaArquivo = ArquivoUtil.getNomeSistemaArquivo(palavra, nomeRealArquivo);
		
		ArquivoDAO dao = new ArquivoDAO(); 
		Arquivo resp = dao.consultaByPalavra(palavra);
		
		if(resp == null){			
		//Grava no disco
		arquivoSelecionado.write(salvarEm + File.separator + nomeSistemaArquivo);
		request.setAttribute("nomeImagem", nomeSistemaArquivo);
		
		//arquivo generico
		Arquivo arquivo = new Arquivo();
		arquivo.setPalavra(palavra);
		arquivo.setSignificado(significado);
		//arquivo.setNomeRealArquivo(nomeRealArquivo);
		arquivo.setNomeSistemaArquivo(nomeSistemaArquivo);
		
		//Persistindo arquivo		
		dao.adiciona(arquivo);	
		}else{
			out.println("<h1>Palavra já Cadastrada!</h1>");
			out.println("<a href='cadastro.jsp'>Click para voltar!</a>");
		}
		response.sendRedirect("cadastro.jsp");
	}
}