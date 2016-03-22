package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManterMaterial
 */
@WebServlet("/ManterMercadoria.do")
public class ManterMercadoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterMercadoria() {
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
		String cCodigo = request.getParameter("codigo");
		String cTipoMerc = request.getParameter("tipoMerc");
		String cNome = request.getParameter("nome");
		String cQuantidade = request.getParameter("quantidade");
		String cPreco = request.getParameter("preco");
		String cTipoNegocio = request.getParameter("tipoNegocio");

		int codigo = Integer.parseInt(cCodigo);
		int qtd = Integer.parseInt(cQuantidade);
		Double preco = Double.parseDouble(cPreco);

		String acao = request.getParameter("manterMaterial");

		Mercadoria merc = new Mercadoria(codigo, cTipoMerc, cNome, qtd, preco, cTipoNegocio);

		if (acao.equals("Confirmar")) {
			merc.criar();
		} else if (acao.equals("Excluir")) {
			Mercadoria merc1 = new Mercadoria(codigo);
			merc1.excluir();
		} else if (acao.equals("Alterar")) {
			merc.atualizar();
		}

		RequestDispatcher view = request.getRequestDispatcher("menu.html");
		view.forward(request, response);
	}
}
