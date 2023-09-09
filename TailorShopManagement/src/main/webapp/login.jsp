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
          <a href="index.html" class="nav-link">Back</a>
        </li>
      </ul>
    </header>
    <main>
      <div class="container">
        <div class="row g-2">
          <div class="col-lg-6 col-md-6 p-5">
            <form
              class="mt-5 border border bg-light p-3"
              id="form"
              action="LoginServlet"
              method="post"
            >
              <div class="form-floating mb-3">
                <input
                  type="text"
                  class="form-control"
                  name="username"
                  id="name"
                  placeholder=""
                  required
                />
                <label for="formId1">Name</label>
              </div>

              <div class="form-floating mb-3">
                <input
                  type="password"
                  class="form-control"
                  name="password"
                  id="password"
                  placeholder=""
                  required
                />
                <label for="formId2">Password</label>
              </div>

              <button
                type="submit"
                class="btn btn-dark"
                name="submitbutton"
                style="background-color: #ffbfbf; color: black"
              >
                Submit
              </button>
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
