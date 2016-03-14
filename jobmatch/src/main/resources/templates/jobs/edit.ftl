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
            <th class="mdl-data-table__cell--non-numeric">Post a Job</th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Job Title:</h2></td>
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
                <h2>Description:</h2>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "jobPost.description"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <textarea class="mdl-textfield__input" type="text" rows="3" name="description" id="description">
                        <#if spring.status.value??>${spring.status.value}</#if>
                    </textarea>
                    <label class="mdl-textfield__label" for="description"></label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Location:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "jobPost.jobCountry"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="jobCountry" name="jobCountry" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="jobCountry">Job Country</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Industry:</h2></td>
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
            <td class="mdl-data-table__cell--non-numeric"><h2>Job Type:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <@spring.bind "jobPost.jobType"/>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="jobType" name="jobType" required
                           <#if spring.status.value??>value="${spring.status.value}"</#if>>
                    <label class="mdl-textfield__label" for="jobType">Job Type</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Years of Experience:</h2></td>
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
            <td class="mdl-data-table__cell--non-numeric"><h2>Skills:</h2></td>
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