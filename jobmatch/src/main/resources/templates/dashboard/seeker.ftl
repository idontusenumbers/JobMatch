<#include "dashboard-base.ftl">

<#macro dashboard_nav>
	<li><a href="#">Jobs</a></li>
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