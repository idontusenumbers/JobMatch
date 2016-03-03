<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>

${company.name}
${company.phone}
${company.address}
${company.zipcode}
${company.website}

<p>Culture attributes:</p>
<ul>
	<#list company.cultures as cultureRank>
        <li>${cultureRank.culture.name}: ${cultureRank.rank}</li>
	<#else>
        No culture attributes
	</#list>
</ul>


</#macro>
<@display_page/>