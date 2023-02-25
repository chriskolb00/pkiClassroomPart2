

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }
    protected void printOutCSV(HttpServletRequest request, HttpServletResponse response, String Path) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	out.println("<table>");
    	String line = "";
    	try { 
    		out.println("<br> <br>");
			BufferedReader br = new BufferedReader(new FileReader(Path));
			while ((line = br.readLine())!= null) {
				String[] values = line.split(",");
					if(values.length>4) {
						out.println( "<tr> <td>"  + values[8]+ "</td> <td>" + values[10] +"</td>");
						out.print("<td>"+ values[13] + "</td> <td>"+ values[15] +"</td>");
						out.print("<td>"+ values[28] + "</td> <td>"+ values[29] +"</td>  <td>"+values[30]+"</td></tr> ");
					}
			}	
			br.close();
			}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		out.println("</table>");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>PKI Classroom Assignment</title></head> <body>");
		
		String Path = "C:\\Users\\cmlko\\Downloads\\Spring-2019-Files\\2019 files\\CSCI1191.csv";
		String Path2 = "C:\\Users\\cmlko\\Downloads\\Spring-2019-Files\\2019 files\\BMI1191.csv";
		String Path3 = "C:\\Users\\cmlko\\Downloads\\Spring-2019-Files\\2019 files\\CIST_EMIT1191.csv";
		String Path4 = "C:\\Users\\cmlko\\Downloads\\Spring-2019-Files\\2019 files\\CYBR1191.csv";
		String Path5 = "C:\\Users\\cmlko\\Downloads\\Spring-2019-Files\\2019 files\\ISQA1191.csv";
		String Path6 = "C:\\Users\\cmlko\\Downloads\\Spring-2019-Files\\2019 files\\ITIN1191.csv";
		
		out.println("<style>");
		out.println("button { width: 300px; height: 60px; margin: 1px;}");
		out.println("table, th, td { border: 1px solid black; border-collapse:collapse;}");
		out.println("td { padding:15px; text-align:left;}");
		out.println("</style>");
		out.println("<h1> Welcome to the PKI building's Courses!</h1>");
		//each printOutCSV call will print out a path listed above
		printOutCSV(request, response, Path);
		printOutCSV(request, response, Path2);
		printOutCSV(request, response, Path3);
		printOutCSV(request, response, Path4);
		printOutCSV(request, response, Path5);
		printOutCSV(request, response, Path6);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}