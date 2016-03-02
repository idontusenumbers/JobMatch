<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>



<form action="${s.mvcUrl("UC#updateQualifications").arg(0, user.id).build()}" name="user" method="post"
	  onsubmit="disableUnchecked({'skills':'ranks'})">


	<@spring.bind "user" />
	<@spring.showErrors '*', 'errors' />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<@spring.formTextarea path="user.resume" attributes='class="" placeholder="Resume"' />

	<p>Skills:</p>
	<@rankedSkillList availableSkills=skillOptions chosenSkills=skills />

	<p>Culture attributes:</p>

	<p>References:</p>

	<input type="submit" value="Submit">
</form>


</#macro>
<@display_page/>