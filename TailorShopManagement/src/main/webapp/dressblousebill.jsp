<%@page import="com.admin.AdminDao"%>
<%@page import="com.admin.DressBlouseBillPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Title</title>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous" />
<link rel="stylesheet" href="style.css" />
</head>

<body>
	<header class="d-flex justify-content-center py-3">

		<ul class="nav nav-item">
			<li class="nav-item"><a href="index.html" class="nav-link"
				>Home</a></li>
			<li class="nav-item"><a href="admin.jsp" class="nav-link">Back</a></li>
		</ul>
	</header>
	<main>

		<%
		String username = request.getParameter("username");
		AdminDao adminDao = new AdminDao();
		DressBlouseBillPojo billPojo = adminDao.generateDressBlouseBill(username);
		%>
		<div class="container">
			
				<div class="table-responsive mt-5">
					<table class="table align-middle ">
						<thead class="table-light">
						
						<tr class="table-light">
							<th>Name</th>
							<th>Bill No</th>
							<th>Date</th>
							<th>Cloth</th>
							<th>Dress Measurements</th>
							<th>Blouse Measurements</th>
							<th>Dress Price</th>
							<th>Blouse Price</th>
							<th>Advance</th>
							<th>Total Price</th>
							<th></th>
						</tr>
						</thead>
						<tbody >
							<tr class="table-light">
								<td><%=billPojo.getName() %></td>
								<td><%=billPojo.getBillNo() %></td>
								<td><%=billPojo.getDate()%></td>
								<td>Dress and Blouse</td>
								<td>DresstType:<%=billPojo.getDresstype()%><br> Chest:<%=billPojo.getDresschest()%><br>
									LengthofBottom:<%=billPojo.getDresslengthofbottom()%><br>
									LengthofHand:<%=billPojo.getDresslengthofhand()%><br>
									LengthofLower:<%=billPojo.getDresslengthoflower()%><br>
									LengthofTop:<%=billPojo.getDresslengthoftop()%><br> Neck:<%=billPojo.getDressneck()%><br>
									Shoulder:<%=billPojo.getDressshoulder()%><br> Waist:<%=billPojo.getDresswaist()%>
								</td>
								<td>Chest:<%=billPojo.getBlousechest()%><br>
									LengthofHand:<%=billPojo.getBlouselengthofhand()%><br>
									Neck:<%=billPojo.getBlouseneck()%><br> Shoulder:<%=billPojo.getBlouseshoulder()%><br>
									Waist:<%=billPojo.getBlousewaist()%><br> LengthofBlouse:<%=billPojo.getLengthofblouse()%>
								</td>
								<td><%=billPojo.getDressprice()%></td>
								<td><%=billPojo.getBlouseprice()%></td>
								<td><%=billPojo.getAdvance() %></td>
								<td><%=(billPojo.getDressprice() + billPojo.getBlouseprice())-(billPojo.getAdvance())%></td>
								<td><form action="EmailDressBlouseServlet" method="post">
									<button type="submit" class="btn btn-danger">Submit</button>
									<input type="hidden" name="email"
										value="<%=billPojo.getEmail()%>">
								    <input type="hidden" name="username" value="<%=username%>">
                                    
								</form></td>
							</tr>
							<tr  class="table-light">
						<td colspan="5">Expected Delivery Date:<%=billPojo.getDeliveryDate() %> </td>
						<td colspan="5">For any enquires contact:7710865789</td>
						</tr>
						</tbody>
						<tfoot></tfoot>
					</table>
				</div>
			
		</div>
	</main>
	<footer>

	</footer>

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
