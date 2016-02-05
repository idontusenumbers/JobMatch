<#include "base.ftl">

<#macro auth_page_body >
    oops, you forgot to implement an auth_page_body in your template!
</#macro>

<#macro page_body>
<div class="site-container">
    <div class="grid-container">
        <h1><span class="logo">JobMatch</span> | LOGIN</h1>
        <hr>
        <br>
        <@auth_page_body/>
    </div>
</div>




</#macro>
