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
import model.Produto;
import to.ProdutoTO;

/**
 * Servlet implementation class ManterProdutoController
 */
@WebServlet("/ManterProduto.do")
public class ManterProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterProdutoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cCodigo = request.getParameter("codigo");
		String cMarca = request.getParameter("marca");
		String cModelo = request.getParameter("modelo");
		String cPrecoDeVenda = request.getParameter("precoDeVenda");
		String cPrecoDeCompra = request.getParameter("precoDeCompra");
		String cCor = request.getParameter("cor");
		
		String acao = request.getParameter("manterProduto");
		Produto produto;
		Produto pro = new Produto();
		
		if ("incluir".equals(acao)) {
			int codigo = Integer.parseInt(cCodigo);
			double pdv = Double.parseDouble(cPrecoDeVenda);
			double pdc = Double.parseDouble(cPrecoDeCompra);
			
			produto = new Produto(codigo, cMarca, cModelo, pdv, pdc, cCor);
			produto.criar();
			produto.carregar();

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("codigo: " + produto.getCodigo() + "<br>");
			out.println("marca: " + produto.getMarca() + "<br>");
			out.println("modelo: " + produto.getModelo() + "<br>");
			out.println("precoDeVenda: " + produto.getPrecoDeVenda() + "<br>");
			out.println("precoDeCompra: " + produto.getPrecoDeCompra() + "<br>");
			out.println("cor: " + produto.getCor() + "<br>");
			out.println("</body></html>");
		}
		else if ("alterar".equals(acao)){
			int codigo = Integer.parseInt(cCodigo);
			double pdv = Double.parseDouble(cPrecoDeVenda);
			double pdc = Double.parseDouble(cPrecoDeCompra);
			 
			produto = new Produto(codigo, cMarca, cModelo, pdv, pdc, cCor);
			produto.atualizar();
			produto.carregar();
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("codigo: " + produto.getCodigo() + "<br>");
			out.println("marca: " + produto.getMarca() + "<br>");
			out.println("modelo: " + produto.getModelo() + "<br>");
			out.println("precoDeVenda: " + produto.getPrecoDeVenda() + "<br>");
			out.println("precoDeCompra: " + produto.getPrecoDeCompra() + "<br>");
			out.println("cor: " + produto.getCor() + "<br>");
			out.println("</body></html>");
		}
		else if ("deletar".equals(acao)){
			int codigo = Integer.parseInt(cCodigo);
			produto = new Produto(codigo);
			produto.excluir();
			
			
		}
		else if ("listar".equals(acao)){
			ArrayList<ProdutoTO> produtos = pro.listar();
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			for(int i = 0; i < produtos.size(); i++){
				out.println("codigo: " + produtos.get(i).getCodigo() + "<br>");
				out.println("marca: " + produtos.get(i).getMarca() + "<br>");
				out.println("modelo: " + produtos.get(i).getModelo() + "<br>");
				out.println("precoDeVenda: " + produtos.get(i).getPrecoDeVenda() + "<br>");
				out.println("precoDeCompra: " + produtos.get(i).getPrecoDeCompra() + "<br>");
				out.println("cor: " + produtos.get(i).getCor() + "<br><br>");
			}
			out.println("</body></html>");
		}
	}

}
