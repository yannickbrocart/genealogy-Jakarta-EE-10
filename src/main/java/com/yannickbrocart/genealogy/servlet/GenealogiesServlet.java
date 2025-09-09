/**
 * 
 */
package com.yannickbrocart.genealogy.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yannickbrocart.genealogy.bean.Genealogy;
import com.yannickbrocart.genealogy.bean.enums.FactoryType;
import com.yannickbrocart.genealogy.dao.DAOFactory;
import com.yannickbrocart.genealogy.dao.GenealogyDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet({"/genealogies"})
public class GenealogiesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GenealogyDAO genealogyDAO;
	
	public void init() throws ServletException {
		this.genealogyDAO = DAOFactory.getGenealogyDAO(FactoryType.MYSQL_DAO_FACTORY);
	}
	
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Genealogy> genealogies = null;
		try {    
            genealogies = genealogyDAO.findAllGenealogies();
            System.out.println("servlet : " + genealogies.toString());
		}
        catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());
        }
//		Collections.sort(genealogies, Comparator.comparing(data::param));
		request.setAttribute("genealogies", genealogies);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/genealogies.jsp").forward(request, response);
	}

	/**
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}