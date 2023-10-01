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


import com.gym.entities.Member;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;
/**
 * Servlet implementation class SubChange
 */
public class SubChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String memnm;
		Date upto;
		try {
		memnm=request.getParameter("memnm");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		upto = dateFormat.parse(request.getParameter("upto"));
		
		Configuration cfg=new Configuration().configure();
        SessionFactory sf=cfg.addAnnotatedClass(Member.class).buildSessionFactory();
        Session ses=sf.getCurrentSession();
        ses.beginTransaction();
		
        Query<Member> q=ses.createQuery("update Member set upto= :upto where memnm= :memnm");
        q.setParameter("upto", upto);
        q.setParameter("memnm", memnm);
        
        int cnt=q.executeUpdate();
        ses.getTransaction().commit();
        
        System.out.println("Subscription Updated :"+cnt);
        
        if(cnt>0)
        {
        	response.sendRedirect("Sucess.jsp");
        }
        else
        {
        	response.sendRedirect("Fail.jsp");
        }
        ses.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
