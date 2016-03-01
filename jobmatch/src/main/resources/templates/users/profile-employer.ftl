<#include "../paged-auth-base.ftl">

<#macro header>PROFILE</#macro>

<#macro form_attributes>
action="profile" name="user" method="post"
</#macro>
<#macro paged_auth_page_body>


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
		<br><@spring.formInput path="user.contact.phone" attributes='class="form-input" placeholder="phone"' />
	</div>
</section>


<section data-page="3">
	<div class="form-field">
		<br><@spring.formInput path="user.company.name" attributes='class="form-input" placeholder="Company Name"' />
	</div>
	<div class="form-field">
		<br><@spring.formInput path="user.company.phone" attributes='class="form-input" placeholder="Company phone"' />
	</div>
	<div class="form-field">
		<br><@spring.formInput path="user.company.address" attributes='class="form-input" placeholder="Company address"' />
	</div>
	<div class="form-field">
		<br><@spring.formInput path="user.company.zipcode" attributes='class="form-input" placeholder="Company zipcode"' />
	</div>
	<div class="form-field">
		<br><@spring.formInput path="user.company.website" attributes='class="form-input" placeholder="Company website"' />
	</div>
</section>

</#macro>
<@display_page/>