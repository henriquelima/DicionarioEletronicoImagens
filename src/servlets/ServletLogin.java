package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import entidade.Usuario;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultaByEmail(email);
		
		if(usuario != null){
			if(usuario.getSenha().equals(senha)){
				
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario);
				response.sendRedirect("cadastro.jsp");
				
			}else{
				
				out.println("<h1>Senha Incorreta</h1>");
				out.println("<a href='login.jsp'>Click para Voltar</a>");
			}
		}else{
			
			out.println("<h1>Usuario Não Existe!</h1>");
			out.println("<a href='login.jsp'>Click para voltar!</a>");
		}		
	}
}
