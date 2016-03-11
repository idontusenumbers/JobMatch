<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<div class="demo-card-square mdl-card mdl-shadow--2dp">
    <div class="mdl-card__title mdl-card--expand">
        <h2 class="mdl-card__title-text">Update</h2>
    </div>
    <div class="mdl-card__supporting-text">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit.
        Aenan convallis.
    </div>
    <div class="mdl-card__actions mdl-card--border">
        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            View Updates
        </a>
    </div>
</div>

<div class="jobs-list">
    <ul class="title-matches-list">
        <#list jobs as jobPost>
            <li>
                <div class="title" id="bg"><a
                        href="${s.mvcUrl("JC#viewJob").arg(0,jobPost.id).build()}">${jobPost.jobTitle}</a></div>
                <div class="matches">Match: 89%</div>
            </li>
        <#else>
            No jobs to list
        </#list>
    </ul>
</div>
</#macro>

<@display_page />