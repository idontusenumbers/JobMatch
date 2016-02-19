<#include "auth-base.ftl">

<#macro header>REGISTER</#macro>

<#macro auth_page_body>
<form action="/register" name="user" method="post" class="form form-login">
    <@spring.bind "user" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="form-field">
        <@spring.formRadioButtons path="user.role" separator="<br/>" attributes="required" options=roleMap />
    </div>
    <div class="form-field">
        <@spring.formInput path="user.username" attributes="placeholder='username' class='form-input' required" />
        <@spring.showErrors separator="user.username" classOrStyle="error" />
    </div>
    <div class="form-field">
        <@spring.formInput path="user.email" attributes="placeholder='email' class='form-input' required" />
        <@spring.showErrors separator="user.email" classOrStyle="error" />
    </div>
    <div class="form-field">
        <@spring.formPasswordInput path="user.password" attributes="placeholder='Password' class='form-input' required"/>
        <@spring.showErrors separator="user.password" classOrStyle="error"/>
    </div>
    <div class="form-field">
        <@spring.formCheckbox path="user.optIn" attributes="class='form-input' required"/>
        <label for="optIn">Opt in</label>
        <@spring.showErrors separator="user.optIn" classOrStyle="error"/>
    </div>
    <a href="/login" class="forgot-password">&lt; login</a>
    <input type="submit" value="create" class="call-to-action">
</form>


</#macro>
<@display_page/>