<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>
<div class="mdl-grid">
    <#list jobs as scoredJob>
        <div class="mdl-cell mdl-cell--6-col col-centered" style="margin-bottom: 20px;">
            <#assign jobPost = scoredJob.jobPost />
            <#assign closeness = scoredJob.closeness />
            <div class="mdl-card-wide mdl-card mdl-shadow--2dp">
                <div class="mdl-card__title">
                    <h2 class="mdl-card__title-text">${jobPost.jobTitle}</h2>
                </div>
                <div class="mdl-card__supporting-text">Country: ${jobPost.jobCountry}</div>
                <div class="mdl-card__supporting-text">Industry: ${jobPost.industry}</div>
                <div class="mdl-card__supporting-text">Type: ${jobPost.jobType}</div>
                <div class="mdl-card__actions mdl-card--border">
                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                       href="${s.mvcUrl("JC#viewJob").arg(0,jobPost.id).build()}">
                        View Job
                    </a>
                    <span class="mdl-badge" data-badge="${closeness}">Closeness</span>

                </div>
                <div class="mdl-card__menu">
                    <button class="fav-toggle mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect"
                            data-favorite="${faves?seq_contains(jobPost.id?string)?string("true", "false")}"
                            data-job-post-id="${jobPost.id}"
                            id="favorite-${jobPost.id}">
                    ${faves?seq_contains(jobPost.id?string)?string('<i class="icon material-icons">favorite</i>', '<i class="icon material-icons">favorite_border</i>')}
                    </button>
                </div>
            </div>
            <div class="mdl-tooltip mdl-tooltip--large" for="favorite-${jobPost.id}">
                Favorite
            </div>
        </div>
    <#else>
        ${noJobsMessage}
    </#list>
</div>
</#macro>

<@display_page />