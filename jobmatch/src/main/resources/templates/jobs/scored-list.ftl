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
                <div id="bg" class="title"><a
                        href="${s.mvcUrl("JC#viewJob").arg(0,jobPost.id).build()}">${jobPost.jobTitle}</a>
                    <div class="mdl-tooltip mdl-tooltip--large" for="favorite-${jobPost.id}">
                        Favorite
                    </div>
                    <a href="#" id="${jobPost.id}" onclick="setFavorite(this)" data-job-post-id="${jobPost.id}"
                       data-favorite="${faves?seq_contains(jobPost.id?string)?string("true", "false")}">
                    ${faves?seq_contains(jobPost.id?string)?string('<i id="favorite-' + jobPost.id + '" class="icon material-icons">favorite</i>', '<i id="favorite-' + jobPost.id + '" class="icon material-icons">favorite_border</i>')}
                    </a>
                </div>
                <div class="matches">Closeness: ${closeness}</div>
            </li>
        <#else>
            No matching jobs
        </#list>
    </ul>
</div>
</#macro>

<@display_page />