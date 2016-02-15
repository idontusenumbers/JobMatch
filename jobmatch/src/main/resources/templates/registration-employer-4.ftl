<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Register | Employer | JobMatch</title>
  <meta name="description" content="JobMatch">
  <link rel="stylesheet" href="login.css">
  <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700|Open+Sans:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
</head>
<body>
  <div class="site-container">
    <div class="grid-container">
      <h1 class="headline"><span class="logo">JobMatch</span> | EMPLOYER</h1><hr><br>
      <div><progress value="100" max="100"></progress></div><br>
      <p>Key contact person information:</p>
      <form action="dashboard-employer.ftl" method="post" class="form form-login form-register">
        <div class="form-field">
          <input id="login-first" type="text" class="form-input" placeholder="First name">
          <input id="login-last" type="text" class="form-input" placeholder="Last name">
        </div>
        <div class="form-field">
          <input id="login-email" type="text" class="form-input" placeholder="Email">
        </div>
        <div class="form-field">
          <input type="submit" value="next">
        </div>
        <div class="clear"></div>
      </form>
    </div>
  </div>
</body>
</html>