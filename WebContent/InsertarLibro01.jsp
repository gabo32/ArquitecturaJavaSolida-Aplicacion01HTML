<%@page import="com.arquitecturajava.DataBaseHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  sentencias de import necesarias para jdbc-->
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>

<%
// recojo los datos del formulario 

	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");

	//realizar consulta
	String consultaSql = "insert into Libros (isbn,titulo,categoria) values ";
	consultaSql += "('"+isbn+"','"+titulo+"','"+categoria+"')";
	DataBaseHelper db = new DataBaseHelper();
	int filas = db.modificarRegistro(consultaSql);
	response.sendRedirect("MostrarLibros01.jsp");
%>
