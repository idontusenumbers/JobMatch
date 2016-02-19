<#include "base.ftl">

<#macro auth_page_body >
    oops, you forgot to implement an auth_page_body in your template!
</#macro>

<#macro page_head>
<link rel="stylesheet" href="/static/styles/login.css">
</#macro>

<#macro page_body>
<div class="site-container">
    <div class="grid-container">
        <h1><span class="logo">JobMatch</span> <@header/></h1>
        <hr>
        <@error_list errors/>
        <br>
        <@auth_page_body/>
    </div>
</div>
</#macro>

<#macro page_body_footer>
<script type="text/javascript" src="/static/js/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="/static/js/main.js"></script>
<script type="text/javascript" src="/static/js/auth.js"></script>
</#macro>