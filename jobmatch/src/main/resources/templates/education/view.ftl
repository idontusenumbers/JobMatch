<#include "../dashboard-base.ftl">

<#macro header>EDUCATION</#macro>

<#macro dashboard_body>
<table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <thead>
    <tr>
        <th class="mdl-data-table__cell--non-numeric"><h5>Education</h5></th>
        <th class="mdl-data-table__cell--non-numeric"></th>
    </tr>
    </thead>
    <tbody>
        <#list educationList as education>
        <tr id="education-${education.id}">
            <td class="mdl-data-table__cell--non-numeric"><h6>School Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric"><h6>${education.schoolName}</h6></td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Country:</h6></td>
            <td class="mdl-data-table__cell--non-numeric"><h6>${education.country}</h6></td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Degree:</h6></td>
            <td class="mdl-data-table__cell--non-numeric"><h6>${education.degree}</h6></td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Major:</h6></td>
            <td class="mdl-data-table__cell--non-numeric"><h6>${education.major}</h6></td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Year Graduated:</h6></td>
            <td class="mdl-data-table__cell--non-numeric"><h6>${education.yearGraduated}</h6></td>
        </tr>
        <th colspan="2">
            <a href="${s.mvcUrl("EC#editEducation").arg(0,currentUser.id).arg(1, education.id).build()}"
               class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-button--raised mdl-js-ripple-effect white-font-button">
                Edit
            </a>
            <a id="delete-${education.id}"
               href="${s.mvcUrl("EC#deleteEducation").arg(0, currentUser.id).arg(1, education.id).build()}"
               class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect white-font-button">
                Delete
            </a>
        </th>
        </#list>
    </tbody>
</table>
<br/>
</#macro>
<@display_page/>