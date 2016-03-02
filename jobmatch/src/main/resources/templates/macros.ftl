<#macro rankedSkillList availableSkills, chosenSkills>

	<#assign i = 0 />
	<#list availableSkills?keys as skill>
		<input id="skills${i}" type="checkbox" name="skills" value="${skill}"
			   <#if chosenSkills?? && chosenSkills?keys?seq_contains(skill)>checked</#if>/>

		<label for="skills${i}">${availableSkills[skill]}</label>
		<input type="text" name="ranks" value="<#if chosenSkills?? && chosenSkills?keys?seq_contains(skill)>${chosenSkills[skill]}<#else>0</#if>" />
		<br/>
		<#assign i = i + 1 />
	</#list>
</#macro>