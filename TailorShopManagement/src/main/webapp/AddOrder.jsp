<%@page import="com.worker.WorkerDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!Doctype html>
<html lang="en">

<head>
<title>Title</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

</head>

<body>

	<%
	LocalDateTime localDateTime = LocalDateTime.now();
	Timestamp date = Timestamp.valueOf(localDateTime);
	String dateTime = date.toString();
	WorkerDAO wdao = new WorkerDAO();
	List<String> workers = wdao.getWorkers();
	%>
	<header class="d-flex justify-content-center py-3 ">
		

		<ul class="nav nav-item">
			<li class="nav-item "><a href="index.html" class="nav-link"
				aria-current="page">Home</a></li>
			<li class="nav-item"><a href="admin.jsp" class="nav-link ">Back</a></li>
		</ul>

	
	</header>
	<main>
		<div class="row g-2">

			<div class=" col-lg-6 col-md-6  p-3">
				<form class="mt-3 border border p-5 bg-light" id="form"
					action="AddOrderServlet" method="post">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" name="name" id="formId1"
							placeholder="" required /> <label for="formId1">Name</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" name="contact"
							id="formId2" placeholder="" required /> <label for="formId2">Contact</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" name="address"
							id="formId3" placeholder="" / required> <label
							for="formId3">Address</label>
					</div>
					<div class="form-floating mb-3">
						<input type="email" class="form-control" name="email" id="formId4"
							placeholder="" required /> <label for="formId4">Email</label>
					</div>
					<div class="form-floating mb-3">
						<input type="number" class="form-control" name="advance"
							id="formId5" placeholder="" required /> <label for="formId5">Advance
							Payment</label>
					</div>
					<label for="">Worker:</label><br>
					<div class="form-floating mb-3">

						<div class="dropdown ">
							<select name="workertype" id="workertype" required>
								<%
								for (String worker : workers) {
								%>
								<option value="<%=worker%>" style="background-color: #FFDBAA;"><%=worker%></option>
								<%
								}
								%>
							</select>
						</div>

					</div>

					<label for="">Cloth:</label><br>
					<div class="mb-3">
						<div class="dropdown ">
							<select name="cloth" id="cloth" required>
								<option value="dress" style="background-color: #FFDBAA;">Dress</option>
								<option value="blouse">Blouse</option>
								<option value="both" style="background-color: #FFDBAA;">Both</option>
							</select>
						</div>
					</div>
					<label for="">Urgent:</label><br>
					<div class="mb-3">
						<div class="dropdown ">
							<select name="clothStatus" required>
								<option value="YES" style="background-color: #FFDBAA;">YES</option>
								<option value="NO">NO</option>
							</select>
						</div>
					</div>
					<div class="mb-3">
						<div>
							<label>Delivery Date:</label>
						</div>
						<div>
						<input type="date" name="deliveryDate">
                        </div>
					</div>

					<div class="mb-3">
						<input type="hidden" name="dateTime" value="<%=dateTime%>">
					</div>
					<button type="submit" class="btn btn-dark"
						style="background-color: #ffbfbf; color: black;">Submit</button>
				</form>

			</div>
			<div class=" col-lg-6 p-3 col-md-6  p-5" id="imagecontainer">
				<img class="img-fluid rounded-circle" src="Image/logo.jfif" alt=""
					width="500" height="250"><br>
				<br>
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
		crossorigin="anonymous">
		
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous">
		
	</script>
</body>

</html>