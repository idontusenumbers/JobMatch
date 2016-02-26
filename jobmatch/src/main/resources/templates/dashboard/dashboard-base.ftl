<#include "../base.ftl">


<#macro page_head>
<link rel="stylesheet" href="/static/styles/main.css">
</#macro>
<#macro dashoard_nav>
    You forgot to include the dashboard nav
</#macro>
<#macro dashoard_body>
    You forgot to include the dashboard body
</#macro>
<#macro page_body>
<div id="wrapper">
    <header>
        <h1 class="headline"><span class="logo">JobMatch</span> | EMPLOYER</h1>
    </header>

    <div id="sidebar">
        <div style="text-align:center;">
            <h2 class="company">${auth.principal.username}</h2>
        </div>
        <br>
        <p>
            <button type="button" class="sidebar-button">+ post a job</button>
        </p>
        <br>

        <nav>
            <ul id="sidebar-nav">
                <li><a href="#">Jobs</a></li>
                <li><a href="/users/${user.getId()}/profile">Profile</a></li>

                <@dashboard_nav />
                <li><a href="/logout">Logout</a></li>
            </ul>
        </nav>
    </div>

    <section id="content"><@dashboard_body /></section>

    <div class="clear"></div>
</div>
</#macro>

<#macro page_body_footer>
<script type="text/javascript" src="/static/js/auth.js"></script>
</#macro>