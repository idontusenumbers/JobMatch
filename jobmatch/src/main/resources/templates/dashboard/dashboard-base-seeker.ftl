<#include "../base.ftl">

<#macro auth_page_body >
oops, you forgot to implement an auth_page_body in your template!
</#macro>

<#macro page_head>
<link rel="stylesheet" href="/static/styles/main.css">
</#macro>

<#macro page_body>
<div id="wrapper">
    <header>
        <h1 class="headline"><span class="logo">JobMatch</span> | SEEKER</h1>
    </header>

    <div id="sidebar">
        <div style="text-align:center;">
            <img src="http://placehold.it/75x75" class="avatar">
            <h2 class="company">First Last</h2>
        </div>
        <br>
        <p>
            <button type="button" class="sidebar-button">view job matches</button>
        </p>
        <br>

        <nav>
            <ul id="sidebar-nav">
                <li><a href="#">Jobs</a></li>
                <li><a href="/users/${user.getId()}/profile">Profile</a></li>
                <li><a href="/logout">Logout</a></li>
            </ul>
        </nav>
    </div>

    <section id="content"></section>

    <div class="clear"></div>
</div>
</#macro>

<#macro page_body_footer>
<script type="text/javascript" src="/static/js/auth.js"></script>
</#macro>