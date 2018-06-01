package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrearReserva
 */
@WebServlet("/CrearReserva")
public class CrearReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Recibimos el parametro del id de la parcela para poner en el formulario de la reserva en el input oculto como valor
		 */
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("id_parcela", id);
		
		/**
		 * Nos redirigimos al formulario de la reserva
		 */
		
		RequestDispatcher rd = request.getRequestDispatcher("formReserva.jsp");
		
		rd.forward(request, response);
	}

	

}
