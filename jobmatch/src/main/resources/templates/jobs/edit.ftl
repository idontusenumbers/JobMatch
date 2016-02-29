<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

	<#assign action =(job.id!=0)?then(
	(s.mvcUrl("JC#updateJobPost").arg(0, job.id).build()),
	(s.mvcUrl("JC#createJobPost").build())
	)
	/>

<form action="${action}" name="job" method="post">


	<@spring.bind "job" />
	<@spring.showErrors '*', 'errors' />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<@spring.formInput path="job.jobTitle" attributes='class="form-input" placeholder="Job Title"' />
	<@spring.formInput path="job.jobCountry" attributes='class="form-input" placeholder="Country"' />
	<@spring.formInput path="job.industry" attributes='class="form-input" placeholder="industry"' />
	<@spring.formInput path="job.jobType" attributes='class="form-input" placeholder="jobType"' />
	<@spring.formInput path="job.yearsExperience" attributes='class="form-input" placeholder="yearsExperience"' />


	<p>Skills:</p>
	<#assign i = 0 />
	<#list skillOptions?keys as skill>
		<input id="skills${i}" type="checkbox" name="skills" value="${skill}"
			   <#if job.skills?seq_contains(skill)>checked</#if>/>

		<label for="skills${i}">${skillOptions[skill]}</label>
		<input type="text" name="ranks" value="${i}">
		<br/>
		<#assign i = i + 1 />
	</#list>

	<input type="submit" value="Submit">
</form>

</#macro>

<@display_page />