<#include "auth-base.ftl">

<#macro header>REGISTER</#macro>

<#macro auth_page_body>
<form action="/register" name="user" method="post" class="form form-login">
    <@spring.bind "user" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="form-field">
        <label class="demo-list-radio mdl-radio mdl-js-radio mdl-js-ripple-effect" for="role0">
            <input type="radio" id="role0" class="mdl-radio__button" name="role" value="2" checked/> Seeker
        </label>
        <br/>
        <label class="demo-list-radio mdl-radio mdl-js-radio mdl-js-ripple-effect" for="role1">
            <input type="radio" id="role1" class="mdl-radio__button" name="role" value="3"/> Employer
        </label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="text" id="username" name="username" required>
        <label class="mdl-textfield__label" for="username">Username</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="email" id="email" name="email" required>
        <label class="mdl-textfield__label" for="email">Email</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="password" id="password" name="password" required>
        <label class="mdl-textfield__label" for="password">Password</label>
    </div>
    <div class="form-field">
        <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="optIn">
            <input type="checkbox" id="optIn" name="optIn" class="mdl-checkbox__input"/> Opt in
        </label>
    </div>
    <a href="/login" class="forgot-password">&lt; login</a>
    <button type="submit" value="create"
            class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">
        Register
    </button>
</form>


</#macro>
<@display_page/>