<#include "authentication-base.ftl">

<#macro header>REGISTER</#macro>

<#macro auth_page_body>
<form action="/register" name="user" method="post" class="form form-login">
    <@spring.bind "user" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="form-field">
        <@spring.formRadioButtons path="user.role" separator="" attributes="required" options=roleMap />
    </div>
    <div class="form-field">
        <@spring.formInput path="user.username" attributes="placeholder='Username' class='form-input' required" />
        <@spring.showErrors separator="user.username" classOrStyle="error" />
    </div>
    <div class="form-field">
        <@spring.formPasswordInput path="user.password" attributes="placeholder='Password' class='form-input' required"/>
        <@spring.showErrors separator="user.password" classOrStyle="error"/>
    </div>
    <div class="form-field">
        <input id="login-confirm" name="password" type="password" class="form-input" placeholder="Confirm password"
               required/>
    </div>
    <div class="form-field">
        <input type="submit" value="create my account">
    </div>
    <div class="clear"></div>
</form>

<div class="form-text">
    <p><a href="/login" class="forgot-password">&lt; Back to login page</a></p>
</div>
</#macro>
<@display_page/>