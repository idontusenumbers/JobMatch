<#include "auth-base.ftl">

<#macro header>LOGIN</#macro>

<#macro auth_page_body>
<form action="/login" name="user" method="post" class="form form-login">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="form-field">
        <input id="login-username" name="username" type="text" class="form-input" placeholder="Username" required>
    </div>
    <div class="form-field">
        <input id="login-password" name="password" type="password" class="form-input" placeholder="Password" required>
    </div>

    <a href="#" class="forgot-password">Forgot...</a>
    <input type="submit" value="Login" class="button">
</form>

<div class="form-text">
    <p>
        <button type="button" class="call-to-action" onclick="parent.location='/register'">Register</button>
    </p>
</div>
</#macro>
<@display_page/>