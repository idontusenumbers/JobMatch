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
        <h3>Contact</h3>
        <b>Name: </b>
        <#if user.contact?? && ( user.contact.firstName?has_content || user.contact.lastName?has_content)>
        ${user.contact.firstName} ${user.contact.lastName}
        <#else>
        ${user.username}
        </#if><br>
        <#if user.contact??>
            <b>Phone: </b> ${user.contact.phone} <br>
            <b>Address: </b> ${user.contact.address} <br>
            <b>Zip code: </b> ${user.contact.zipcode} <br>
            <#if user.contact.website??>
                <b>Website: </b> ${user.contact.website} <br>
            </#if>
        <#else>
            No contact information found.
        </#if>
    </div>

    <div class="view-job">
        <h3>Ranked Skills & Culture Attributes</h3>
        <table align="center">
            <tr>
                <td>
                    <ol>
                        <#list skills.sortedRankables as skillRank>
                            <li>${skillRank.skill.name}</li>
                        <#else>
                            User hasn't ranked skills.
                        </#list>
                    </ol>
                </td>
                <td>
                    <ol>
                        <#list cultures.sortedRankables as cultureRank>
                            <li>${cultureRank.culture.name}</li>
                        <#else>
                            User hasn't ranked culture.
                        </#list>
                    </ol>
                </td>
            </tr>
        </table>
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
            No education information found.
        </#if>
    </div>

    <div class="view-job">
        <h3>Resume Description</h3>
        <#if user.resume??>
        ${user.resume}
        <#else>
            No resume submitted.
        </#if>
    </div>

    <div class="view-job">
        <h3>Experience</h3>
        <#if user.experiences??>
            <#list user.experiences as exp>
            ${exp.title}
            ${exp.companyName}
            ${exp.companyAddress}
            ${exp.startDate}
            ${exp.endDate}
            ${exp.responsbilities}
            </#list>
        <#else>
            No experience listed.
        </#if>
    </div>

    <div class="view-job">
        <h3>References</h3>
        <#if user.references??>
            <#list user.references as ref>
                <b>Name:</b> ${ref.firstName} ${ref.lastName} <br>
                <b>Title:</b> ${ref.title} <br>
                <b>Company:</b> ${ref.companyName} <br>
                <b>Phone:</b> ${ref.phone} <br><br>
            </#list>
        <#else>
            No references listed.
        </#if>
    </div>
</div>

</#macro>

<@display_page />