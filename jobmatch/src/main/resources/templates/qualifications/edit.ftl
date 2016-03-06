<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>

<form action="${s.mvcUrl("UQC#updateQualifications").arg(0, user.id).build()}" name="user" method="post"
      onsubmit="disableUnchecked({'skills':'skillsRanks'}); disableUnchecked({'cultures':'culturesRanks'});">

    <@spring.bind "user" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table id="t1" align="center">
        <tr>
            <th colspan="2">Edit Qualifications</th>
        </tr>
        <tr>
            <td><h2>Resume:</h2></td>
            <td><@spring.formTextarea path="user.resume" attributes='class="" placeholder="Resume"' /></td>
        </tr>
        <tr>
            <td><h2>Skills:</h2></td>
            <td><@rankedChoiceList fieldName="skills" availableChoices=skillOptions chosenChoices=skills /></td>
        </tr>
        <tr>
            <td><h2>Culture:</h2></td>
            <td><@rankedChoiceList fieldName="cultures" availableChoices=cultureOptions chosenChoices=cultures /></td>
        </tr>
        <tr>
            <td><h2>References:</h2></td>
            <td>need to do</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" class="sidebar-button"></td>
        </tr>
    </table>
</form>
<br>
<br>
<table id="t1" align="center">
    <tr>
        <th colspan="2">Education</th>
    </tr>
    <#list educationList as education>
        <tr>
            <td><h2>School Name:</h2></td>
            <td>${education.schoolName}</td>
        </tr>
        <tr>
            <td><h2>Country:</h2></td>
            <td>${education.country}</td>
        </tr>
        <tr>
            <td><h2>Degree:</h2></td>
            <td>${education.degree}</td>
        </tr>
        <tr>
            <td><h2>Major:</h2></td>
            <td>${education.major}</td>
        </tr>
        <tr>
            <td><h2>Year Graduated:</h2></td>
            <td>${education.yearGraduated}</td>
        </tr>
    <th colspan="2"></th>
    </#list>
</table>
<br>
<br>
<form action="${s.mvcUrl("UQC#addEducation").arg(0, user.id).build()}" name="education" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table id="t1" align="center">
        <tr>
            <th colspan="2">Add an Education</th>
        </tr>
        <tr>
            <td><h2>School Name:</h2></td>
            <td><@spring.formInput path="education.schoolName" attributes='class="" placeholder="School Name"' /></td>
        </tr>
        <tr>
            <td><h2>Country:</h2></td>
            <td><@spring.formInput path="education.country" attributes='class="" placeholder="Country"' /></td>
        </tr>
        <tr>
            <td><h2>Degree:</h2></td>
            <td><@spring.formInput path="education.degree" attributes='class="" placeholder="Degree"' /></td>
        </tr>
        <tr>
            <td><h2>Major:</h2></td>
            <td><@spring.formInput path="education.major" attributes='class="" placeholder="Major"' /></td>
        </tr>
        <tr>
            <td><h2>Year Graduated:</h2></td>
            <td><@spring.formInput path="education.yearGraduated" attributes='class="" placeholder="Year Graduated"' /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" class="sidebar-button"/></td>
        </tr>
    </table>
</form>

</#macro>
<@display_page/>