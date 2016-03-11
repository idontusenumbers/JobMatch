<#include "../paged-dashboard-base.ftl">

<#macro header>PROFILE</#macro>

<#macro form_attributes>
action="profile" name="user" method="post"
</#macro>
<#macro paged_dashboard_page_body>

<section data-page="0">
	<div class="form-field">
		<br><@spring.formInput path="user.contact.firstName" attributes='class="form-input" placeholder="first Name"' />
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
        <br><@spring.formInput path="user.contact.phone" attributes='class="form-input" placeholder="phone"' fieldType="tel" />
    </div>
</section>

</#macro>
<@display_page/>