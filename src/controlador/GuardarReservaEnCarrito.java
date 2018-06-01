package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Parcela;
import modelo.ParcelaModelo;
import modelo.Reserva;

/**
 * Servlet implementation class GuardarReservaEnCarrito
 */
@WebServlet("/GuardarReservaEnCarrito")
public class GuardarReservaEnCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarReservaEnCarrito() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Recoge todos los parametros del formulario de la reserva
		 */
		int id_parcela = Integer.parseInt(request.getParameter("id_parcela"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		int num_personas = Integer.parseInt(request.getParameter("numero_personas"));
		String fecha_ini = request.getParameter("fecha_inicio");
		String fecha_f = request.getParameter("fecha_fin");
		String luz = request.getParameter("luz");
		
		/**
		 * Convertimos la fecha_inicio y fecha_fin del formulario que son string a tipo Date
		 */
		
		SimpleDateFormat format_fecha = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha_inicio = null;
		Date fecha_fin = null;
		try {
			fecha_inicio = format_fecha.parse(fecha_ini);
			fecha_fin = format_fecha.parse(fecha_f);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		/**
		 * Conseguimos los datos de la parcela seleccionada con el parametro de id_parcela que conseguimos del formulario
		 */
		ParcelaModelo parcelaModelo = new ParcelaModelo();
		
		Parcela parcela = parcelaModelo.selectPorId(id_parcela);
		
		/**
		 * Creamos la reserva y añadimos los datos del formulario a la reserva
		 */
		Reserva reserva = new Reserva();
		
		reserva.setNombre_usuario(nombre);
		reserva.setApellido_usuario(apellido);
		reserva.setDni_usuario(dni);
		reserva.setNumero_usuarios(num_personas);
		reserva.setInicio_reserva(fecha_inicio);
		reserva.setFin_reserva(fecha_fin);
		reserva.setParcela(parcela);
		
		/**
		 * Comprobamos el dato de luz es null o no
		 * Si no es null, meteremos como true en la reserva, y sino como false
		 */
		
		if(luz == null){
			reserva.setLuz(false);
		}
		else {
			reserva.setLuz(true);
		}
		
		/**
		 * Creamos la variable de sesion
		 */
		
		HttpSession sesion = request.getSession();
		
		sesion.setAttribute("reserva", reserva);
		
		/**
		 * Nos redirigimos a la pagina infoReserva
		 */
		
		RequestDispatcher rd = request.getRequestDispatcher("infoReserva.jsp");
		
		rd.forward(request, response);

	}

}
