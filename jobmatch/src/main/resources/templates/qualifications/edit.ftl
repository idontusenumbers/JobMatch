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
            <th class="mdl-data-table__cell--non-numeric">Edit Qualifications</th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Resume:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <textarea class="mdl-textfield__input" type="text" rows="3" name="resume" id="resume"></textarea>
                    <label class="mdl-textfield__label" for="resume">Resume...</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h2>Skills:</h2>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <@rankedChoiceList fieldName="skills" availableChoices=skillOptions chosenChoices=skills />
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h2>Culture:</h2>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
                <@rankedChoiceList fieldName="cultures" availableChoices=cultureOptions chosenChoices=cultures />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit"
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
        <th class="mdl-data-table__cell--non-numeric">References</th>
        <th class="mdl-data-table__cell--non-numeric"></th>
    </tr>
    </thead>
    <#list referenceList as reference>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h2>First Name:</h2>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
            ${reference.firstName}
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h2>Last Name:</h2>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
            ${reference.lastName}
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h2>Title:</h2>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
            ${reference.title}
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h2>Company Name:</h2>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
            ${reference.companyName}
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric">
                <h2>Phone:</h2>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
            ${reference.phone}
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
            <th class="mdl-data-table__cell--non-numeric">Add Reference</th>
            <th class="mdl-data-table__cell--non-numeric"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>First Name:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="firstName" name="firstName" required>
                    <label class="mdl-textfield__label" for="firstName">John</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Last Name:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="lastName" name="lastName" required>
                    <label class="mdl-textfield__label" for="lastName">Doe</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Title:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="title" name="title" required>
                    <label class="mdl-textfield__label" for="title">CTO</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Company Name:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="companyName" name="companyName" required>
                    <label class="mdl-textfield__label" for="companyName">John Doe, LLC</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="mdl-data-table__cell--non-numeric"><h2>Phone:</h2></td>
            <td class="mdl-data-table__cell--non-numeric">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="tel" id="phone" name="phone"
                           pattern="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$" required>
                    <label class="mdl-textfield__label" for="phone">(783) 310-456</label>
                    <span class="mdl-textfield__error">Input is not a valid phone number!</span>
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
            <th class="mdl-data-table__cell--non-numeric" colspan="2">Education</th>
        </tr>
        </thead>
        <tbody>
            <#list educationList as education>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>School Name:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">${education.schoolName}</td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>Country:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">${education.country}</td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>Degree:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">${education.degree}</td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>Major:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">${education.major}</td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>Year Graduated:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">${education.yearGraduated}</td>
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
                <th class="mdl-data-table__cell--non-numeric">Add Education</th>
                <th class="mdl-data-table__cell--non-numeric"></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>School Name:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="schoolName" name="schoolName" required>
                        <label class="mdl-textfield__label" for="schoolName">DePaul University</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>Country:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="country" name="country" required>
                        <label class="mdl-textfield__label" for="country">United States</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>Degree:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="degree" name="degree" required>
                        <label class="mdl-textfield__label" for="degree">Bachelor of Science</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>Major:</h2></td>
                <td class="mdl-data-table__cell--non-numeric">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="major" name="major" required>
                        <label class="mdl-textfield__label" for="major">Computer Science</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="mdl-data-table__cell--non-numeric"><h2>Year Graduated:</h2></td>
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

</#macro>
<@display_page/>