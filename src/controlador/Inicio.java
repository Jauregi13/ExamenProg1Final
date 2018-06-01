package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Parcela;
import modelo.ParcelaModelo;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParcelaModelo parcelaModelo = new ParcelaModelo();
		
		//conseguimos todo el listado de parcelas con el metodo de selectAll que tenemos en el modelo de parcelas
		
		ArrayList<Parcela> parcelas = parcelaModelo.selectAll();
		
		//el arraylist de parcelas añadimos como atributo para recibir en la pagina de inicio y mostrarlos en pantalla
		
		request.setAttribute("parcelas", parcelas);
		
		//nos redirigimos a la pagina de inicio.jsp para mostrar las parcelas
		
		RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
		
		rd.forward(request, response);
		
	}


}
