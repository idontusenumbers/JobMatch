<#include "base.ftl">


<#macro page_body>
<h1>Welcome!!!</h1>

<form action="/" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <label for="username">Username:</label>
    <input type="text" name="username"/><br/>
    <label for="password">Password:</label>
    <input type="password" name="password"/><br/>

    <input type="submit"/>
</form>
</#macro>

<@display_page/>