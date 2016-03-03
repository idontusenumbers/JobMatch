<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<table style="width:50%" align="center" cellpadding="5px">
    <tr>
        <td><h1>${jobPost.jobTitle}</h1></td>
    </tr>
    <tr>
        <td><h2>Location:</h2></td>
        <td>${jobPost.jobCountry}</td>
		</tr>
	<tr>
        <td><h2>Industry:</h2></td>
        <td>${jobPost.industry}</td>
		</tr>
	<tr>
        <td><h2>Job Type:</h2></td>
        <td>${jobPost.jobType}</td>
		</tr>
	<tr>
        <td><h2>Years of Experience:</h2></td>
        <td>${jobPost.yearsExperience}</td>
    </tr>
    <tr>
        <td><h2>Skills:</h2></td>
        <td><ul>
			<#list jobPost.skills as skillRank>
                <li>${skillRank.skill.name}: ${skillRank.rank}</li>
			<#else>
                No skills
			</#list>
        </ul></td>
    </tr>
    <tr>
        <td><a class="sidebar-button" href="${s.mvcUrl("JC#deleteJob").arg(0,jobPost.id).build()}">Delete</a> </td>
        <td><a class="sidebar-button" href="${s.mvcUrl("JC#updateJob").arg(0,jobPost.id).build()}">Edit</a></td>
    </tr>
	<tr>
		<td><a  href="${s.mvcUrl("JC#findCandidates").arg(0,jobPost.id).build()}">View candidates</a></td>
	</tr>
</table>

</#macro>

<@display_page />
