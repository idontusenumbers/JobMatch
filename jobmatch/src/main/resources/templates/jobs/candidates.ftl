<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<table id="t1" align="center">
    <tr>
        <th>Candidates matched to</th>
        <th>
            <div id="nobg"><a href="${s.mvcUrl("JC#viewJob").arg(0,jobPost.id).build()}">${jobPost.jobTitle}</a></div>
        </th>
    </tr>
    <ul>
        <#list scoredCandidates as scoredCandidate>
        <tr>
            <td>
                <div id="nobg">
                    <a href="${s.mvcUrl("UC#viewUser").arg(0,scoredCandidate.user.id).build()}">
                        <#if scoredCandidate.user.contact?? && scoredCandidate.user.contact.firstName?has_content >
                            ${scoredCandidate.user.contact.firstName}
                            <#else>
                        ${scoredCandidate.user.username}
                        </#if>
                    </a>
                </div>
            </td>
            <td>Closeness: ${scoredCandidate.closeness}</td>
        <#else>
            No matching candidates
        </tr>
        </#list>
    </ul>
    </tr>
</table>



</#macro>

<@display_page />
