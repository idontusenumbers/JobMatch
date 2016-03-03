<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<div class="jobs-list">
	<ul class="title-matches-list">

		<#list countedMatches as countedMatch>
			<#assign jobPost = countedMatch.jobPost />
			<#assign count = countedMatch.count />
			<li>
				<div class="title"><a href="${s.mvcUrl("JC#viewJob").arg(0,jobPost.id).build()}">${jobPost.jobTitle}</a></div>
				<div class="matches">Matches: ${count}</div>
			</li>
		<#else>
			No matching jobs
		</#list>
	</ul>
</div>
</#macro>

<@display_page />