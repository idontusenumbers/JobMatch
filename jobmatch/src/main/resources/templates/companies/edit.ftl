<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>



<form action="${s.mvcUrl("CC#updateCompany").arg(0, company.id).build()}" name="user" method="post"
	  onsubmit="disableUnchecked({'skills':'skillsRanks'}); disableUnchecked({'cultures':'culturesRanks'});">


	<@spring.bind "company" />
	<@spring.showErrors '*', 'errors' />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<p>Company:</p>
	<div class="form-field">
		<br><@spring.formInput path="company.name" attributes='class="form-input" placeholder="Company Name"' />
	</div>
	<div class="form-field">
		<br><@spring.formInput path="company.phone" attributes='class="form-input" placeholder="Company phone"' />
	</div>
	<div class="form-field">
		<br><@spring.formInput path="company.address" attributes='class="form-input" placeholder="Company address"' />
	</div>
	<div class="form-field">
		<br><@spring.formInput path="company.zipcode" attributes='class="form-input" placeholder="Company zipcode"' />
	</div>
	<div class="form-field">
		<br><@spring.formInput path="company.website" attributes='class="form-input" placeholder="Company website"' />
	</div>

	<p>Culture attributes:</p>
	<@rankedChoiceList fieldName="cultures" availableChoices=cultureOptions chosenChoices=cultures />


	<input type="submit" value="Submit">
</form>


</#macro>
<@display_page/>