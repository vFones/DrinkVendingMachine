package com.prog3.servlet.admin;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Purchase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(displayName = "reporter", urlPatterns = "/admin/report")
public class Reporter extends HttpServlet {
  private void getReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int month = 1, year = 1900;

    try {
      month = parseInt(req.getParameter("month"));
      year = parseInt(req.getParameter("year"));
    } catch (NumberFormatException ignored){ }

    DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    LocalDate lastDay = YearMonth.of(year,month).atEndOfMonth();

    String query = null;
    List<Purchase> purchaseList;
    try {
      query = "from Purchase where date between '"+
          format.parse(year + "/" + month + "/01") + "' and '"+
          format.parse(year +"/" + month + "/" + lastDay.getDayOfMonth())+"'";
    }
    catch (ParseException e){
      System.out.println(e);
    }
    finally {
      purchaseList = new GenericDao<Purchase>(query).getAll();
      req.setAttribute("purchaseList", purchaseList);
    }
    RequestDispatcher rd = req.getRequestDispatcher("/admin");
    rd.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      getReport(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }
}
