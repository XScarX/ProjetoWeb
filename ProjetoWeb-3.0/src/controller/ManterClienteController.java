package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import to.ClienteTO;

/**
 * Servlet implementation class ManterCliente
 */
@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterClienteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cId = request.getParameter("id");
		String cNome = request.getParameter("nome");
		String cFone = request.getParameter("fone");
		String cEndereco = request.getParameter("endereco");
		String cIdade = request.getParameter("idade");
		
		String acao = request.getParameter("manterCliente");
		Cliente cliente;
		Cliente cli = new Cliente();
		
		if ("incluir".equals(acao)) {
			int id = Integer.parseInt(cId);
			cliente = new Cliente(id, cNome, cFone, cEndereco, cIdade);
			cliente.criar();
			cliente.carregar();

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
			out.println("id: " + cliente.getId() + "<br>");
			out.println("Nome: " + cliente.getNome() + "<br>");
			out.println("Fone: " + cliente.getTelefone() + "<br>");
			out.println("Endereço: " + cliente.getEndereco() + "<br>");
			out.println("Idade: " + cliente.getNasc() + "<br>");
			out.println("</body></html>");
		}
		else if ("alterar".equals(acao)){
			int id = Integer.parseInt(cId);
			cliente = new Cliente(id, cNome, cFone, cEndereco, cIdade);
			cliente.atualizar();
			cliente.carregar();
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
			out.println("id: " + cliente.getId() + "<br>");
			out.println("Nome: " + cliente.getNome() + "<br>");
			out.println("Fone: " + cliente.getTelefone() + "<br>");
			out.println("Endereço: " + cliente.getEndereco() + "<br>");
			out.println("Idade: " + cliente.getNasc() + "<br>");
			out.println("</body></html>");
		}
		else if ("deletar".equals(acao)){
			int id = Integer.parseInt(cId);
			cliente = new Cliente(id);
			cliente.excluir();
			
			
		}
		else if ("listar".equals(acao)){
			ArrayList<ClienteTO> clientes = cli.listar();
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
			for(int i = 0; i < clientes.size(); i++){
				out.println( "id: "+clientes.get(i).getId()+"<br>");
				out.println( "nome: "+clientes.get(i).getNome()+"<br>");
				out.println( "fone: "+clientes.get(i).getTelefone()+"<br>");
				out.println( "endereco: "+clientes.get(i).getEndereco()+"<br>");
				out.println( "idade: "+clientes.get(i).getNasc()+"<br><br>");
			}
			out.println("</body></html>");
		}	
	}

}
