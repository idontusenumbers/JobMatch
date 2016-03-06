<#macro rankedChoiceList fieldName availableChoices, chosenChoices>

    <#assign i = 0 />
    <ul class="checkbox-list">
        <#list availableChoices?keys as choice>
            <li><input id="${fieldName}-${i}" type="checkbox" name="${fieldName}" value="${choice}"
                       <#if chosenChoices?? && chosenChoices.contains(choice)>checked</#if>/>

                <label for="${fieldName}-${i}">${availableChoices[choice]}</label>

                <input type="hidden" class="rank" name="${fieldName}Ranks" data-choice="${choice}"
                       value="<#if chosenChoices?? && chosenChoices.contains(choice)>${chosenChoices.getRank(choice)}</#if>"/>
            </li>
            <#assign i = i + 1 />
        </#list>
    </ul>

    <ol id="${fieldName}-sort" class="sortable-list" data-field="${fieldName}">
        <#list chosenChoices.sortedRankables as choice>
            <li class="skill-culture-item" data-choice="${choice.rankedId}">
            ${choice.rankedName}
            </li>
        </#list>
    </ol>


</#macro>