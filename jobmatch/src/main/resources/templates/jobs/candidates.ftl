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
	<#list scoredCandidates as scoredCandidate>
        <li><a href="${s.mvcUrl("UC#viewUser").arg(0,scoredCandidate.user.id).build()}"><#if scoredCandidate.user.contact?? >${scoredCandidate.user.contact.firstName}<#else>${scoredCandidate.user.username}</#if></a> Closeness: ${scoredCandidate.closeness} </li>
	<#else>
        No matching candidates
	</#list>
</ul>




</#macro>

<@display_page />
