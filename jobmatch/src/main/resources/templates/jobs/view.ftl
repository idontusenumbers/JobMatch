<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>


${jobPost.jobTitle}
${jobPost.jobCountry}
${jobPost.industry}
${jobPost.jobType}
${jobPost.yearsExperience}

<p>Skills:</p>
<ul>
	<#list jobPost.skills as skillRank>
        <li>${skillRank.skill.name}: ${skillRank.rank}</li>
	<#else>
        No skills
	</#list>
</ul>
<a class="sidebar-button" href="${s.mvcUrl("JC#deleteJob").arg(0,jobPost.id).build()}">Delete</a>
<a class="sidebar-button" href="${s.mvcUrl("JC#updateJob").arg(0,jobPost.id).build()}">Edit</a>

<a  href="${s.mvcUrl("JC#findCandidates").arg(0,jobPost.id).build()}">View candidates</a>

</#macro>

<@display_page />
