<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!Doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>

<body>
	<header>
		<!-- place navbar here -->
		<header class="d-flex justify-content-center py-3 ">
			<ul class="nav nav-item">
				<li class="nav-item "><a href="index.html" class="nav-link"
					aria-current="page">Home</a></li>
				<li class="nav-item"><a href="AddOrder.jsp" class="nav-link ">Back</a></li>
			</ul>
		</header>
	</header>
	<main>
		<%
		String username = request.getParameter("username");
		String datetime = request.getParameter("dateTime");
	
		%>
		<div class="row g-2">

			<div class=" col-lg-6 col-md-6  p-3">
				<form class="mt-3 border border p-5 bg-light" id="form"
					action="DressDetailsServlet" method="post">

					<div class="mb-3">
						<label for="name" class="form-label">Name: <%=username%></label>
						<input type="hidden" class="form-control" id="name"
							name="username" value="<%=username%>"> <input
							type="hidden" class="form-control"  name="dateTime"
							value="<%=datetime%>">

					</div>
					<div class="mb-3">
						<div class="dropdown">
							<select name="dresstype" id="dress" required>
								<option value="punjabi suit" style="background-color: #FFDBAA;">Punjabi
									Suit</option>
								<option value="kurti">Kurti</option>
								<option value="plazo" style="background-color: #FFDBAA;">Plazo</option>
								<option value="patiala">Patiala</option>
								<option value="gown" style="background-color: #FFDBAA;">Gown</option>
							</select>
						</div>
					</div>
					<div class="mb-3">
						<label for="address" class="form-label">Enter
							Measurements:</label>

						<div class="mb-3">
							<label for="shoulder" class="form-label">Shoulder</label> <input
								type="text" class="form-control" id="shoulder" name="shoulder"
								placeholder="Enter Measurements for Shoulder" required>

						</div>
						<div class="mb-3">
							<label for="chest" class="form-label">Chest</label> <input
								type="text" class="form-control" id="chest" name="chest"
								placeholder="Enter Measurements for Chest" required>
						</div>
						<div class="mb-3">
							<label for="lengthofdress" class="form-label">Length Of
								Top</label> <input type="text" class="form-control" id="lengthoftop"
								name="lengthoftop"
								placeholder="Enter Measurements for Length Of Dress" required>
						</div>
						<div class="mb-3">
							<label for="lengthofhand" class="form-label">Length of
								Hand</label> <input type="text" class="form-control" id="lengthofhand"
								name="lengthofhand"
								placeholder="Enter Measurements for Length Of Hand" required>
						</div>
						<div class="mb-3">
							<label for="neck" class="form-label">Length of Neck</label> <input
								type="text" class="form-control" id="neck" name="neck"
								placeholder="Enter Measurements for Neck" required>
						</div>
						<div class="mb-3">
							<label for="waist" class="form-label">Waist</label> <input
								type="text" class="form-control" id="waist" name="waist"
								placeholder="Enter Measurements for Waist" required>
						</div>
						<div class="mb-3">
							<label for="lengthoflower" class="form-label">Length of
								Lower</label> <input type="text" class="form-control" id="lengthoflower"
								name="lengthoflower"
								placeholder="Enter Measurements for Length Of Lower" required>
						</div>
						<div class="mb-3">
							<label for="lengthofbottom" class="form-label">Length of
								Bottom</label> <input type="text" class="form-control"
								id="lengthofbottom" name="lengthofbottom"
								placeholder="Enter Measurements for Length Of Bottom" required>
						</div>
						<div class="mb-3">
							<label for="description" class="form-label">Description</label> <input
								type="text" class="form-control" id="description"
								name="description" placeholder="Enter Description" required>
						</div>
						<div class="mb-3">
							<label for="pattern" class="form-label">Enter Pattern</label>

						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="dresspattern"
								id="" value="Pattern1"> <img
								src="Image/dresspattern1.jpg" alt="" height="70px" width="60px">
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="dresspattern"
								id="" value="Pattern2"> <img
								src="Image/dresspattern2.jpg" alt="" height="70px" width="60px">
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="dresspattern"
								id="" value="Pattern3"> <img
								src="Image/dresspattern3.jpg" alt="" height="70px" width="60px">
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="dresspattern"
								id="" value="Pattern4"> <img
								src="Image/dresspattern4.jpg" alt="" height="70px" width="60px">
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="dresspattern"
								id="" value="Pattern5"> <img
								src="Image/dresspattern5.jpg" alt="" height="70px" width="60px">
						</div>
						<label for="nopattern" class="form-label">No Pattern</label> <input
							class="form-check-input" type="radio" name="dresspattern" id=""
							value="No Pattern"> <br>
						<br>  

						<button type="submit" class="btn btn-dark"
							style="background-color: #ffbfbf; color: black;">Submit</button>
				</form>
			</div>
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