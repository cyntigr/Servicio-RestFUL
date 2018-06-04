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
import com.almacen.dao.AlmacenMe;
import com.clase.almacen.model.*;


/**
 * Servlet implementation class AlmacenServlet
 */
@WebServlet(name = "AlmacenServlet", urlPatterns = { "/almacen" })
public class AlmacenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AlmacenMe almacenMe = new AlmacenMe();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlmacenServlet() {
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
				nuevoAlmacen(request, response);
				break;
			}
		} else {
			List<Almacen> result = AlmacenMe.obtenerAlmacenes();
			mostrarListaAlmacenes(request, response, result);
		}
	}

	private void buscarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idAlmacen = Integer.valueOf(req.getParameter("idAlmacen"));
		Almacen almacen = null;
		try {
			almacen = AlmacenMe.obtenerAlmacen(idAlmacen);
		} catch (Exception ex) {
			Logger.getLogger(AlmacenServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
		req.setAttribute("almacen", almacen);
		req.setAttribute("action", "actualizar");
		String paginaJSP = "/vista/nuevo-almacen.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(req, resp);
	}
	
	private void nuevoAlmacen(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("action", "");
		String paginaJSP = "/vista/nuevo-almacen.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(req, resp);
	}

	private void buscarPorNombre(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nombreAlmacen = req.getParameter("nombreAlmacen");
		List<Almacen> result = AlmacenMe.buscarPorNombre(nombreAlmacen);
		mostrarListaAlmacenes(req, resp, result);
	}

	private void mostrarListaAlmacenes(HttpServletRequest req, HttpServletResponse resp, List listaAlmacenes)
			throws ServletException, IOException {
		String paginaJsp = "/vista/lista-almacenes.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
		req.setAttribute("listaAlmacenes", listaAlmacenes);
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
	                guardarAlmacen(req, resp);
	                break;
	            case "actualizar":
	                actualizarAlmacen(req, resp);
	                break;            
	            case "eliminar":
	                eliminarAlmacen(req, resp);
	                break;            
	        }

	    }
	 
	 private void guardarAlmacen(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        Almacen almacen = new Almacen(Integer.valueOf(req.getParameter("idAlmacen")),req.getParameter("nombreAlmacen"));
	        AlmacenMe.guardarAlmacen(almacen);
	        List<Almacen> listaAlmacenes = AlmacenMe.obtenerAlmacenes();
	        String message = "Resgistro creado satisfactoriamente.";
	        req.setAttribute("message", message);
	        mostrarListaAlmacenes(req, resp, listaAlmacenes);
	    }

	    private void actualizarAlmacen(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	    	int idAlmacen = Integer.valueOf(req.getParameter("idAlmacen"));
	        Almacen almacen = new Almacen(idAlmacen,req.getParameter("nombreAlmacen"));
	        boolean success = AlmacenMe.actualizarAlmacen(almacen);
	        String message = null;
	        if (success) {
	        	message = "Registro actualizado satisfactoriamente.";
	        }
	        List<Almacen> listaAlmacenes = AlmacenMe.obtenerAlmacenes();
	        req.setAttribute("idAlmacen", idAlmacen);
	        req.setAttribute("message", message);
	        mostrarListaAlmacenes(req, resp, listaAlmacenes);
	    }  

	    private void eliminarAlmacen(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        int idAlmacen = Integer.valueOf(req.getParameter("idAlmacen"));
	        boolean confirmar = AlmacenMe.eliminarAlmacen(idAlmacen);
	        if (confirmar){
	            String message = "Registro eliminado satisfactoriamente.";
	            req.setAttribute("message", message);
	        }
	        List<Almacen> listaAlmacenes = AlmacenMe.obtenerAlmacenes();
	        mostrarListaAlmacenes(req, resp, listaAlmacenes);
	    }

}
