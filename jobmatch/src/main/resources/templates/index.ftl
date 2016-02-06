<#include "authentication-base.ftl">

<#macro header>LOGIN</#macro>

<#macro auth_page_body>
<form action="login" method="post" class="form form-login">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="form-field">
        <input id="login-username" name="username" type="text" class="form-input" placeholder="Email" required>
    </div>
    <div class="form-field">
        <input id="login-password" name="password" type="password" class="form-input" placeholder="Password" required>
    </div>
    <div class="form-field">
        <input type="submit" value="Login">
    </div>
    <div class="clear"></div>
</form>

<div class="form-text">
    <p>
        <a href="#" class="forgot-password">Forgot your password?</a>
        <button type="button" class="register-button" onclick="parent.location='/register'">Register</button>
    </p>
</div>
</#macro>
<@display_page/>