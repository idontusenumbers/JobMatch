<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>


${job.jobTitle}
${job.jobCountry}
${job.industry}
${job.jobType}
${job.yearsExperience}

<a class="sidebar-button" href="${s.mvcUrl("JC#updateJob").arg(0,job.id).build()}">Edit</a>

</#macro>

<@display_page />