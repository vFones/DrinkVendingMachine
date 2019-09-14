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

@WebServlet(displayName="price_change" , urlPatterns="/admin/price_change")
public class PriceChanger extends HttpServlet {
  protected void changePrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("email", req.getAttribute("email"));
    req.setAttribute("password", req.getAttribute("password"));

    String newPrice = req.getParameter("priceValue");

    GenericDao<Product> productDao = new GenericDao<Product>();

    Product product = null;
    try{ product = productDao.queryBean("from Product where id=" + req.getParameter("drink")); }
    catch (NullPointerException e) { System.out.println(e); }
    finally {
      try { product.setPrice(round(parseFloat(newPrice), 2).floatValue()); }
      catch ( NumberFormatException e){ System.out.println(e); }
      finally { productDao.update(product);}
    }

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
