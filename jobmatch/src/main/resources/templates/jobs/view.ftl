<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <thead>
    <tr>
        <th class="mdl-data-table__cell--non-numeric"><h5>${jobPost.jobTitle}</h5></th>
        <th class="mdl-data-table__cell--non-numeric"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td class="mdl-data-table__cell--non-numeric"><h6>Description:</h6></td>
        <td class="mdl-data-table__cell--non-numeric"><h6>${jobPost.description!''}</h6></td>
    </tr>
    <tr>
        <td class="mdl-data-table__cell--non-numeric"><h6>Location:</h6></td>
        <td class="mdl-data-table__cell--non-numeric"><h6>${jobPost.jobCountry}</h6></td>
    </tr>
    <tr>
        <td class="mdl-data-table__cell--non-numeric"><h6>Industry:</h6></td>
        <td class="mdl-data-table__cell--non-numeric"><h6>${jobPost.industry}</h6></td>
    </tr>
    <tr>
        <td class="mdl-data-table__cell--non-numeric"><h6>Job Type:</h6></td>
        <td class="mdl-data-table__cell--non-numeric"><h6>${jobPost.jobType}</h6></td>
    </tr>
    <tr>
        <td class="mdl-data-table__cell--non-numeric"><h6>Years of Experience:</h6></td>
        <td class="mdl-data-table__cell--non-numeric"><h6>${jobPost.yearsExperience}</h6></td>
    </tr>
    <tr>
        <td class="mdl-data-table__cell--non-numeric"><h6>Skills:</h6></td>
        <td class="mdl-data-table__cell--non-numeric">
            <ol>
                <#list skills.sortedRankables as skillRank>
                    <li><h6 style="margin: 0;">${skillRank.skill.name}</h6></li>
                <#else>
                    No skills
                </#list>
            </ol>
        </td>
    </tr>
<tr>
    <td class="mdl-data-table__cell--non-numeric"><h6>Culture:</h6></td>
    <td class="mdl-data-table__cell--non-numeric">
        <ol>
            <#list cultures.sortedRankables as cultureRank>
                <li><h6>${cultureRank.culture.name}</h6></li>
            <#else>
                <h6>No culture</h6>
            </#list>
        </ol>
    </td>
</tr>
    <#if currentUser.role.name == "Admin" || currentUser.role.name == "Employer">
    <tr>
        <td width="50%">
            <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button"
               href="${s.mvcUrl("JC#deleteJob").arg(0,jobPost.id).build()}">
                Delete
            </a>
        </td>
        <td width="50%">
            <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button"
               href="${s.mvcUrl("JC#updateJob").arg(0,jobPost.id).build()}">
                Edit
            </a>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <div id="nobg" align="center"><a href="${s.mvcUrl("JC#findCandidates").arg(0,jobPost.id).build()}">View candidates</a></div>
        </td>
    </tr>
    </tbody>
    </#if>
</table>

</#macro>

<@display_page />
