<%@ page import = "java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String Path = "C:\\Users\\cmlko\\Downloads\\Spring-2019-Files\\2019 files\\CSCI1191.csv";
	String line = "";
	try {
		BufferedReader br = new BufferedReader(new FileReader(Path));
		int row=0;
		%>
		<table>
		<% 
		while ((line = br.readLine())!= null) {
			row++;
			String[] values = line.split(",");
				if(values.length>4) {
					out.println("row\t"  +row + " :"+ values[10]);
				}
				%> <br> <%
		}	
		br.close();
		}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	%></table>
</body>
</html>