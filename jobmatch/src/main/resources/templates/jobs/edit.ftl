<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>



<#macro dashboard_body>

	<#assign action =(jobPost.id!=0)?then(
	(s.mvcUrl("JC#updateJobPost").arg(0, jobPost.id).build()),
	(s.mvcUrl("JC#createJobPost").build())
	)
	/>

<form action="${action}" name="jobPost" method="post" onsubmit="disableUnchecked({'skills':'skillsRanks'})">


	<@spring.bind "jobPost" />
	<@spring.showErrors '*', 'errors' />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<@spring.formInput path="jobPost.jobTitle" attributes='class="form-input" placeholder="Job Title"' />
	<@spring.formInput path="jobPost.jobCountry" attributes='class="form-input" placeholder="Country"' />
	<@spring.formInput path="jobPost.industry" attributes='class="form-input" placeholder="industry"' />
	<@spring.formInput path="jobPost.jobType" attributes='class="form-input" placeholder="jobType"' />
	<@spring.formInput path="jobPost.yearsExperience" attributes='class="form-input" placeholder="yearsExperience"' />


	<p>Skills:</p>
	<@rankedChoiceList fieldName="skills" availableChoices=skillOptions chosenChoices=skills />

	<input type="submit" value="Submit">
</form>

</#macro>

<@display_page />