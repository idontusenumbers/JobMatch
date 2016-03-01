<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<a href="${s.mvcUrl("JC#viewJob").arg(0,job.id).build()}">
${job.jobTitle}
</a>
<p>Candidates:</p>
<ul>
	<#list candidates as candidate>
        <li><a href="${s.mvcUrl("UC#viewUser").arg(0,job.id).build()}">${candidate.contact.firstName}</a></li>
	<#else>
        No matching candidates
	</#list>
</ul>




</#macro>

<@display_page />
