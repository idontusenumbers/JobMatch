<#ftl strip_whitespace=true>
<#include "../paged-dashboard-base.ftl">

<#macro header>PROFILE</#macro>

<#macro form_attributes>
action="profile" name="user" method="post"
</#macro>
<#macro paged_dashboard_page_body>
<section data-page="0">
    <div class="form-field">
        <br>
        <@spring.bind "user.contact.firstName"/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" id="firstName" name="contact.firstName"
                   <#if spring.status.value??>value="${spring.status.value}"</#if> required>
            <label class="mdl-textfield__label" for="firstName">First Name</label>
        </div>
    </div>
    <div class="form-field">
        <@spring.bind "user.contact.lastName"/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" id="lastName" name="contact.lastName"
                   <#if spring.status.value??>value="${spring.status.value}"</#if> required>
            <label class="mdl-textfield__label" for="lastName">Last Name</label>
        </div>
        <p></p>
    </div>
</section>

<section data-page="1">
    <div class="form-field">
        <br>
        <@spring.bind "user.contact.address"/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" id="address" name="contact.address"
                   <#if spring.status.value??>value="${spring.status.value}"</#if> required>
            <label class="mdl-textfield__label" for="address">Address</label>
        </div>
    </div>
    <div class="form-field">
        <@spring.bind "user.contact.zipcode"/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" id="zipcode" name="contact.zipcode"
                   <#if spring.status.value??>value="${spring.status.value}"</#if> required>
            <label class="mdl-textfield__label" for="zipcode">Zip Code</label>
            <span class="mdl-textfield__error">Input is not a valid zip code!</span>
        </div>
        <p></p>
    </div>
</section>
<section data-page="2">
    <div class="form-field">
        <br/>
        <@spring.bind "user.contact.phone"/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="tel" id="phone" name="contact.phone"
                   pattern="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$" placeholder="(783) 310-456"
                   <#if spring.status.value??>value="${spring.status.value}"</#if> required>
            <label class="mdl-textfield__label" for="phone">Phone Number</label>
            <span class="mdl-textfield__error">Input is not a valid phone number!</span>
        </div>
        <p></p>
    </div>
</section>

</#macro>
<@display_page/>