<%@page import="com.admin.OrderCompletedPOJO"%>
<%@page import="java.util.List"%>
<%@page import="com.admin.AdminOrderCompletedDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS v5.2.1 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="style.css" />
  </head>

  <body>
    <header class="d-flex justify-content-center py-3 k">
      <!-- place navbar here -->
      <ul class="nav nav-item">
        <li class="nav-item">
          <a href="index.html" class="nav-link" aria-current="page">Home</a>
        </li>
        <li class="nav-item">
          <a href="admin.jsp" class="nav-link">Back</a>
        </li>
      </ul>
    </header>
    <main>
   <%
    AdminOrderCompletedDao orderCompletedDao = new AdminOrderCompletedDao();
     List<OrderCompletedPOJO> dress = orderCompletedDao.showDressorderCompleted();
     List<OrderCompletedPOJO> blouse= orderCompletedDao.showBlouseorderCompleted();
     List<OrderCompletedPOJO> dressblouseboth=orderCompletedDao.showDressBlouseorderCompleted();
	%>
      <div class="table-responsive">
        <table
          class="table table-striped table-hover table-borderless table-primary align-middle mt-5"
        >
          <thead class="table-primary">
            <tr>
			<th>Name</th>
			<th>Contact</th>
			<th>Date</th>
			<th>Worker</th>
			<th>Cloth</th>
			<th>Price</th>
		</tr>
          </thead>
          <tbody class="table-group-divider">
            <%
		for(OrderCompletedPOJO order : dress){
	%>
		<tr>
			<td><%= order.getName()%></td>
			<td><%= order.getContact()%></td>
			<td><%= order.getDate()%></td>
			<td><%= order.getWorker()%></td>
			<td><%= order.getCloth()%></td>
			<td><%= order.getPrice()%></td>
		</tr>
	<%
		}
	%>
	
	<%
		for(OrderCompletedPOJO order : blouse){
	%>
		<tr>
			<td><%= order.getName()%></td>
			<td><%= order.getContact()%></td>
			<td><%= order.getDate()%></td>
			<td><%= order.getWorker()%></td>
			<td><%= order.getCloth()%></td>
			<td><%= order.getPrice()%></td>
		</tr>
	<%
		}
	%>
	<%
		for(OrderCompletedPOJO order : dressblouseboth){
	%>
		<tr>
			<td><%= order.getName()%></td>
			<td><%= order.getContact()%></td>
			<td><%= order.getDate()%></td>
			<td><%= order.getWorker()%></td>
			<td><%= order.getCloth()%></td>
			<td><%= order.getPrice()%></td>
		</tr>
	<%
		}
	%>

          </tbody>
          <tfoot></tfoot>
        </table>
      </div>
    </main>
    <footer>
      <!-- place footer here -->
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
      integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
      crossorigin="anonymous"
    ></script>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
      integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>