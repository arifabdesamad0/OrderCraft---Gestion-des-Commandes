<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>OrderCraft Dashboard</title>
  <!-- Fonts and Icons -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
  <!-- Nucleo Icons -->
  <link href="assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <!-- CSS Files -->
  <link id="pagestyle" href="assets/css/soft-ui-dashboard.css?v=1.0.7" rel="stylesheet" />
</head>

<body class="">
<div class="container position-sticky z-index-sticky top-0">
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg blur blur-rounded top-0 z-index-3 shadow position-absolute my-3 py-2 start-0 end-0 mx-4">
    <div class="container-fluid pe-0">
      <a class="navbar-brand font-weight-bolder ms-lg-0 ms-3 " href="dashboard.jsp">
        OrderCraft
      </a>
      <!-- Navbar links and buttons here -->
    </div>
  </nav>
  <!-- End Navbar -->
</div>

<main class="main-content mt-0">
  <section>
    <div class="page-header min-vh-75">
      <div class="container">
        <div class="row">
          <!-- Login Form -->
          <div class="col-xl-4 col-lg-5 col-md-6 d-flex flex-column mx-auto">
            <div class="card card-plain mt-8">
              <div class="card-header pb-0 text-left bg-transparent">
                <h3 class="font-weight-bolder text-info text-gradient">Welcome to OrderCraft</h3>
                <p class="mb-0">Enter your credentials to manage your orders</p>
              </div>
              <div class="card-body">
                <form action="LoginController" method="post"> <!-- Update action as per your controller mapping -->
                  <label>Email</label>
                  <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Email" name="Email">
                  </div>
                  <label>Password</label>
                  <div class="mb-3">
                    <input type="password" class="form-control" placeholder="Password" name="Password">
                  </div>
                  <div class="text-center">
                    <button type="submit" class="btn bg-gradient-info w-100 mt-4 mb-0">Sign in</button>
                    <div style="color: red;">
                      <% if(request.getAttribute("ERROR") != null) { %>
                      <p><%= request.getAttribute("ERROR").toString() %></p>
                      <% } %>
                    </div>
                  </div>
                </form>
              </div>
              <div class="card-footer text-center pt-0 px-lg-2 px-1">
                <p class="mb-4 text-sm mx-auto">
                  Don't have an account?
                  <a href="sign-up.jsp" class="text-info text-gradient font-weight-bold">Sign up</a>
                </p>
              </div>
            </div>
          </div>
          <!-- End of Login Form -->
          <!-- Other content can be added here -->
        </div>
      </div>
    </div>
  </section>
</main>

<footer class="footer py-5">
  <!-- Footer Content Here -->
</footer>
<!-- Core JS Files -->
<script src="assets/js/core/popper.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<!-- Other JS Scripts -->
</body>

</html>
