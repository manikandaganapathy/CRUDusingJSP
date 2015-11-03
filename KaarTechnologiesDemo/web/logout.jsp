<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
session.setAttribute("currentSessionUser", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>