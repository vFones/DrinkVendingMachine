package com.prog3.servlet.admin;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.prog3.util.Float2.round;
import static java.lang.Float.parseFloat;

/**
 * Price servlet used for control price modified
 */
@WebServlet(displayName="price_change" , urlPatterns="/admin/price_change")
public class PriceChanger extends HttpServlet {
  private void changePrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String newPrice = req.getParameter("priceValue");
    //get new value
    GenericDao<Product> productDao = new GenericDao<Product>();
    Product product = null;

    // try to get product querying Bean
    try{ product = productDao.queryBean("from Product where id=" + req.getParameter("drink")); }
    catch (NullPointerException e) { System.out.println(e.getMessage()); }
    finally {
      // if success then set new Price and update product
      try { product.setPrice(round(parseFloat(newPrice), 2)); }
      catch ( NumberFormatException e){ System.out.println(e.getMessage()); }
      finally { productDao.update(product);}
    }

    //return to admin panel
    RequestDispatcher rd = req.getRequestDispatcher("/admin");
    rd.forward(req, resp);
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    changePrice(req, resp);
  }
}
