<#include "../dashboard-base.ftl">

<#macro header>QUALIFICATIONS</#macro>

<#macro dashboard_body>

<form action="${s.mvcUrl("UQC#updateQualifications").arg(0, user.id).build()}" name="user" method="post"
      onsubmit="disableUnchecked({'skills':'skillsRanks'}); disableUnchecked({'cultures':'culturesRanks'});">

    <@spring.bind "user" />
    <@spring.showErrors '*', 'errors' />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric" id="tblQualifications"><h5>Edit Qualifications</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Resume:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <textarea class="mdl-textfield__input" type="text" rows="3" name="resume"
                              id="resume"><#if user.resume??>${user.resume}</#if></textarea>
                    <label class="mdl-textfield__label" for="resume">Resume...</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Skills:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <@rankedChoiceList fieldName="skills" availableChoices=skillOptions chosenChoices=skills />
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Culture:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <@rankedChoiceList fieldName="cultures" availableChoices=cultureOptions chosenChoices=cultures />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button id="show-toast" type="submit"
                        class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button">
                    Save Changes
                </button>
            </td>
        </tr>
    </table>
</form>
<br>
<table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <thead>
    <tr>
        <th class="mdl-data-table__cell--non-numeric" id="tblReferences"><h5>References</h5></th>
        <th class="mdl-data-table__cell--non-numeric"></th>
    </tr>
    </thead>
    <#list referenceList as reference>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>First Name:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>${reference.firstName}</h6>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Last Name:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>${reference.lastName}</h6>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Title:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>${reference.title}</h6>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Company Name:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
            ${reference.companyName}
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>Phone:</h6>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <h6>${reference.phone}</h6>
            </td>
        </tr>
        </tbody>
        <th colspan="2"></th>
    </#list>
</table>
<br>
<form action="${s.mvcUrl("UQC#addReference").arg(0, user.id).build()}" name="reference" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric"><h5>Add Reference</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>First Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="firstName" name="firstName" required>
                    <label class="mdl-textfield__label" for="firstName">John</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Last Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="lastName" name="lastName" required>
                    <label class="mdl-textfield__label" for="lastName">Doe</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Title:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="title" name="title" required>
                    <label class="mdl-textfield__label" for="title">CTO</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Company Name:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="companyName" name="companyName" required>
                    <label class="mdl-textfield__label" for="companyName">John Doe, LLC</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h6>Phone:</h6></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="tel" id="phone" name="phone" required>
                    <label class="mdl-textfield__label" for="phone">(783) 310-456</label>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button">
                    Add Reference
                </button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<br>
<form action="${s.mvcUrl("UQC#addEducation").arg(0, user.id).build()}" name="reference" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric" id="tblEducation"><h5>Education</h5></th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
            <#list educationList as education>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>School Name:</h6></td>
                <td class="mdl-data-table__cell--non-numeric"><h6>${education.schoolName}</h6></td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>Country:</h6></td>
                <td class="mdl-data-table__cell--non-numeric"><h6>${education.country}</h6></td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>Degree:</h6></td>
                <td class="mdl-data-table__cell--non-numeric"><h6>${education.degree}</h6></td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>Major:</h6></td>
                <td class="mdl-data-table__cell--non-numeric"><h6>${education.major}</h6></td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>Year Graduated:</h6></td>
                <td class="mdl-data-table__cell--non-numeric"><h6>${education.yearGraduated}</h6></td>
            </tr>
            <th colspan="2"></th>
            </#list>
        </tbody>
    </table>
    <br/>
    <form action="${s.mvcUrl("UQC#addEducation").arg(0, user.id).build()}" name="education" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" id="t1" align="center">
            <thead>
            <tr>
                <th class="mdl-data-table__cell--non-numeric"><h5>Add Education</h5></th>
                <th class="mdl-data-table__cell--non-numeric"></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>School Name:</h6></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="schoolName" name="schoolName" required>
                        <label class="mdl-textfield__label" for="schoolName">DePaul University</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>Country:</h6></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="country" name="country" required>
                        <label class="mdl-textfield__label" for="country">United States</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>Degree:</h6></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="degree" name="degree" required>
                        <label class="mdl-textfield__label" for="degree">Bachelor of Science</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>Major:</h6></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="major" name="major" required>
                        <label class="mdl-textfield__label" for="major">Computer Science</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h6>Year Graduated:</h6></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="number" id="yearGraduated" name="yearGraduated"
                               required>
                        <label class="mdl-textfield__label" for="yearGraduated">2016</label>
                    </div>
                </td>
            </tr>
            </tbody>
            <tr>
                <td colspan="2">
                    <button type="submit"
                            class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored submit-button">
                        Add Education
                    </button>
                </td>
            </tr>
        </table>
    </form>
    <p>

    <div id="toast-notification" class="mdl-js-snackbar mdl-snackbar">
        <div class="mdl-snackbar__text"></div>
        <button class="mdl-snackbar__action" type="button"></button>
    </div>

</#macro>
<@display_page/>