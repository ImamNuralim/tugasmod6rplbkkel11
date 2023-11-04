package converter.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import converter.ejb.ConverterBean;

@WebServlet(name = "ConverterServlet", urlPatterns = {"/ConverterServlet"})
public class ConverterServlet extends HttpServlet {

    private ConverterBean cb = new ConverterBean();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Temperature Converter Kelompok 11</title>");
        out.println("<title>Kelompok 11</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Temperature Converter</h1>");
        try {
            String degree = request.getParameter("degree");
            if ((degree != null) && (degree.length() > 0)) {
                double d = Double.parseDouble(degree);
                if (request.getParameter("C TO F") != null) {
                    String centigrade = cb.ctof(d); 
                    out.println("<p>" + degree + " Celcius are " + centigrade + " Farenheit.</p>");
                }
                if (request.getParameter("F TO C") != null) {
                    String fahrenheit = cb.ftoc(d);
                    out.println("<p>" + degree + " Farenheit are " + fahrenheit + " Celcius.</p>");
                }
                if (request.getParameter("R TO C") != null) {
                    double reamur = Double.parseDouble(degree);
                    String celcius = cb.ctor(reamur);
                    out.println("<p>" + degree + " Reamur are " + celcius + " Celsius.</p>");
                }
            } else {
                out.println("<p>Enter degree to convert:</p>");
                out.println("<form method=\"get\">");
                out.println("<p> <input type=\"text\" name=\"degree\" size=\"25\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"F TO C\" value=\"F TO C\">"
                        + "<input type=\"submit\" name=\"C TO F\" value=\"C TO F\">"
                        );
                out.println("</form>");
            }
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
