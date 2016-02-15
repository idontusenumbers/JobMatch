<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Job Seeker Dashboard | JobMatch</title>
  <meta name="description" content="JobMatch">
  <link rel="stylesheet" href="main.css">

  <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700|Open+Sans:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
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
          <li><a href="#">Profile</a></li>
          <li><a href="#">Logout</a></li>
        </ul>
      </nav>
    </div>

    <section id="content">
      <div id="job-post">
        <h2>Post a job</h2><br>
        <form action="" method="post" class="form form-jobpost">
          <div class="form-field">
            <label for="jobpost-title">Title</label>
            <input id="jobpost-title" type="text" class="form-input" placeholder="Job title">
          </div>
          <div class="form-field">
            <label for="jobpost-summary">Description</label>
            <textarea name="jobpost-summary" placeholder="Job description"></textarea>
          </div>
          <div class="form-field">
            <p>Job type</p>
            <div class="radio-button">
              <input type="radio" name="jobpost-type" id="full-time" value="full-time" checked>
              <label for="full-time">Full-time</label>
            </div>
            &nbsp;
            <div class="radio-button">
              <input type="radio" name="jobpost-type" id="part-time" value="part-time">
              <label for="part-time">Part-time</label>
            </div>
          </div><br>
          <div class="form-field">
            <p class="select-text">Years of experience required</p>
            <select name="years-experience" id="experience">
              <option value="0-1" selected>0-1 years</option>
              <option value="2-3">2-3 years</option>
              <option value="4-5">4-5 years</option>
              <option value="6+">6+ years</option>
            </select>
          </div>
          <div>
            <input type="submit" value="next">
          </div>
        </form>
      </div>
    </section>

    <div class="clear"></div>
  </div>
</body>
</html>