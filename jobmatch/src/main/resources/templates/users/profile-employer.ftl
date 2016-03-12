<#include "../paged-dashboard-base.ftl">

<#macro header>PROFILE</#macro>

<#macro form_attributes>
action="profile" name="user" method="post"
</#macro>
<#macro paged_dashboard_page_body>

    <@spring.bind "user.contact.firstName" />
<section data-page="0">
	<div class="form-field">
        <br/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" id="contact.firstName" name="contact.firstName"
                   <#if spring.status.value??>value="${spring.status.value}"</#if>>
            <label class="mdl-textfield__label" for="contact.phone">First Name</label>
        </div>
	</div>
	<div class="form-field">
		<@spring.formInput path="user.contact.lastName" attributes='class="form-input" placeholder="last Name"' />
	</div>
</section>

<section data-page="1">
	<div class="form-field">
		<br><@spring.formInput path="user.contact.address" attributes='class="form-input" placeholder="address"' />
	</div>
	<div class="form-field">
		<@spring.formInput path="user.contact.zipcode" attributes='class="form-input" placeholder="zipcode"' />
	</div>
</section>
<section data-page="2">
	<div class="form-field">
		<br><@spring.formInput path="user.contact.phone" attributes='class="form-input" placeholder="phone"' />
	</div>
</section>

</#macro>
<@display_page/>