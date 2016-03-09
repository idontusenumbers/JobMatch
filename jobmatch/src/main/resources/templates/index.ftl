<#include "auth-base.ftl">

<#macro header>LOGIN</#macro>

<#macro auth_page_body>
<form action="/login" name="user" method="post" class="form form-login">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="text" id="login-username" name="username" required>
        <label class="mdl-textfield__label" for="login-username">Username</label>
    </div>
    <br />
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="password" id="login-password" name="password" required>
        <label class="mdl-textfield__label" for="login-password">Password</label>
    </div>

    <a href="#" class="mdl-button mdl-js-button mdl-js-ripple-effect">Forgot...</a>
    <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
        Login
    </button>
</form>

<div class="form-text">
    <p>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                onclick="parent.location='/register'">Register
        </button>
    </p>
</div>
</#macro>
<@display_page/>