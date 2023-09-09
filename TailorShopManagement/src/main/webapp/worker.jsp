

<%@page import="com.worker.WorkerDressBlouseBothPOJO"%>
<%@page import="com.worker.WorkerBlouseOrderPOJO"%>
<%@page import="java.util.List"%>
<%@page import="com.worker.WorkerDressOrderPOJO"%>
<%@page import="com.worker.WorkerDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous" />
    <link rel="stylesheet" href="style.css" />
</head>
<body>
    <header class="d-flex justify-content-center py-3 k">
        <!-- place navbar here -->
        <ul class="nav nav-item">
            <li class="nav-item"><a href="index.html" class="nav-link" aria-current="page">Home</a></li>
            <li class="nav-item"><a href="login.jsp" class="nav-link">Back</a></li>
        </ul>
    </header>
    <main>
        <%
        String username = (String) request.getSession().getAttribute("username");
        username.strip();

        WorkerDAO dao = new WorkerDAO();
        List<WorkerDressOrderPOJO> dressOrders = dao.showDressOrders(username);
        List<WorkerBlouseOrderPOJO> blouseOrders = dao.showBlouseOrders(username);
        List<WorkerDressBlouseBothPOJO> dressblouseOrders = dao.showDressBlouseOrders(username);
        %>
        <div class="row mt-5">
            <% for (WorkerDressOrderPOJO dress : dressOrders) { %>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="<%= dao.getPatternPath(dress.getPattern()) %>" height="300px" width="300px" class="card-img-top" alt="Pattern">
                    <div class="card-body">
                        <h5 class="card-title"><%= dress.getName() %></h5>
                         <h6 class="card-title">Bill No:<%= dress.getBillNo() %></h6>
                        <p class="card-text">Type: <%= dress.getDresstype() %></p>
                        <p class="card-text">Measurements:</p>
                        <ul class="list-unstyled">
                            <li>Chest: <%= dress.getChest() %></li>
                            <li>Shoulder: <%= dress.getShoulder() %></li>
                            <li>Length of Bottom: <%= dress.getLengthofbottom() %></li>
                            <li>Length of Hand: <%= dress.getLengthofhand() %></li>
                            <li>Length of Lower: <%= dress.getLengthoflower() %></li>
                            <li>Length of Top: <%= dress.getLengthoftop() %></li>
                            <li>Neck: <%= dress.getNeck() %></li>
                            <li>Waist: <%= dress.getWaist() %></li>
                        </ul>
                        <p class="card-text">Description :<%=dress.getDressdescription() %> </p>
                        
                        <form action="WorkerCompletedServlet" method="post">
                            <input type="hidden" name="dateTime" value="<%= dress.getDate() %>">
                            <input type="hidden" name="action" value="dress">
                            <input type="submit" value="Complete" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </div>
            <% } %>

            <% for (WorkerBlouseOrderPOJO blouse : blouseOrders) { %>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="<%= dao.getPatternPath(blouse.getPattern()) %>" height="300px" width="300px" class="card-img-top" alt="Pattern">
                    <div class="card-body">
                        <h5 class="card-title"><%= blouse.getName() %></h5>
                        <h6 class="card-title">Bill No:<%= blouse.getBillNo() %></h6>
                        <p class="card-text">Type: Blouse</p>
                        <p class="card-text">Measurements:</p>
                        <ul class="list-unstyled">
                            <li>Chest: <%= blouse.getChest() %></li>
                            <li>Waist: <%= blouse.getWaist() %></li>
                            <li>Length of Blouse: <%= blouse.getLengthofblouse() %></li>
                            <li>Length of Hand: <%= blouse.getLengthofhand() %></li>
                            <li>Shoulder: <%= blouse.getShoulder() %></li>
                            <li>Neck: <%= blouse.getNeck() %></li>
                        </ul>
                        <p class="card-text">Description: <%=blouse.getBlousedescription() %> </p>
                        <form action="WorkerCompletedServlet" method="post">
                            <input type="hidden" name="dateTime" value="<%= blouse.getDate() %>">
                            <input type="hidden" name="action" value="blouse">
                            <input type="submit" value="Complete" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </div>
            <% } %>

            <% for (WorkerDressBlouseBothPOJO dressblouseboth : dressblouseOrders) { %>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="<%= dao.getPatternPath(dressblouseboth.getBlousepattern()) %>" height="300px" width="300px" class="card-img-top" alt="Blouse Pattern">
                    <img src="<%= dao.getPatternPath(dressblouseboth.getDresspattern()) %>" height="300px" width="300px" class="card-img-top" alt="Dress Pattern">
                    <div class="card-body">
                        <h5 class="card-title"><%= dressblouseboth.getName() %></h5>
                        <h6 class="card-title">Bill No:<%= dressblouseboth.getBillNo() %></h6>
                        <p class="card-text">Type: Dress and Blouse</p>
                        <p class="card-text">Dress Measurements:</p>
                        <ul class="list-unstyled">
                            <li>Chest: <%= dressblouseboth.getDresschest() %></li>
                            <li>Waist: <%= dressblouseboth.getDresswaist() %></li>
                            <li>Length of Bottom: <%= dressblouseboth.getDresslengthofbottom() %></li>
                            <li>Length of Hand: <%= dressblouseboth.getDresslengthofhand() %></li>
                            <li>Shoulder: <%= dressblouseboth.getDressshoulder() %></li>
                            <li>Neck: <%= dressblouseboth.getDressneck() %></li>
                            <li>Length of Lower: <%= dressblouseboth.getDresslengthoflower() %></li>
                            <li>Length of Top: <%= dressblouseboth.getDresslengthoftop() %></li>
                        </ul>
                        <p class="card-text">Blouse Measurements:</p>
                        <ul class="list-unstyled">
                            <li>Chest: <%= dressblouseboth.getBlousechest() %></li>
                            <li>Waist: <%= dressblouseboth.getBlousewaist() %></li>
                            <li>Length of Blouse: <%= dressblouseboth.getLengthofblouse() %></li>
                            <li>Length of Hand: <%= dressblouseboth.getBlouselengthofhand() %></li>
                            <li>Neck: <%= dressblouseboth.getBlouseneck() %></li>
                            <li>Shoulder: <%= dressblouseboth.getBlouseshoulder() %></li>
                        </ul>
                        <p class="card-text">Description: <%=dressblouseboth.getDressblousebothdescription() %></p>
                        <form action="WorkerCompletedServlet" method="post">
                            <input type="hidden" name="dateTime" value="<%= dressblouseboth.getDate() %>">
                            <input type="hidden" name="action" value="both">
                            <input type="submit" value="Complete" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </main>
    <footer>
        <!-- place footer here -->
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
</body>
</html>

    
