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
        <h1><span class="logo"><a href="/">JobMatch</a></span> <@header/></h1>
        <hr>
        <@error_list errors/>
        <@auth_page_body/>
    </div>
</div>
</#macro>

<#macro page_body_footer>
<script type="text/javascript" src="/static/js/auth.js"></script>
</#macro>