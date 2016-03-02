<#macro rankedChoiceList fieldName availableChoices, chosenChoices>

	<#assign i = 0 />
	<#list availableChoices?keys as choice>
		<input id="${fieldName}-${i}" type="checkbox" name="${fieldName}" value="${choice}"
			   <#if chosenChoices?? && chosenChoices?keys?seq_contains(choice)>checked</#if>/>

		<label for="${fieldName}-${i}">${availableChoices[choice]}</label>
		<input type="text" name="${fieldName}Ranks" value="<#if chosenChoices?? && chosenChoices?keys?seq_contains(choice)>${chosenChoices[choice]}<#else>0</#if>" />
		<br/>
		<#assign i = i + 1 />
	</#list>
</#macro>