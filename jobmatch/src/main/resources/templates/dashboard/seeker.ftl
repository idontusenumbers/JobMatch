<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Job Seeker Dashboard | JobMatch</title>
  <meta name="description" content="JobMatch">
    <link rel="stylesheet" href="/static/styles/main.css">
  <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700|Open+Sans:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
</head>
<body>
  <div id="wrapper">
    <header>
      <h1 class="headline"><span class="logo">JobMatch</span> | JOB SEEKER</h1>
    </header>

    <div id="sidebar">
      <div style="text-align:center;">
        <img src="http://placehold.it/75x75" class="avatar">
        <h2 class="company">Company A</h2>
      </div><br>
      <p><button type="button" class="sidebar-button">view job matches</button></p><br>
      
      <nav>
        <ul id="sidebar-nav">
          <li><a href="#">Jobs</a></li>
            <li><a href="/users/">Profile</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
      </nav>
    </div>

    <section id="content"></section>

    <div class="clear"></div>
  </div>
</body>
</html>