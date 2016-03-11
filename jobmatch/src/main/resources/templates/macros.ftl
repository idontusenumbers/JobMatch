<#macro rankedChoiceList fieldName availableChoices, chosenChoices>

    <#assign i = 0 />
    <ul class="checkbox-list">
        <#list availableChoices?keys as choice>
            <li>

                <label for="${fieldName}-${i}" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                    <input id="${fieldName}-${i}" type="checkbox" name="${fieldName}" value="${choice}"
                           class="mdl-checkbox__input"
                           <#if chosenChoices?? && chosenChoices.contains(choice)>checked</#if>/>
                    <span class="mdl-checkbox__label">${availableChoices[choice]}</span>
                </label>

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

<#macro import_js>
<script type="text/javascript" src="/static/js/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="/static/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/static/js/material.min.js"></script>
<script type="text/javascript" src="/static/js/main.js"></script>
</#macro>