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

public class InsertData extends HttpServlet {
 String from,to,des,role,technology,name,query,num;
    
    Connection conn;
    ResultSet res;
    Statement stmt;
    DBConnection dbconn;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            dbconn=new DBConnection();
            num=(String)request.getParameter("num");
            from=(String)request.getParameter("from");
            to=(String)request.getParameter("to");
            des=(String)request.getParameter("des");
            role=(String)request.getParameter("role");
            technology=(String)request.getParameter("technology");
            conn =dbconn.setConnection();
            stmt=conn.createStatement();
            query="insert into manu values('"+num+"','"+from+"','"+to+"','"+des+"','"+role+"','"+technology+"')";
            int i=stmt.executeUpdate(query);
            
        }catch (Exception e){
          
            
        }finally{
            RequestDispatcher rd=request.getRequestDispatcher("/userlogged.jsp");
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
