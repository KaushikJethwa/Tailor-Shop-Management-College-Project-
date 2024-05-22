<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Title</title>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="style.css" />
  </head>
  <style>
    form {
      text-align: center;
    }
  </style>
  <body>
    <header class="d-flex justify-content-center py-3 ">
        <ul class="nav nav-item">
          <li class="nav-item">
            <a href="index.html" class="nav-link" aria-current="page">Home</a>
          </li>
          <li class="nav-item">
            <a href="login.jsp" class="nav-link">Back</a>
          </li>
        </ul>
      </header>
    <main>
      <div class="row g-2">
        <div class="col-lg-6 col-md-6 p-3">
          <form
            class="mt-5 mx-5 border border pt-5 pb-5 bg-light"
            id="form"
            action=""
            method="post"
          >
            <div class="mb-3">
              <a
                href="AddOrder.jsp"
                class="btn btn-lg"
                style="background-color: #ffbfbf"
                >AddOrder</a
              >
            </div>
            <div class="mb-3">
              <a
                href="ShowOrders.jsp"
                class="btn btn-lg"
                style="background-color: #ffbfbf"
                >ShowOrder</a
              >
            </div>
            <div class="mb-3">
              <a
                href="OrderRemaning.jsp"
                class="btn btn-lg"
                style="background-color: #ffbfbf"
                >OrderRemaning</a
              >
            </div>
            <div class="mb-3">
              <a
                href="OrderCompleted.jsp"
                class="btn btn-lg"
                style="background-color: #ffbfbf"
                >OrderCompleted</a
              >
            </div>
          </form>
        </div>
        <div class="col-lg-6 p-3 col-md-6 p-5" id="imagecontainer">
          <img
            class="img-fluid rounded-circle"
            src="Image/logo.jfif"
            alt=""
            width="500"
            height="250"
          /><br /><br />
        </div>
      </div>
    </main>
    <footer>
    </footer>
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
