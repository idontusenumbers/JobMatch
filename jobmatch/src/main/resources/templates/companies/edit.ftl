<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>

<form action="${s.mvcUrl("CC#updateCompany").arg(0, company.id).build()}" name="company" method="post"
      onsubmit="disableUnchecked({'skills':'skillsRanks'}); disableUnchecked({'cultures':'culturesRanks'});">

    <@spring.bind "company" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric">Edit Company</th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Company Name:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "company.name"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="name" name="name" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="name">Example Company</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Phone:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "company.phone"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="tel" id="phone" name="phone"
                           pattern="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="phone">(555) 555-5555</label>
                    <span class="mdl-textfield__error">Input is not a valid phone number!</span>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Address:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "company.address"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="address" name="address" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="address">123 State St.</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Zipcode:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <@spring.bind "company.zipcode"/>
                    <input class="mdl-textfield__input" type="text" id="zipcode" name="zipcode"
                           pattern="^\d{5}([\-]?\d{4})?$" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="zipcode">60614</label>
                    <span class="mdl-textfield__error">Input is not a valid zip code!</span>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Website:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "company.website"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="url" id="website" name="website" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="website">https://www.example.com/</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Culture:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@rankedChoiceList fieldName="cultures" availableChoices=cultureOptions chosenChoices=cultures />
            </td>
        </tr>
        <tr>
            <td colspan="2" class="mdl-data-table__cell--non-numeric">
                <button id="demo-show-toast" type="submit"
                        class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored
                        submit-button">
                    Save Changes
                </button>
            </td>
        </tr>
        </tbody>
    </table>
</form>

</#macro>
<@display_page/>