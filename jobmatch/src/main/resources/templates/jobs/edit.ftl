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

    <table id="t1" align="center">
        <tr>
            <th colspan="2">Edit a Job Post</th>
        </tr>
        <tr>
            <td><h2>Job Title:</h2></td>
            <td><@spring.formInput path="jobPost.jobTitle" attributes='class="form-input" placeholder="Job Title"' /></td>
        </tr>
        <tr>
            <td><h2>Location:</h2></td>
            <td><@spring.formInput path="jobPost.jobCountry" attributes='class="form-input" placeholder="Country"' /></td>
        </tr>
        <tr>
            <td><h2>Industry:</h2></td>
            <td><@spring.formInput path="jobPost.industry" attributes='class="form-input" placeholder="industry"' /></td>
        </tr>
        <tr>
            <td><h2>Job Type:</h2></td>
            <td><@spring.formInput path="jobPost.jobType" attributes='class="form-input" placeholder="jobType"' /></td>
        </tr>
        <tr>
            <td><h2>Years of Experience:</h2></td>
            <td><@spring.formInput path="jobPost.yearsExperience" attributes='class="form-input" placeholder="yearsExperience"' /></td>
        </tr>
        <tr>
            <td><h2>Skills:</h2></td>
            <td><@rankedChoiceList fieldName="skills" availableChoices=skillOptions chosenChoices=skills /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" class="sidebar-button"></td>
        </tr>
    </table>
</form>

</#macro>

<@display_page />