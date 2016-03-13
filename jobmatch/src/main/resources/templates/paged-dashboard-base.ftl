<#include "dashboard-base.ftl">

<#macro paged_dashboard_page_body >
oops, you forgot to implement an paged_dashboard_page_body in your template!
</#macro>

<#macro form_attributes ></form>oops, you forgot the form attributes in your template!</#macro>


<#macro dashboard_body>


<table id="t1" align="center" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <tr>
        <td class="mdl-data-table__cell--non-numeric">
            <@error_list errors/>


            <form <@form_attributes/> class="form form-profile js-page-container">

                <@spring.bind "user" />
                <@spring.showErrors '*', 'errors' />

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <div id="progress"></div>


                <@paged_dashboard_page_body/>

                <button id="back" type="button" class="mdl-button mdl-js-button mdl-js-ripple-effect">
                    &lt; Back
                </button>
                <button id="next" type="button"
                        class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored form-button">
                    Next &gt;
                </button>
                <p><a href="${s.mvcUrl("UC#delete").arg(0,user.id).build()}">Delete My Account</a></p>

            </form>

        </td>
    </tr>
</table>

</#macro>