<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>

<div id="job-post">
    <div class="view-job">
        <h2>Candidate</h2>
    </div>
    <div class="view-job">
        <h3>Name</h3>
        <#if user.contact?? && ( user.contact.firstName?has_content || user.contact.lastName?has_content)>
        ${user.contact.firstName} ${user.contact.lastName}
        <#else>
        ${user.username}
        </#if>
    </div>
    <div class="view-job">
        <h3>Experience</h3>
        <#if user.experience?? && ( user.experience.title?has_content)>
            <#list experiences as experience>
            ${user.experiences}
            </#list>
        <#else>
            No experience listed.
        </#if>
    </div>
    <div class="view-job">
        <h3>Contact Info</h3>
        <#if user.contact?? && ( user.contact.contact?has_content)>
        ${user.contact}
        <#else>
            No contact information has been provided.
        </#if>
    </div>
    <div class="view-job">
        <h3>Skills & Culture</h3>
        <div style="float:left">
            <ol>
                <#list skills.sortedRankables as skillRank>
                    <li>${skillRank.skill.name}</li>
                <#else>
                    User hasn't ranked skills.
                </#list>
            </ol>
        </div>

        <div style="float:right">
            <ol>
                <#list cultures.sortedRankables as cultureRank>
                    <li>${cultureRank.culture.name}</li>
                <#else>
                    User hasn't ranked culture.
                </#list>
            </ol>
        </div>
    </div>


</div>

</#macro>

<@display_page />