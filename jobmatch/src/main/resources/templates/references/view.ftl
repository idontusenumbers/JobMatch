<#include "../dashboard-base.ftl">

<#macro header>REFERENCE</#macro>

<#macro dashboard_body>
<table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <thead>
    <tr>
        <th class="mdl-data-table__cell--non-numeric"><h5>References</h5></th>
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
        <#list referenceList as reference>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>First Name:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>${reference.firstName}</h6>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Last Name:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>${reference.lastName}</h6>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Title:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>${reference.title}</h6>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Company Name:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
            ${reference.companyName}
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Phone:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>${reference.phone}</h6>
            </td>
        </tr>
        <th colspan="2">
            <a href="${s.mvcUrl("RC#editReference").arg(0,currentUser.id).arg(1, reference.id).build()}"
               class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-button--raised mdl-js-ripple-effect white-font-button">
                Edit
            </a>
            <a id="delete-${reference.id}"
               href="${s.mvcUrl("RC#deleteReference").arg(0, currentUser.id).arg(1, reference.id).build()}"
               class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect white-font-button">
                Delete
            </a>
        </th>
        </#list>
    </tbody>
</table>
<br/>
<form action="${s.mvcUrl("RC#addReference").arg(0, currentUser.id).build()}" name="reference" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" id="tAddEducation" align="center">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric"><h5>Add Reference</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>First Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="firstName" name="firstName" required>
                    <label class="mdl-textfield__label" for="firstName">John</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Last Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="lastName" name="lastName" required>
                    <label class="mdl-textfield__label" for="lastName">Doe</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Title:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="title" name="title" required>
                    <label class="mdl-textfield__label" for="title">CTO</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Company Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="companyName" name="companyName" required>
                    <label class="mdl-textfield__label" for="companyName">John Doe, LLC</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Phone:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="tel" id="phone" name="phone" required>
                    <label class="mdl-textfield__label" for="phone">(783) 310-456</label>
                </div>
            </td>
        </tr>
        </tbody>
        <tr>
            <td colspan="2">
                <button type="submit"
                        class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button">
                    Add Reference
                </button>
            </td>
        </tr>
    </table>
</form>
<p></p>
</#macro>
<#macro page_body_footer>
<script type="text/javascript" src="/static/js/education.js"></script>
</#macro>
<@display_page/>