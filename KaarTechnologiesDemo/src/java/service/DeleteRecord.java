package service;

import dao.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteRecord extends HttpServlet {

    DBConnection dbconn;
    Connection conn;
    Statement stmt;
    ResultSet res;
    String  query,name,num;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            dbconn = new DBConnection();
            conn = dbconn.setConnection();
            stmt = conn.createStatement();
            num=request.getParameter("num");
            query = "delete from manu where num="+num+"";
            int i = stmt.executeUpdate(query);
        } catch (Exception e) {
            
        } finally {
           
            RequestDispatcher rd = request.getRequestDispatcher("DisplayData");
            rd.forward(request, response);
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
