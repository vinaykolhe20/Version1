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
/**
 * Servlet implementation class Add
 */
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int memno,age,weight;
		String memnm,gender,city,mobno;
		Date upto;
		
		try {
		memno=Integer.parseInt(request.getParameter("memno"));
		memnm=request.getParameter("memnm");
		age=Integer.parseInt(request.getParameter("age"));
		weight=Integer.parseInt(request.getParameter("weight"));
		gender=request.getParameter("gender");
		mobno=request.getParameter("mobno");
		city=request.getParameter("city");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        upto = dateFormat.parse(request.getParameter("upto"));
		
		Member obj=new Member();
		obj.setMemno(memno);
		obj.setMemnm(memnm);
		obj.setAge(age);
		obj.setWeight(weight);
		obj.setGender(gender);
		obj.setMobno(mobno);
		obj.setCity(city);
		obj.setUpto(upto);
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Member.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		ses.persist(obj);
		ses.getTransaction().commit();
		
		response.sendRedirect("home.html");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
