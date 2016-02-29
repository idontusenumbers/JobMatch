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

<a class="sidebar-button" href="${s.mvcUrl("JC#deleteJob").arg(0,job.id).build()}">Delete</a>
<a class="sidebar-button" href="${s.mvcUrl("JC#updateJob").arg(0,job.id).build()}">Edit</a>
//Charlie this view candidate button is supposed to go to the view-candidate page
<a class="sidebar-button" href="${s.mvcUrl("JC#updateJob").arg(0,job.id).build()}">View Candidates</a>

</#macro>

<@display_page />