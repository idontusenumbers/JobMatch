<#include "authentication-base.ftl">

<#macro header>REGISTER</#macro>

<#macro auth_page_body>
<form action="" method="post" class="form form-login">
    <div class="form-field">
        <input id="login-username" type="text" class="form-input" placeholder="Email" required/>
    </div>
    <div class="form-field">
        <input id="login-password" type="password" class="form-input" placeholder="Password" required/>
    </div>
    <div class="form-field">
        <input type="submit" value="Register"/>
    </div>
    <div class="clear"></div>
</form>

</#macro>
<@display_page/>