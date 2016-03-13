<#include "dashboard-base.ftl">

<#macro paged_dashboard_page_body >
oops, you forgot to implement an paged_dashboard_page_body in your template!
</#macro>

<#macro form_attributes ></form>oops, you forgot the form attributes in your template!</#macro>


<#macro dashboard_body>
<div class="mdl-grid">
    <div class="mdl-cell--4-offset-desktop mdl-cell--2-offset-tablet mdl-cell mdl-cell--4-col">
        <@error_list errors/>
    </div>
    <div class="mdl-cell mdl-cell--3-offset-desktop mdl-cell--6-col-desktop mdl-cell--8-col-tablet">
        <div class="mdl-card-wide mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title mdl-card--expand">
                <h2 class="mdl-card__title-text">Edit Profile</h2>
            </div>
            <div class="mdl-card__supporting-text">
                <form <@form_attributes/> class="form form-profile js-page-container">

                    <@spring.bind "user" />
                    <@spring.showErrors '*', 'errors' />

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div id="progress"></div>


                    <@paged_dashboard_page_body/>
            </div>
            <div class="mdl-card__actions mdl-card--border mdl-typography--text-center">
                <button id="back" type="button" class="mdl-button mdl-js-button mdl-js-ripple-effect">
                    &lt; Back
                </button>
                <button id="next" type="button"
                        class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored form-button">
                    Next &gt;
                </button>
                <p><a href="${s.mvcUrl("UC#delete").arg(0,user.id).build()}">Delete My Account</a></p>
            </div>

            </form>
        </div>
    </div>
</div>
</#macro>