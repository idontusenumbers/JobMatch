<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>

<#macro dashboard_body>

    <#assign action =(jobPost.id!=0)?then(
    (s.mvcUrl("JC#updateJobPost").arg(0, jobPost.id).build()),
    (s.mvcUrl("JC#createJobPost").build())
    )
    />

<form action="${action}" name="jobPost" method="post" onsubmit="disableUnchecked({'skills':'skillsRanks'})">

    <@spring.bind "jobPost" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric"><h5>Post a Job</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Job Title:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "jobPost.jobTitle"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="jobTitle" name="jobTitle" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="jobTitle">Job Title</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Description:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "jobPost.description"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <textarea class="mdl-textfield__input" type="text" rows="3" name="description"
                              id="description"><#if spring.status.value??>${spring.status.value?trim}</#if></textarea>
                    <label class="mdl-textfield__label" for="description"></label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Location:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select">
                    <input class="mdl-textfield__input" type="text" id="jobCountry" name="jobCountry"
                           value="${jobPost.country!"United States"}"
                           readonly tabIndex="-1">
                    <label for="jobCountry">
                        <i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
                    </label>
                    <ul for="jobCountry" class="mdl-menu mdl-menu--bottom-left mdl-js-menu"
                        style="height: 200px; overflow: auto;">
                        <#list countries as country>
                            <li class="mdl-menu__item">${country}</li>
                        </#list>
                    </ul>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Industry:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "jobPost.industry"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="industry" name="industry" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="industry">Job Industry</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Job Type:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <#--<@spring.bind "jobPost.jobType"/>-->
                <#--<div class="mdl-textfield mdl-js-textfield">-->
                    <#--<input class="mdl-textfield__input" type="text" id="jobType" name="jobType" required-->
                           <#--<#if spring.status.value??>value="${spring.status.value}"</#if>>-->
                    <#--<label class="mdl-textfield__label" for="jobType">Job Type</label>-->
                <#--</div>-->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select">
                    <input class="mdl-textfield__input" type="text" id="jobType" name="jobType" value="Full time"
                           readonly tabIndex="-1">
                    <label for="jobType">
                        <i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
                    </label>
                    <ul for="jobType" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                        <li class="mdl-menu__item">Full time</li>
                        <li class="mdl-menu__item">Part time</li>
                        <li class="mdl-menu__item">Temporary</li>
                    </ul>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Years of Experience:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "jobPost.yearsExperience"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="yearsExperience" name="yearsExperience" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="yearsExperience">Job Country</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Skills:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@rankedChoiceList fieldName="skills" availableChoices=skillOptions chosenChoices=skills />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit"
                        class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored
                        submit-button">
                    Save Changes
                </button>
            </td>
        </tr>
        </tbody>
    </table>
    <p></p>
</form>

</#macro>

<@display_page />