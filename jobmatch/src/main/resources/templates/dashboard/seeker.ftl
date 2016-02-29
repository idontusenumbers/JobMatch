<#include "dashboard-base.ftl">

<#macro dashboard_nav>
employer nav
</#macro>
<#macro dashboard_body>

<div class="jobs-list">
	<ul class="title-matches-list">
		<li>
			<div class="title">Job Title</div>
			<div class="matches">Match: 89%</div>
		</li>
		<li>
			<div class="title">Job Title</div>
			<div class="matches">Match: 80%</div>
		</li>
	</ul>
</div>
</#macro>

<@display_page />