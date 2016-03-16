<#include "../dashboard-base.ftl">

<#macro header>EDUCATION</#macro>

<#macro dashboard_body>
<table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <thead>
    <tr>
        <th class="mdl-data-table__cell--non-numeric"><h5>Education</h5></th>
        <th class="mdl-data-table__cell--non-numeric">
            <button id="addEducationToggle"
                    class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored"
                    style="float: right;">
                <i class="material-icons">add</i>
            </button>
        </th>
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
<form action="${s.mvcUrl("EC#addEducation").arg(0, currentUser.id).build()}" name="education" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" id="tAddEducation" align="center">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric"><h5>Add Education</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>School Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="schoolName" name="schoolName" required>
                    <label class="mdl-textfield__label" for="schoolName">DePaul University</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Country:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select">
                    <input class="mdl-textfield__input" type="text" id="country" name="country" value="United States"
                           readonly tabIndex="-1">
                    <label for="country">
                        <i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
                    </label>
                    <ul for="country" class="mdl-menu mdl-menu--bottom-left mdl-js-menu"
                        style="height: 200px; overflow: auto;">
                        <#list countries as country>
                            <li class="mdl-menu__item">${country}</li>
                        </#list>
                    </ul>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Degree:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="degree" name="degree" required>
                    <label class="mdl-textfield__label" for="degree">Bachelor of Science</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Major:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="major" name="major" required>
                    <label class="mdl-textfield__label" for="major">Computer Science</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Year Graduated:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="number" id="yearGraduated" name="yearGraduated"
                           required>
                    <label class="mdl-textfield__label" for="yearGraduated">2016</label>
                </div>
            </td>
        </tr>
        </tbody>
        <tr>
            <td colspan="2">
                <button type="submit"
                        class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button">
                    Add Education
                </button>
            </td>
        </tr>
    </table>
</form>
<p></p>
</#macro>
<#macro page_body_footer>
<script type="text/javascript" src="/static/js/education.js" defer></script>
</#macro>
<@display_page/>