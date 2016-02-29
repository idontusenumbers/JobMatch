<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>





<form action="${s.mvcUrl("JC#createJobPost").build()}" name="job" method="post">
	<@spring.bind "job" />
	<@spring.showErrors '*', 'errors' />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<@spring.formInput path="job.jobTitle" attributes='class="form-input" placeholder="Job Title"' />
	<@spring.formInput path="job.jobCountry" attributes='class="form-input" placeholder="Country"' />
	<@spring.formInput path="job.industry" attributes='class="form-input" placeholder="industry"' />
	<@spring.formInput path="job.jobType" attributes='class="form-input" placeholder="jobType"' />
	<@spring.formInput path="job.yearsExperience" attributes='class="form-input" placeholder="yearsExperience"' />
	<input type="submit" value="Submit">
</form>

</#macro>

<@display_page />