package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArquivoDAO;
import entidade.Arquivo;

@WebServlet("/ServletExibirImagem")
public class ServletExibirImagem extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String palavra = request.getParameter("palavra");
		
		ArquivoDAO dao =  new ArquivoDAO();
		
		Arquivo arquivo = dao.consultaByPalavra(palavra);
		
		if(arquivo != null){			
			request.setAttribute("arquivo", arquivo);
			request.getRequestDispatcher("home.jsp").forward(request, response);						
		}else{
			out.println("<h1>Palavra Não Encontrada!</h1>");
			out.println("<a href='home.jsp'>Click para Voltar!</a>");
		}
	}
}
