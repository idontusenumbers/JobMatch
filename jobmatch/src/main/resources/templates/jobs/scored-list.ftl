<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<div class="jobs-list">
	<ul class="title-matches-list">

		<#list jobs as scoredJob>
			<#assign jobPost = scoredJob.jobPost />
			<#assign closeness = scoredJob.closeness />
			<li>
				<div class="title"><a href="${s.mvcUrl("JC#viewJob").arg(0,jobPost.id).build()}">${jobPost.jobTitle}</a></div>
				<div class="matches">Closeness: ${closeness}</div>
			</li>
		<#else>
			No matching jobs
		</#list>
	</ul>
</div>
</#macro>

<@display_page />