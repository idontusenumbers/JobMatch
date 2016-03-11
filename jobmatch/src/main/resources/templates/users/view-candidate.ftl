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
        <h3>Education</h3>
        <#if user.education??>
            <#list user.education as edu>
                <b>Name:</b> ${edu.schoolName} <br>
                <b>Country:</b> ${edu.country} <br>
                <b>Degree:</b> ${edu.degree} <br>
                <b>Country:</b> ${edu.country} <br>
                <b>Degree:</b> ${edu.degree} <br>
                <b>Major:</b> ${edu.major} <br>
                <b>Year Graduated:</b> ${edu.yearGraduated} <br>
            </#list>
        <#else>
            No education listed.
        </#if>
    </div>
    <div class="view-job">
        <h3>Experience</h3>
        <#if user.experience?? && ( user.experience.title?has_content)>
            <#list experiences as experience>
            ${user.experiences}
            </#list>
        <#else>
            <font color="red">this section needs to be fixed, yo</font>
        </#if>
    </div>
    <div class="view-job">
        <h3>Contact Info</h3>
        <#if user.contact??>
            <b>Phone: </b> ${user.contact.phone} <br>
            <b>Address: </b> ${user.contact.address} <br>
            <b>Zip code: </b> ${user.contact.zipcode} <br>
            <b>Website: </b>
            <#if user.contact.website??>
            ${user.contact.website} <br>
            <#else>
                n/a
            </#if>
        <#else>
            No contact information found.
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