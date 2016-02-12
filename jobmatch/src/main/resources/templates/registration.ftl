<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Register | JobMatch</title>
  <meta name="description" content="JobMatch">
  <link rel="stylesheet" href="css/login.css">
  <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700|Open+Sans:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
</head>
<body>
  <div class="site-container">
		<div class="grid-container">
			<h1 class="headline"><span class="logo">JobMatch</span> | REGISTER</h1><hr><br>
      <form action="" method="post" class="form form-login form-register">
        <div class="form-field">
          <div class="radio-button">
            <input type="radio" name="user-type" id="employer" value="employer" checked>
            <label for="employer">Employer</label>
          </div>
          <div class="radio-button">
            <input type="radio" name="user-type" id="job-seeker" value="job-seeker">
            <label for="job-seeker">Job Seeker</label>
          </div>
        </div>
        <div class="form-field">
          <input id="login-username" type="text" class="form-input" placeholder="Email" required>
        </div>
        <div class="form-field">
          <input id="login-password" type="password" class="form-input" placeholder="Password" required>
        </div>
        <div class="form-field">
          <input id="login-confirm" type="password" class="form-input" placeholder="Confirm password" required>
        </div>
        <div class="form-field">
          <input type="submit" value="create my account">
        </div>
        <div class="clear"></div>
      </form>
      
	    <div class="form-text">
	      <p><a href="#" class="forgot-password">&lt; Back to login page</a></p>
	    </div>
    </div>
  </div>
</body>
</html>