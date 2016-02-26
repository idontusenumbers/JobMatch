<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Employer Dashboard | JobMatch</title>
  <meta name="description" content="JobMatch">
    <link rel="stylesheet" href="/static/styles/main.css">
    <link href='//fonts.googleapis.com/css?family=Montserrat:400,700|Open+Sans:400,700,400italic,700italic'
          rel='stylesheet' type='text/css'>
</head>
<body>
  <div id="wrapper">
    <header>
      <h1 class="headline"><span class="logo">JobMatch</span> | EMPLOYER</h1>
    </header>

    <div id="sidebar">
      <div style="text-align:center;">
        <img src="http://placehold.it/75x75" class="avatar">
        <h2 class="company">Company A</h2>
      </div><br>
      <p><button type="button" class="sidebar-button">+ post a job</button></p><br>
      
      <nav>
        <ul id="sidebar-nav">
          <li><a href="#">Jobs</a></li>
            <li><a href="/users/${user.getId()}/profile">Profile</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
      </nav>
    </div>

      <section id="content">
          <div class="jobs-list">
              <ul class="title-matches-list">
                  <li><div class="title">Job Title</div><div class="matches">Matches: 6</div></li>
                  <li><div class="title">Job Title</div><div class="matches">Matches: 2</div></li>
              </ul>
          </div>
      </section>

    <div class="clear"></div> 
  </div>
</body>
</html>