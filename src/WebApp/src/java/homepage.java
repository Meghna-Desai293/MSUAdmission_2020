
import static cerberus.AttFunctions.getAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static cerberus.printer.nouser;

public class homepage extends HttpServlet {

    private static final long serialVersionUID = -6020013234525993016L;

    int week;
    int access;
    HttpServletResponse response;
    HttpServletRequest request;

    protected void processRequest(HttpServletRequest reques, HttpServletResponse respons)
            throws ServletException, IOException {
        response = respons;
        request = reques;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);
            access = getAccess(request);
            switch (access) {
                case 1:

                    out.print("<div class='row'>"
                            + "<div onclick=\"javascript:setContent('/Admission/uploadExcel');\" "
                            + "     class='col-xl-6 col-sm-6 mb-3' align='center'>"
                            + "     <div class='card text-white bg-success o-hidden h-100'>"
                            + "         <div class='card-header text-white clearfix'>"
                            + "             <span class='float-middle'>Lab </span>"
                            + "         </div>"
                            + "         <div class='card-body'>"
                            + "             <div class='card-body-icon'>"
                            + "                 <i class=\"fas fa-table\"></i>"
                            + "             </div>"
                            + "             <div class='mr-2' align='center'>"
                            + "                 <br>Upload From Excel File<br>"
                            + "             </div>"
                            + "         </div>"
                            + "         <br>"
                            + "         <div class='card-footer text-white clearfix small z-1'>"
                            + "             <span class='float-left'>Upload From Excel File</span>"
                            + "             <span class='float-right'>"
                            + "                 <i class='fas fa-angle-right'></i>"
                            + "             </span>"
                            + "         </div>"
                            + "     </div>"
                            + "</div>");

                    out.print("<div onclick=\"javascript:setContent('/Admission/genMerit');\" "
                            + "     class='col-xl-6 col-sm-6 mb-3' align='center'>"
                            + "     <div class='card text-white bg-primary o-hidden h-100'>"
                            + "         <div class='card-header text-white clearfix'>"
                            + "             <span class='float-middle'>Lab </span>"
                            + "         </div>"
                            + "         <div class='card-body'>"
                            + "             <div class='card-body-icon'>"
                            + "                 <i class=\"fas fa-list-alt\"></i>"
                            + "             </div>"
                            + "             <div class='mr-2' align='center'>"
                            + "                 <br>Generate Merit List<br>"
                            + "             </div>"
                            + "         </div>"
                            + "         <br>"
                            + "         <div class='card-footer text-white clearfix small z-1'>"
                            + "             <span class='float-left'>Generate Merit List</span>"
                            + "             <span class='float-right'>"
                            + "                 <i class='fas fa-angle-right'></i>"
                            + "             </span>"
                            + "         </div>"
                            + "     </div>"
                            + "</div>");

                    out.print("<div onclick=\"javascript:setContent('/Admission/sendEmail');\" "
                            + "     class='col-xl-6 col-sm-6 mb-3' align='center'>"
                            + "     <div class='card text-white bg-warning o-hidden h-100'>"
                            + "         <div class='card-header text-white clearfix'>"
                            + "             <span class='float-middle'>Lab </span>"
                            + "         </div>"
                            + "         <div class='card-body'>"
                            + "             <div class='card-body-icon'>"
                            + "                 <i class=\"fas fa-envelope\"></i>"
                            + "             </div>"
                            + "             <div class='mr-2' align='center'>"
                            + "                 <br>Send Email/SMS<br>"
                            + "             </div>"
                            + "         </div>"
                            + "         <br>"
                            + "         <div class='card-footer text-white clearfix small z-1'>"
                            + "             <span class='float-left'>Send Email/SMS</span>"
                            + "             <span class='float-right'>"
                            + "                 <i class='fas fa-angle-right'></i>"
                            + "             </span>"
                            + "         </div>"
                            + "     </div>"
                            + "</div>");
                    out.print("<div onclick=\"javascript:setContent('/Admission/admissionRules');\" "
                            + "     class='col-xl-6 col-sm-6 mb-3' align='center'>"
                            + "     <div class='card text-white bg-danger o-hidden h-100'>"
                            + "         <div class='card-header text-white clearfix'>"
                            + "             <span class='float-middle'>Lab </span>"
                            + "         </div>"
                            + "         <div class='card-body'>"
                            + "             <div class='card-body-icon'>"
                            + "                 <i class=\"fas fa-user-cog\"></i>"
                            + "             </div>"
                            + "             <div class='mr-2' align='center'>"
                            + "                 <br>Admission Rules<br>"
                            + "             </div>"
                            + "         </div>"
                            + "         <br>"
                            + "         <div class='card-footer text-white clearfix small z-1'>"
                            + "             <span class='float-left'>Admission Rules</span>"
                            + "             <span class='float-right'>"
                            + "                 <i class='fas fa-angle-right'></i>"
                            + "             </span>"
                            + "         </div>"
                            + "     </div>"
                            + "</div>");
                    out.print("</div>");
                    break;
                case 0:
                    out.print("student page");
                    break;
                default:
                    nouser();
            }
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

}
