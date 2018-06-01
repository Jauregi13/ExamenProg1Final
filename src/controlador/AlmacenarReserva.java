package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class AlmacenarReserva
 */
@WebServlet("/AlmacenarReserva")
public class AlmacenarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		/**
		 * Recibimos la variable de sesion de la reserva
		 */
		
		Reserva reserva = (Reserva)session.getAttribute("reserva");
		
		ReservaModelo reservaModelo = new ReservaModelo();
		
		/**
		 * utilizando el modelo de reserva utilizamos el metodo GuardarReserva para guardar la reserva en la base de datos
		 */
		
		reservaModelo.GuardarReserva(reserva);
		
		/**
		 * Destruimos la variable de sesion de reserva
		 */
		
		session.removeAttribute("reserva");
		
		/**
		 * Nos redirigimos a la pagina de confirmacion de reserva
		 */
		
		RequestDispatcher rd = request.getRequestDispatcher("confirmacion.jsp");
		
		rd.forward(request, response);
	}

	

}
