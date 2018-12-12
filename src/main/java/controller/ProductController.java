package controller;

import entity.Customer;
import entity.Product;
import exception.AbstractException;
import exception.AccessDeniedException;
import exception.RepositoryException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.DataSourceFactory;
import repository.ProductRepository;
import repository.QueryParameter;
import service.FlashBag;
import service.ServiceContainer;


@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        // Service container
        ServiceContainer serviceContainer = (ServiceContainer)session.getAttribute("serviceContainer");
        
        // FlashBag
        FlashBag flashBag = serviceContainer.getFlashBag();
        
        // Customer
        Customer customer = (Customer)session.getAttribute("customer");
        
        // Admin
        Boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
        
        // Action
        String action = request.getParameter("_action");
        
        try {
            if ((null == customer || -1 == customer.getId()) && true != isAdmin)
                throw new AccessDeniedException("PurchaseOrderController: You must be logged to access to this page.");
            
            ProductRepository productRepository = new ProductRepository(DataSourceFactory.getDataSource());

            if (null != action) {
                // Create
                if ("create".equals(action)) {
                    // Create product
                }
                
                // Edit
                else if ("edit".equals(action)) {
                    if (null != request.getParameter("submit")) {
                        // Traitement du formulaire
                        // Redirection vers la page du produit
                    }
                    
                    // Affichage du formulaire
                }
                
                // Edit
                else if ("delete".equals(action)) {
                    // Delete
                }
            }
            
            // Default Home
            session.setAttribute("products", productRepository.findAll());
            
            request.getRequestDispatcher("/WEB-INF/template/product/home.jsp").forward(request, response);
            
        } catch (SQLException|AbstractException e) {  
            session.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/template/error.jsp").forward(request, response);
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
