<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>
<div class="mdl-grid">
    <#list countedMatches as countedMatch>
        <#assign jobPost = countedMatch.jobPost />
        <#assign count = countedMatch.count />
        <div class="mdl-cell mdl-cell--6-col col-centered" style="margin-bottom: 20px;">
            <div class="mdl-card-wide mdl-card mdl-shadow--2dp">
                <div class="mdl-card__title">
                    <h2 class="mdl-card__title-text">${jobPost.jobTitle}</h2>
                </div>
                <div class="mdl-card__supporting-text">
                ${jobPost.description}
                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                       href="${s.mvcUrl("JC#viewJob").arg(0,jobPost.id).build()}">
                        View Job
                    </a>
                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                       href="${s.mvcUrl("JC#findCandidates").arg(0,jobPost.id).build()}">
                        View Candidates
                    </a>
                </div>
                <div class="mdl-card__menu">
                    <div id="candidates-${jobPost.id}" class="material-icons mdl-badge mdl-badge--overlap"
                         data-badge="${count}">people
                    </div>
                </div>
            </div>
        </div>
        <div class="mdl-tooltip mdl-tooltip--large" for="candidates-${jobPost.id}">
            Candidates
        </div>
    <#else>
        No matching jobs
    </#list>
</div>
</#macro>

<@display_page />