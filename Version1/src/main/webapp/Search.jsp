<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="org.hibernate.cfg.*" %>  
 <%@ page import="org.hibernate.*" %> 
 <%@ page import="org.hibernate.query.Query" %>   
 <%@ page import="java.util.*" %> 
 <%@ page import="com.gym.entities.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>



    <table class="table table=bordered table-hover">

        <tr>
            <th>Member Number</th>
            <th>Member Name</th>
            <th>Age</th>
            <th>Weight</th>
            <th>Gender</th>
            <th>Mobile</th>
            <th>City</th>
        </tr>
      
        <%
        String memnm=request.getParameter("memnm");
        %>
       
        <%
       
        Configuration cfg=new Configuration().configure();
        SessionFactory sf=cfg.addAnnotatedClass(Member.class).buildSessionFactory();
        Session ses=sf.getCurrentSession();
        ses.beginTransaction();
        
        Query<Member> q=ses.createQuery("from Member where memnm= :memnm");
        q.setParameter("memnm",memnm);
        List<Member> lst=q.getResultList();
        Member m;
        for(int i=0;i<lst.size();i++)
        {
        	m=lst.get(i);
        	%>
            <tr>
                <td><%=m.getMemno() %></td>
                <td><%=m.getMemnm() %></td>
                <td><%=m.getAge() %></td>
                <td><%=m.getWeight() %></td>
                <td><%=m.getGender() %></td>
                <td><%=m.getMobno() %></td>
                <td><%=m.getCity() %></td>
            </tr>
            <%
            }
        ses.close();
        %>
       
        <br>
        
        <a href="index.html">Home</a>
    </body>
</html>