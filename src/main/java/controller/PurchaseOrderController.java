package controller;

import entity.Customer;
import entity.PurchaseOrder;
import exception.AbstractException;
import exception.AccessDeniedException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.PurchaseOrderRepository;
import repository.QueryParameter;
import exception.RepositoryException;
import java.sql.Date;
import repository.RepositoryFactory;
import service.FlashBag;


@WebServlet(name = "PurchaseOrderController", urlPatterns = {"/PurchaseOrderController"})
public class PurchaseOrderController extends HttpServlet {

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
        
        // Action
        String action = request.getParameter("_action");
        
        try {
            if (null == customer || -1 == customer.getId())
                throw new AccessDeniedException("PurchaseOrderController: You must be logged to access to this page.");
            
            PurchaseOrderRepository purchaseOrderRepository = RepositoryFactory.getPurchaseOrderRepository();

            // Home
            if (null == action) {
                
                List<PurchaseOrder> purchaseOrders = null;
                
                try {
                    purchaseOrders = purchaseOrderRepository.findAllWith(Arrays.asList(
                        new QueryParameter("customer_id", customer.getId())
                    ));
                } catch (RepositoryException e) {
                    flashBag.add("danger", e.getMessage());
                }
                
                session.setAttribute("purchaseOrders", purchaseOrders);
                
                request.getRequestDispatcher("template/purchaseorder/home.jsp").forward(request, response);
            } 
            
            // Edit
            else if ("edit".equals(action)) { 
                
                String shippingDate = request.getParameter("shipping_date");
                String quantity     = request.getParameter("quantity");
                
                // TODO : Check shipping date > tomorrow
                if (null == shippingDate || !shippingDate.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
                    flashBag.add("danger", "Invalid shipping date (yyyy-mm-dd)");
                else if (null == quantity || !quantity.matches("^[1-9]+[0-9]*$"))
                    flashBag.add("danger", "Quantity must be greater than 0.");
                else {
                    try {
                        PurchaseOrder purchaseOrder = purchaseOrderRepository.findOneWith(Arrays.asList(
                            new QueryParameter("customer_id", customer.getId()),
                            new QueryParameter("order_num", Integer.parseInt(request.getParameter("order_num")))
                        ));

                        if (null == purchaseOrder)
                            flashBag.add("danger", "Unknown purchase order, can't edit it.");
                        else {
                            purchaseOrder
                                .setQuantity(Integer.parseInt(quantity))
                                .setShippingDate(Date.valueOf(shippingDate))
                                .setFreightCompany(request.getParameter("freight_company"))
                            ;

                            purchaseOrderRepository.save(purchaseOrder);

                            flashBag.add("success", "You purchase order has been successfully updated.");
                        }
                    } catch (NumberFormatException e) {
                        flashBag.add("danger", "Your purchase order num must be an integer.");
                        flashBag.add("danger", "Your purchase order quantity must be an integer.");
                    } catch (RepositoryException e) {
                        flashBag.add("danger", e.getMessage());
                    }
                }
                
                response.sendRedirect(request.getContextPath());
                return;
            }
            
            // Delete 
            else if ("delete".equals(action)) {
                try {
                    PurchaseOrder purchaseOrder = purchaseOrderRepository.findOneWith(Arrays.asList(
                        new QueryParameter("customer_id", customer.getId()),
                        new QueryParameter("order_num", Integer.parseInt(request.getParameter("order_num")))
                    ));
                    
                    if (null == purchaseOrder)
                        flashBag.add("danger", "Unknown purchase order, can't delete it.");
                    else {
                        purchaseOrderRepository.delete(purchaseOrder);

                        flashBag.add("success", "Your purchase order has been successfully deleted.");
                    }
                } catch (NumberFormatException e) {
                    flashBag.add("danger", "Your purchase order num must be an integer.");
                } catch (RepositoryException e) {
                    flashBag.add("danger", e.getMessage());
                }
                
                response.sendRedirect(request.getContextPath());
                return;
            }
        } catch (SQLException|AbstractException e) {
            Integer code = 0;
            
            if (e instanceof AbstractException)
                code = 1; // TODO : e.getCode();
            
            session.setAttribute("error", new Pair<>(code, e.getMessage()));
            
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
