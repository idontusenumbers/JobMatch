<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>

<form action="${s.mvcUrl("UC#updateQualifications").arg(0, user.id).build()}" name="user" method="post"
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


</#macro>
<@display_page/>