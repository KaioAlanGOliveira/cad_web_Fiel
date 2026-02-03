# cad_web_Fiel

// Exemplo de servlet para listar fiéis
@WebServlet("/fieis")
public class ListaFieisServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("fieis.jsp").forward(request, response);
    }
}
