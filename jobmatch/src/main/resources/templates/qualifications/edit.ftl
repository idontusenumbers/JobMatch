<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>

<form action="${s.mvcUrl("UQC#updateQualifications").arg(0, user.id).build()}" name="user" method="post"
      onsubmit="disableUnchecked({'skills':'skillsRanks'}); disableUnchecked({'cultures':'culturesRanks'});">

    <@spring.bind "user" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric" id="tblQualifications"><h5>Edit Qualifications</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Resume:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <textarea class="mdl-textfield__input" type="text" rows="3" name="resume"
                              id="resume"><#if user.resume??>${user.resume}</#if></textarea>
                    <label class="mdl-textfield__label" for="resume">Resume...</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Skills:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <@rankedChoiceList fieldName="skills" availableChoices=skillOptions chosenChoices=skills />
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Culture:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <@rankedChoiceList fieldName="cultures" availableChoices=cultureOptions chosenChoices=cultures />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button id="show-toast" type="submit"
                        class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button">
                    Save Changes
                </button>
            </td>
        </tr>
    </table>
</form>
<p>

<div id="toast-notification" class="mdl-js-snackbar mdl-snackbar">
    <div class="mdl-snackbar__text"></div>
    <button class="mdl-snackbar__action" type="button"></button>
</div>

</#macro>
<@display_page/>