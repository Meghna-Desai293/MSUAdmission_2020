

import static cerberus.AttFunctions.getAccess;
import static cerberus.printer.nouser;
import static cerberus.printer.tableend;
import static cerberus.printer.tablehead;
import static cerberus.printer.tablestart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class profile extends HttpServlet {

    String subs[][];
    String prefSub[];
    private static final long serialVersionUID = -2007307218613281629L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int access = getAccess(request);
            switch (access) {
                case 1:
                    out.print("<div class='row' align='center'><div class='col-xl-4 col-sm-6 mb-3' align='center'><br><br>");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.14:3306/cerberus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "cerberus", "abc@123");
                        PreparedStatement ps = con.prepareStatement("SELECT name, photo FROM faculty WHERE facultyID = ?");
                        HttpSession session = request.getSession(false);
                        String facultyID = session.getAttribute("user").toString();
                        ps.setString(1, facultyID);
                        byte[] blob = null;
                        String name = "";
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            blob = rs.getBytes("photo");
                            name = rs.getString("name");
                        }
                        if (blob != null) {
                            String imgString = DatatypeConverter.printBase64Binary(blob);
                            out.print("<img style='border-radius: 10%;height:130px; width:130px;' src='data:image/png;base64," + imgString + "'/><br><br><font size=4>" + name + "</font>");
                        } else {
                            out.print("<img style='width:150px;height:150px;'src='images/student.png'/><br><br><font size=4>" + name + "</font>");
                        }
                        con.close();
                    } catch (ClassNotFoundException | SQLException e) {
                    }
                    out.print("</div></div>To change password, Click 'Create a new Password' in Login Page.");
                    break;
                case 0:
                    out.print("<div class='row' align='center'><div class='col-xl-4 col-sm-6 mb-3' align='center'><br><br>");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.14:3306/cerberus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "cerberus", "abc@123");
                        PreparedStatement ps = con.prepareStatement("SELECT studentphoto.photo FROM studentphoto WHERE studentphoto.prn = ?");
                        HttpSession session = request.getSession(false);
                        String prn = session.getAttribute("user").toString();
                        ps.setString(1, prn);
                        byte[] blob = null;
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            blob = rs.getBytes("photo");
                        }
                        ps = con.prepareStatement("SELECT student.name FROM student WHERE prn = ?");
                        ps.setString(1, prn);
                        String name = "";
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            name = rs.getString("name");
                        }
                        if (blob != null) {
                            String imgString = DatatypeConverter.printBase64Binary(blob);
                            out.print("<img style='border-radius: 10%;width:80px;height:110px;' src='data:image/png;base64," + imgString + "'/><br><br><font size=4>" + name + "</font>");
                        } else {
                            out.print("<img style='width:150px;height:150px;' src='images/student.png'/ alt='We couldn't find your Photo'><br><br><font size=4>" + name + "</font>");
                        }
                       
                    } catch (ClassNotFoundException | SQLException e) {
                    }
                    break;
                default:
                    out.print(nouser());
            }
        }
    }

    public boolean isfav(String subject) {
        for (String sub : prefSub) {
            int index = subject.indexOf(sub);
            if (index != -1) {
                return true;
            }
        }
        return false;
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

}
