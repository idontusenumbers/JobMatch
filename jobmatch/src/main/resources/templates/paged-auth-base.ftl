<#include "auth-base.ftl">

<#macro paged_auth_page_body >
oops, you forgot to implement an paged_auth_page_body in your template!
</#macro>

<#macro form_attributes ></form>oops, you forgot the form attributes in your template!</#macro>

<#macro page_head>
<link rel="stylesheet" href="/static/styles/login.css">
</#macro>


<#macro auth_page_body>
<form <@form_attributes/> class="form form-login">

	<@spring.bind "user" />
	<@spring.showErrors '*', 'errors' />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<progress id="progress"></progress>


	<@paged_auth_page_body/>

	<input id="back" type="button" value="&lt; back" class="button">
	<input id="next" type="button" value="" class="call-to-action">
    <p><a href="${s.mvcUrl("UC#delete").arg(0,user.id).build()}">Delete My Account</a></p>

</form>
</#macro>