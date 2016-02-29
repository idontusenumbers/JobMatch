<#include "../paged-auth-base.ftl">

<#macro header>PROFILE</#macro>

<#macro form_attributes>
action="profile" name="user" method="post"
</#macro>
<#macro paged_auth_page_body>

<section data-page="0">
    <div class="form-field">
        <br><input id="login-name" type="text" class="form-input" placeholder="Company name" required>
    </div>
    <div class="form-field">
        <textarea name="login-summary" placeholder="Company Description"></textarea>
    </div>
</section>

<section data-page="1">
    <div class="form-field">
        <br><input id="login-HQ" type="text" class="form-input" placeholder="Company HQ">
    </div>
</section>
<section data-page="2">
    <div class="form-field">
        <br><input id="login-website" type="text" class="form-input" placeholder="Company website">
    </div>
</section>
<section data-page="3">
    <p>Key contact person information:</p>
    <div class="form-field">
        <input id="login-first" type="text" class="form-input" placeholder="First name">
        <input id="login-last" type="text" class="form-input" placeholder="Last name">
    </div>
</section>

</#macro>
<@display_page/>