<#include "../dashboard-base.ftl">

<#macro header>REFERENCE</#macro>

<#macro dashboard_body>
<form action="${s.mvcUrl("RC#updateReference").arg(0, user.id).arg(1, reference.id).build()}" method="post"
      name="reference">
    <@spring.bind "reference"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric"><h5>Reference</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>First Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="firstName" name="firstName" required
                           value="${reference.firstName!}">
                    <label class="mdl-textfield__label" for="firstName">John</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Last Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="lastName" name="lastName" required
                           value="${reference.lastName!}">
                    <label class="mdl-textfield__label" for="lastName">Doe</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Title:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="title" name="title" required
                           value="${reference.title!}">
                    <label class="mdl-textfield__label" for="title">CTO</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Company Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="companyName" name="companyName" required
                           value="${reference.companyName!}">
                    <label class="mdl-textfield__label" for="companyName">John Doe, LLC</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Phone:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="tel" id="phone" name="phone" required
                           value="${reference.phone!}">
                    <label class="mdl-textfield__label" for="phone">(783) 310-456</label>
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