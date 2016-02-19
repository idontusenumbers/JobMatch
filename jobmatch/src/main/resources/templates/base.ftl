<#import "/spring.ftl" as spring/>
<#--<#assign s=JspTaglibs["http://www.springframework.org/tags"] />-->
<#assign s=JspTaglibs["/META-INF/spring.tld"] />

<#--&lt;#&ndash;<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>&ndash;&gt;-->
<#--<#assign sec=JspTaglibs["/META-INF/security.tld"] />-->


<#macro page_head>

</#macro>

<#macro error_list errors=[]>
	<#if errors??>
		<#list errors as error>
		<li>${error}</li>
		</#list>
	</#if>
</#macro>

<#macro page_body>
<@error_list errors/>
<h1>Basic Page</h1>
<p>This is the body of the page!</p>
</#macro>


<#macro display_page>
<!doctype html>
<html>
	<head>
		<title>${title}</title>
		<link rel="stylesheet" href="/static/styles/main.css">
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700|Open+Sans:400,700,400italic,700italic'
			  rel='stylesheet' type='text/css'>
		<@page_head/>
	</head>
	<body>
<#--
    <div id="nav">
        <#if auth.principal?? && auth.principal?is_hash>
            <a href="${s.mvcUrl("IC#index").build()}">Home</a>
            <a href="${s.mvcUrl("UC#getProfile").arg(0, auth.principal.user.id).build()}">${auth.principal.username}</a>
            <a href="/logout">Logout</a>
        </#if>
    </div>
/>-->
    <@page_body/>

    <script type="text/javascript" src="/static/js/jquery-2.2.0.min.js"></script>
    <script type="text/javascript" src="/static/js/main.js"></script>

    <@page_body_footer/>

</body>
</html>
</#macro>

<#macro page_body_footer>

</#macro>