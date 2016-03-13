<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>

<table id="t1" align="center">
    <tr>
        <!-- TODO link to company page-->
        <th colspan="2">${company.name}</th>
    </tr>
    <tr>
        <td><h2>Phone:</h2></td>
        <td>${company.phone}</td>
    </tr>
    <tr>
        <td><h2>Address:</h2></td>
        <td>${company.address}</td>
    </tr>
    <tr>
        <td><h2>Zip Code:</h2></td>
        <td>${company.zipcode}</td>
    </tr>
    <tr>
        <td><h2>Website:</h2></td>
        <td>${company.website}</td>
    </tr>
    <tr>
        <td><h2>Culture:</h2></td>
        <td>
            <ul>
                <#list company.cultures as cultureRank>
                    <li>${cultureRank.culture.name}: ${cultureRank.rank}</li>
                <#else>
                    No culture attributes
                </#list>
            </ul>
        </td>
    </tr>
</table>

</#macro>
<@display_page/>