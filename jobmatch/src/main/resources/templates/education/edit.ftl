<#include "../dashboard-base.ftl">

<#macro header>EDUCATION</#macro>

<#macro dashboard_body>
<form action="${s.mvcUrl("EC#updateEducation").arg(0, user.id).arg(1, education.id).build()}" method="post"
      name="education">
    <@spring.bind "education"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp jm-table">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric"><h5>Education</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>School Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="schoolName" name="schoolName" required
                           <#if education.schoolName??>value="${education.schoolName}" </#if>>
                    <label class="mdl-textfield__label" for="schoolName">DePaul University</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Country:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select">
                    <input class="mdl-textfield__input" type="text" id="country" name="country"
                           value="${education.country!}"
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
                    <input class="mdl-textfield__input" type="text" id="degree" name="degree" required
                           <#if education.degree??>value="${education.degree}" </#if>>
                    <label class="mdl-textfield__label" for="degree">Bachelor of Science</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Major:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="major" name="major" required
                           <#if education.major??>value="${education.major}" </#if>>
                    <label class="mdl-textfield__label" for="major">Computer Science</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Year Graduated:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="number" id="yearGraduated" name="yearGraduated"
                           required <#if education.yearGraduated??>value="${education.yearGraduated}" </#if>>
                    <label class="mdl-textfield__label" for="yearGraduated">2016</label>
                </div>
            </td>
        </tr>
        <th colspan="2">
            <button type="submit"
                    class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button">
                Save
            </button>
        </th>
        </tbody>
    </table>
</form>
<br/>
</#macro>
<@display_page/>