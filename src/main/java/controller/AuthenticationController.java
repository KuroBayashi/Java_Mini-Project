package controller;

import entity.Customer;
import exception.AccessDeniedException;
import exception.RepositoryException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.CustomerRepository;
import repository.QueryParameter;
import repository.RepositoryFactory;
import service.FlashBag;


@WebServlet(name = "AuthenticationController", urlPatterns = {"/"})
public class AuthenticationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        
        // Flash messages
        FlashBag flashBag = new FlashBag();
        session.setAttribute("flashBag", flashBag);
        
        // Customer
        Customer customer = (Customer)session.getAttribute("customer");
        if (null == customer)
            customer = new Customer();
        
        // Action
        String action = request.getParameter("_action");

        try {
            if (null != action) {
                // Login
                if ("login".equals(action)) {
                    // Admin
                    if (
                        AdminController.USERNAME.equals(request.getParameter("username")) && 
                        AdminController.PASSWORD.equals(request.getParameter("password"))
                    ) {
                        session.setAttribute("isAdmin", true);
                        flashBag.add("success", "You are now successfully connected as Admin.");

                        response.sendRedirect(request.getContextPath() + "/admin");
                        return;
                    }

                    // Customer
                    CustomerRepository userRepository = RepositoryFactory.getCustomerRepository();

                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    if (
                        null == username || username.isEmpty() ||
                        null == password || password.isEmpty()
                    ) {
                        flashBag.add("danger", "Username and password are required.");
                    }
                    else {
                        try {
                            customer = userRepository.findOneWith(Arrays.asList(
                                new QueryParameter("email", username),
                                new QueryParameter("customer_id", Integer.parseInt(password))
                            ));

                            if (null == customer)
                                flashBag.add("danger", "Invalid username or password.");
                            else {
                                session.setAttribute("customer", customer);
                                flashBag.add("success", "You are now successfully connected.");

                                response.sendRedirect(request.getContextPath() + "/customer");
                                return;
                            }
                        } catch (NumberFormatException e) {
                            flashBag.add("danger", "Password must be an Integer.");
                        } catch (RepositoryException e) {
                            flashBag.add("danger", e.getMessage());
                        }
                    }
                }
                else if ("logout".equals(action)) {
                
                    session.invalidate();

                    response.sendRedirect(request.getContextPath());
                    return;
                }
            }
            
            // Default Home
            request.getRequestDispatcher("template/auth/login.jsp").forward(request, response);
            
        } catch (SQLException e) {
            int errorCode = 0;
            
            session.setAttribute("error", new Pair<>(errorCode, e.getMessage()));
            request.getRequestDispatcher("template/error.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
