<#include "../../base.ftl">


<#macro page_body>
<h1>Users</h1>
<ul>
	<#list users as user>
		<li>
		${user.toString()}
			<a href="${s.mvcUrl("UC#delete").arg(0,user.id).build()}">delete</a>
		</li>
	</#list>
</ul>
</#macro>
<@display_page />