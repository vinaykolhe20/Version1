

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.cfg.*" %>  
 <%@ page import="org.hibernate.*" %>    
 <%@ page import="com.gym.entities.*" %>
 <%@ page import="org.hibernate.query.Query" %>   
 <%@ page import="java.util.*" %>          
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>

   <h1>Member Report</h1>

   <hr>
        <table class="table table=bordered table-hover">

            <tr>
                <th>Member Number</th>
                <th>Member Name</th>
                <th>Age</th>
                <th>Weight</th>
                <th>Gender</th>
                <th>Mobile</th>
                <th>City</th>
                <th>Subscribtion End</th>
            </tr>
            
            <%
            Configuration cfg=new Configuration().configure();
            SessionFactory sf=cfg.addAnnotatedClass(Member.class).buildSessionFactory();
            Session ses=sf.getCurrentSession();
            ses.beginTransaction();
            
            Query<Member> q=ses.createQuery("from Member");
            List<Member> lst=q.getResultList();
            
            
            Member m;
            for(int i=0;i<lst.size();i++)
            {
            	m=(Member) lst.get(i);
            	
            
            %>
            <tr>
                <td><%=m.getMemno() %></td>
                <td><%=m.getMemnm() %></td>
                <td><%=m.getAge() %></td>
                <td><%=m.getWeight() %></td>
                <td><%=m.getGender() %></td>
                <td><%=m.getMobno() %></td>
                <td><%=m.getCity() %></td>
                <td><%=m.getUpto()%></td>
            </tr>
            <%
            }
            ses.close();
            %>
            
        </table>

<br>
<a href="total.jsp">total</a>
    <a href="index.html">Home</a>


</body>
</html>