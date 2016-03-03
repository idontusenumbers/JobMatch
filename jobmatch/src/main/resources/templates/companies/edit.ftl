<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>

<form action="${s.mvcUrl("CC#updateCompany").arg(0, company.id).build()}" name="user" method="post"
      onsubmit="disableUnchecked({'skills':'skillsRanks'}); disableUnchecked({'cultures':'culturesRanks'});">

    <@spring.bind "company" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table id="t1" align="center">
        <tr>
            <th colspan="2">Edit Company</th>
        </tr>
        <tr>
            <td><h2>Company Name:</h2></td>
            <td><@spring.formInput path="company.name" attributes='class="form-input" placeholder="Company Name"' /></td>
        </tr>
        <tr>
            <td><h2>Phone:</h2></td>
            <td><@spring.formInput path="company.phone" attributes='class="form-input" placeholder="Company phone"' /></td>
        </tr>
        <tr>
            <td><h2>Address:</h2></td>
            <td><@spring.formInput path="company.address" attributes='class="form-input" placeholder="Company address"' /></td>
        </tr>
        <tr>
            <td><h2>Phone:</h2></td>
            <td><@spring.formInput path="company.zipcode" attributes='class="form-input" placeholder="Company zipcode"' /></td>
        </tr>
        <tr>
            <td><h2>Website:</h2></td>
            <td><@spring.formInput path="company.website" attributes='class="form-input" placeholder="Company website"' /></td>
        </tr>
        <tr>
            <td><h2>Culture:</h2></td>
            <td><@rankedChoiceList fieldName="cultures" availableChoices=cultureOptions chosenChoices=cultures /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" class="sidebar-button"></td>
        </tr>
    </table
</form>

</#macro>
<@display_page/>