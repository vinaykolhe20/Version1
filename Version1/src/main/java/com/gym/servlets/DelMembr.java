package com.gym.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;
import com.gym.entities.Member;
/**
 * Servlet implementation class DelMembr
 */
public class DelMembr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelMembr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String memnm;
		try
		{
			memnm=request.getParameter("memnm");
			
			Configuration cfg= new Configuration().configure();
			SessionFactory sf=cfg.addAnnotatedClass(Member.class).buildSessionFactory();
			Session ses=sf.getCurrentSession();
			ses.beginTransaction();
			
			Query<Member> q=ses.createQuery("delete from Member where memnm= :memnm");
			
			q.setParameter("memnm", memnm);
			
			int cnt=q.executeUpdate();
	        ses.getTransaction().commit();
	        
	        System.out.println("Member removed : "+cnt);
	        if(cnt>0)
	        {
	        	response.sendRedirect("index.html");
	        }
	        else
	        {
	        	response.sendRedirect("DeleteMem.html");
	        }
	        ses.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
