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
import com.almacen.dao.StockMe;
import com.clase.almacen.model.*;


/**
 * Servlet implementation class StockServlet
 */
@WebServlet(name = "StockServlet", urlPatterns = { "/stock" })
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StockMe stockMe = new StockMe();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StockServlet() {
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
				nuevoStock(request, response);
				break;
			case "eliminar":
                eliminarStock(request, response);
                break;
			}
		} else {
			List<Stock> result = StockMe.obtenerStocks();
			mostrarListaStocks(request, response, result);
		}
	}
	private void buscarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codArticulo = Integer.valueOf(req.getParameter("codArticulo"));
		int idAlmacen = Integer.valueOf(req.getParameter("idAlmacen"));
		Stock stock = null;
		try {
			stock = StockMe.obtenerStock(idAlmacen,codArticulo);
		} catch (Exception ex) {
			Logger.getLogger(StockServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
		req.setAttribute("stock", stock);
		req.setAttribute("action", "actualizar");
		String paginaJSP = "/vista/nuevo-stock.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(req, resp);
	}
	
	private void nuevoStock(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("action", "");
		String paginaJSP = "/vista/nuevo-stock.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(req, resp);
	}

	private void buscarPorNombre(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idAlmacen = Integer.valueOf(req.getParameter("idAlmacen"));
		List<Stock> result = StockMe.buscarPorNombre(idAlmacen);
		mostrarListaStocks(req, resp, result);
	}
	private void eliminarStock(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idAlmacen = Integer.valueOf(req.getParameter("idAlmacen"));
        int codArticulo = Integer.valueOf(req.getParameter("codArticulo"));
        boolean confirmar = StockMe.eliminarStock(idAlmacen,codArticulo);
        if (confirmar){
            String message = "Registro eliminado satisfactoriamente.";
            req.setAttribute("message", message);
        } else {
        	String message = "No se ha podido eliminar, vuelve a intentarlo.";
            req.setAttribute("message", message);
        }
        List<Stock> listaStocks = StockMe.obtenerStocks();
        mostrarListaStocks(req, resp, listaStocks);
    }

	private void mostrarListaStocks(HttpServletRequest req, HttpServletResponse resp, List listaStocks)
			throws ServletException, IOException {
		String paginaJsp = "/vista/lista-stocks.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
		req.setAttribute("listaStocks", listaStocks);
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
	                guardarStock(req, resp);
	                break;
	            case "actualizar":
	                actualizarStock(req, resp);
	                break;            
	                        
	        }
	    }
	   	 
	 private void guardarStock(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
		 int cod = Integer.valueOf(req.getParameter("codArticulo"));
		 int id = Integer.valueOf(req.getParameter("idAlmacen"));
		 int stk = Integer.valueOf(req.getParameter("stock"));
		 	Stock stock = new Stock(id,cod,stk);
		 	String message = "Resgistro creado satisfactoriamente.";
		 	
		 	if (StockMe.existeId(id)) {
				
			} else {
				message = "Lo siento, el almacen no existe.";
				req.setAttribute("message", message);
			}
		 	if (StockMe.existeCod(cod)) {
				StockMe.guardarStock(stock);
				req.setAttribute("message", message);
			} else {
				message = "Lo siento, el artículo no existe.";
				req.setAttribute("message", message);
				
			}

	        List<Stock> listaStocks = StockMe.obtenerStocks();

	        mostrarListaStocks(req, resp, listaStocks);
	    }

	    private void actualizarStock(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	    	
	    	Stock stock = new Stock(Integer.valueOf(req.getParameter("idAlmacen")),Integer.valueOf(req.getParameter("codArticulo")),
	    			Integer.valueOf(req.getParameter("stock")));
	        boolean success = StockMe.actualizarStock(stock);
	        String message = null;
	        if (success) {
	        	message = "Registro actualizado satisfactoriamente.";
	        }else {
	        	message = "El registro no se ha podido actualizar, intentelo de nuevo.";
	        }
	        List<Stock> listaStocks = StockMe.obtenerStocks();
	        req.setAttribute("message", message);
	        mostrarListaStocks(req, resp, listaStocks);
	    }  

	    

}
