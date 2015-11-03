package controller;

import dao.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateLogin extends HttpServlet {

    Connection conn;
    DBConnection dbconn;
    Statement stmt;
    ResultSet rs;
    String uname, upass, query;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            uname = (String) request.getParameter("user");
            upass = request.getParameter("pass");
            query = "select * from details where name='" + uname + "' and pass='" + upass + "'";
            dbconn = new DBConnection();
            conn = dbconn.setConnection();

            rs = dbconn.getResult(query, conn);

            if (rs.next()) {
                session.setAttribute("useme", uname);
                response.sendRedirect("userlogged.jsp");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("errorlogin.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException | IOException | ServletException e) {
            RequestDispatcher rd = request.getRequestDispatcher("errorlogin.jsp");
            rd.forward(request, response);
        } finally {
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
