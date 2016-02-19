<#include "../base.ftl">
<body>
<h1>Home</h1>

<#macro page_body>
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
                <li><a href="home"</li>
                <li><a href="#">Jobs</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </nav>
    </div>

    <section id="content"></section>

    <div class="clear"></div>
</div>
</#macro>

<@display_page />