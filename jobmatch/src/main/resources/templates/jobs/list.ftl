<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<div class="jobs-list">
	<ul class="title-matches-list">

		<#list jobs as job>
			<li>
				<div class="title"><a href="${s.mvcUrl("JC#viewJob").arg(0,job.id).build()}">${job.jobTitle}</a></div>
				<div class="matches">Match: 89%</div>
			</li>
		<#else>
			No jobs to list
		</#list>
	</ul>
</div>
</#macro>

<@display_page />