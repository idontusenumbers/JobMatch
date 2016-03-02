<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>



<form action="${s.mvcUrl("UC#updateQualifications").arg(0, user.id).build()}" name="user" method="post"
	  onsubmit="disableUnchecked({'skills':'skillsRanks'}); disableUnchecked({'cultures':'culturesRanks'});">


	<@spring.bind "user" />
	<@spring.showErrors '*', 'errors' />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<@spring.formTextarea path="user.resume" attributes='class="" placeholder="Resume"' />

	<p>Skills:</p>
	<@rankedChoiceList fieldName="skills" availableChoices=skillOptions chosenChoices=skills />

	<p>Culture attributes:</p>
	<@rankedChoiceList fieldName="cultures" availableChoices=cultureOptions chosenChoices=cultures />

	<p>References:</p>

	<input type="submit" value="Submit">
</form>


</#macro>
<@display_page/>