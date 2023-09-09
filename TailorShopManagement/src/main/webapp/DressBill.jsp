
<%@page import="com.admin.DressBillPojo"%>
<%@page import="com.admin.DressBillPojo"%>
<%@page import="com.admin.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous" />
<link rel="stylesheet" href="style.css" />

</head>

<body>
	<header class="d-flex justify-content-center py-3">
		<!-- place navbar here -->
		<ul class="nav nav-item">
			<li class="nav-item"><a href="index.html" class="nav-link"
				aria-current="page">Home</a></li>
			<li class="nav-item"><a href="admin.jsp" class="nav-link">Back</a></li>
		</ul>
	</header>
	<main>
		<%
		String username = request.getParameter("username");
		
	
		AdminDao adminDao = new AdminDao();
		DressBillPojo billPojo = adminDao.generateDressBill(username);
		%>
		<div class="container">

			<div class="table-responsive mt-5">
				<table class="table align-middle">
					<thead class="table-light">
					
					
					<tr class="table-light">
					
						<th>Name</th>
						<th>Bill No</th>
						<th>Date</th>
						<th>Cloth</th>
						<th>DressType</th>
						<th>Measurements</th>
						<th>Price</th>
						<th></th>
					</tr>
					</thead>
					<tbody>
						<tr class="table-light">
						
							<td><%=billPojo.getName()%></td>
							<td><%=billPojo.getBillNo() %></td>
							<td><%=billPojo.getDate()%></td>
							<td>Dress</td>
							<td><%=billPojo.getDresstype()%></td>
							<td>Chest:<%=billPojo.getChest()%><br /> Shoulder:<%=billPojo.getShoulder()%><br />
								LengthofHand:<%=billPojo.getLengthofhand()%><br />
								LengthofTop:<%=billPojo.getLengthoftop()%><br /> Neck:<%=billPojo.getNeck()%><br />
								Waist:<%=billPojo.getWaist()%><br /> LengthofLower:<%=billPojo.getLengthoflower()%><br />
								LengthofBottom:<%=billPojo.getLengthofbottom()%>
							</td>
							<td><%=billPojo.getPrice()%></td>
							<td><form action="EmailDressServlet" method="post">
									<button type="submit" class="btn btn-danger">Submit</button>
									<input type="hidden" name="email"
										value="<%=billPojo.getEmail()%>">
								    <input type="hidden" name="username" value="<%=username%>">
                                    <input type="hidden" name="cloth" value="<%=billPojo.getCloth()%>">
								</form></td>
						</tr>

					</tbody>
					<tfoot></tfoot>
				</table>

			</div>


		</div>
	</main>
	<footer>
		<!-- place footer here -->
	</footer>
	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous"></script>
</body>
</html>
