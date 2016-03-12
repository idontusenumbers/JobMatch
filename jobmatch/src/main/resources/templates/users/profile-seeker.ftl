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
            <input class="mdl-textfield__input" type="text" id="contact.firstName" name="contact.firstName"
                   <#if spring.status.value??>value="${spring.status.value}"</#if>>
            <label class="mdl-textfield__label" for="contact.phone">First Name</label>
        </div>
    </div>
    <div class="form-field">
        <@spring.bind "user.contact.lastName"/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" id="contact.lastName" name="contact.lastName"
                   <#if spring.status.value??>value="${spring.status.value}"</#if>>
            <label class="mdl-textfield__label" for="contact.phone">Last Name</label>
        </div>
        <p></p>
    </div>
</section>

<section data-page="1">
    <div class="form-field">
        <br>
        <@spring.bind "user.contact.address"/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" id="contact.address" name="contact.address"
                   <#if spring.status.value??>value="${spring.status.value}"</#if>>
            <label class="mdl-textfield__label" for="contact.address">Address</label>
        </div>
    </div>
    <div class="form-field">
        <@spring.bind "user.contact.zipcode"/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" id="contact.zipcode" name="contact.zipcode"
                   pattern="^\d{5}([\-]?\d{4})?$"
                   <#if spring.status.value??>value="${spring.status.value}"</#if>>
            <label class="mdl-textfield__label" for="contact.zipcode">Zip Code</label>
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
            <input class="mdl-textfield__input" type="tel" id="contact.phone" name="contact.phone"
                   pattern="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$" placeholder="(783) 310-456"
                   <#if spring.status.value??>value="${spring.status.value}"</#if>>
            <label class="mdl-textfield__label" for="contact.phone">Phone Number</label>
            <span class="mdl-textfield__error">Input is not a valid phone number!</span>
        </div>
        <p></p>
    </div>
</section>

</#macro>
<@display_page/>