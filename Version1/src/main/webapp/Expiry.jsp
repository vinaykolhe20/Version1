<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.hibernate.cfg.*" %>  
 <%@ page import="org.hibernate.*" %> 
 <%@ page import="org.hibernate.query.Query" %>   
 <%@ page import="java.util.*" %> 
 <%@ page import="com.gym.entities.*" %> 
 <%@ page import="java.util.Date" %>
 <%@ page import="java.text.DateFormat" %>
  <%@ page import="java.text.SimpleDateFormat" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
    

    <table class="table table=bordered table-hover">

        <tr>
            <th>Member Number</th>
            <th>Member Name</th>
            <th>Mobile</th>
            <th>Date</th>
        </tr>
        
        
		<%
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Date upto = dateFormat.parse(request.getParameter("upto"));
		%>
       
       <%
       Configuration cfg=new Configuration().configure();
       SessionFactory sf=cfg.addAnnotatedClass(Member.class).buildSessionFactory();
       Session ses=sf.getCurrentSession();
       ses.beginTransaction();
       
       Query<Member> q=ses.createQuery("from Member where upto= :upto");
       q.setParameter("upto",upto);
       List<Member> lst=q.getResultList();
       Member m;
       
       for(int i=0;i<lst.size();i++)
       {
    	   m=lst.get(i);
    	   %>
    	  <tr>
                <td><%=m.getMemno() %></td>
                <td><%=m.getMemnm() %></td>
                <td><%=m.getMobno() %></td>
              	<td><%=m.getUpto() %></td>
            </tr>
            </table>
            <%
       }
       ses.close();
            %> 
       
       
		
</body>
</html>