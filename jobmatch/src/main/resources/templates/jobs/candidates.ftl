<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp jm-table">
    <thead>
    <tr>
        <th class="mdl-data-table__cell--non-numeric"><h5>Candidates matched to</h5></th>
        <th class="mdl-data-table__cell--non-numeric"><h5><a
                href="${s.mvcUrl("JC#viewJob").arg(0,jobPost.id).build()}">${jobPost.jobTitle}</a></h5></th>
    </tr>
    </thead>
    <tbody>
    <ul>
        <#list scoredCandidates as scoredCandidate>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <a href="${s.mvcUrl("UC#viewUser").arg(0,scoredCandidate.user.id).build()}">
                    <#if scoredCandidate.user.contact?? && scoredCandidate.user.contact.firstName?has_content >
                    <h6>${scoredCandidate.user.contact.firstName}
                    <#else>
                    ${scoredCandidate.user.username}</h6>
                    </#if>
                </a>
            </td>
            <td>Closeness: ${scoredCandidate.closeness}</td>
        <#else>
            No matching candidates
        </tr>
        </#list>
    </ul>
    </tr>
    </tbody>
</table>

</#macro>

<@display_page />
