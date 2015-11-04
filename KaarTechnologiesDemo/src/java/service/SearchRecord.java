package service;

import dao.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchRecord extends HttpServlet {

    Connection conn;
    ResultSet res;
    Statement stmt;
    DBConnection dbconn;

    String query, num;
    ArrayList aList;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            num = (String) request.getParameter("num");
            dbconn = new DBConnection();
            conn = dbconn.setConnection();
            stmt = conn.createStatement();

            query = "select * from manu where num=" + num + "";
            res = dbconn.getResult(query, conn);
            request.setAttribute("searchData", res);
            RequestDispatcher rd = request.getRequestDispatcher("searchresult.jsp");
            rd.forward(request, response);

        } catch (IOException | SQLException | ServletException e) {
            String errText = "Search key not found in the DB";
            request.setAttribute("Error", errText);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
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
