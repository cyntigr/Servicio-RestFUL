package com.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.almacen.dao.ArticuloMe;
import com.clase.almacen.model.Articulo;

	/**
	 * Servlet implementation class ArticuloServlet
	 */
	@WebServlet(name = "ArticuloServlet", urlPatterns = { "/articulo" })
	public class ArticuloServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		ArticuloMe articuloMe = new ArticuloMe();

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public ArticuloServlet() {
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
			

			String action = request.getParameter("buscarAction");
			System.out.println(action);
			if (action != null) {
				switch (action) {
				case "buscarPorId":
					buscarPorId(request, response);
					break;
				case "buscarPorNombre":
					buscarPorNombre(request, response);
					break;
				case "nuevo":
					nuevoArticulo(request, response);
					break;
				}
			} else {
				List<Articulo> result = ArticuloMe.obtenerArticulos();
				mostrarListaArticulos(request, response, result);
			}
		}

		private void buscarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int codArticulo = Integer.valueOf(req.getParameter("codArticulo"));
			Articulo articulo = null;
			try {
				articulo = ArticuloMe.obtenerArticulo(codArticulo);
			} catch (Exception ex) {
				Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
			req.setAttribute("articulo", articulo);
			req.setAttribute("action", "actualizar");
			String paginaJSP = "/vista/nuevo-articulo.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
			dispatcher.forward(req, resp);
		}
		
		private void nuevoArticulo(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			req.setAttribute("action", "");
			String paginaJSP = "/vista/nuevo-articulo.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
			dispatcher.forward(req, resp);
		}

		private void buscarPorNombre(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String nombreArticulo = req.getParameter("nombreArticulo");
			List<Articulo> result = ArticuloMe.buscarPorNombre(nombreArticulo);
			mostrarListaArticulos(req, resp, result);
		}

		private void mostrarListaArticulos(HttpServletRequest req, HttpServletResponse resp, List listaArticulos)
				throws ServletException, IOException {
			String paginaJsp = "/vista/lista-articulos.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
			req.setAttribute("listaArticulos", listaArticulos);
			dispatcher.forward(req, resp);
		}
		
		 @Override
		    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		            throws ServletException, IOException {
		        String action = req.getParameter("action");
		        System.out.println("Do Post");
		        System.out.println(action);
		        switch (action) {
		            case "guardar":
		                guardarArticulo(req, resp);
		                break;
		            case "actualizar":
		                actualizarArticulo(req, resp);
		                break;            
		            case "eliminar":
		                eliminarArticulo(req, resp);
		                break;            
		        }

		    }
		 
		 private void guardarArticulo(HttpServletRequest req, HttpServletResponse resp)
		            throws ServletException, IOException {
			 Articulo articulo = new Articulo(Integer.valueOf(req.getParameter("codArticulo"))
					 ,req.getParameter("nombreArticulo"),Double.valueOf(req.getParameter("pCoste")),Double.valueOf(req.getParameter("pVenta")));
			 ArticuloMe.guardarArticulo(articulo);
		        List<Articulo> listaArticulos = ArticuloMe.obtenerArticulos();
		        String message = "Resgistro creado satisfactoriamente.";
		        req.setAttribute("message", message);
		        mostrarListaArticulos(req, resp, listaArticulos);
		    }

		    private void actualizarArticulo(HttpServletRequest req, HttpServletResponse resp)
		            throws ServletException, IOException {
		    	int codArticulo = Integer.valueOf(req.getParameter("codArticulo"));
		    	Articulo articulo = new Articulo(codArticulo,req.getParameter("nombreArticulo")
		    			,Double.valueOf(req.getParameter("pCoste")),Double.valueOf(req.getParameter("pVenta")));
		        boolean success = ArticuloMe.actualizarArticulo(articulo);
		        String message = null;
		        if (success) {
		        	message = "Registro actualizado satisfactoriamente.";
		        }
		        List<Articulo> listaArticulos = ArticuloMe.obtenerArticulos();
		        req.setAttribute("codArticulo", codArticulo);
		        req.setAttribute("message", message);
		        mostrarListaArticulos(req, resp, listaArticulos);
		    }  

		    private void eliminarArticulo(HttpServletRequest req, HttpServletResponse resp)
		            throws ServletException, IOException {
		        int codArticulo = Integer.valueOf(req.getParameter("codArticulo"));
		        boolean confirmar = ArticuloMe.eliminarArticulo(codArticulo);
		        if (confirmar){
		            String message = "Registro eliminado satisfactoriamente.";
		            req.setAttribute("message", message);
		        }
		        List<Articulo> listaArticulos = ArticuloMe.obtenerArticulos();
		        mostrarListaArticulos(req, resp, listaArticulos);
		    }
	}