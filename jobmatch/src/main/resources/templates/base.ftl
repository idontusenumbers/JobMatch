<#import "/spring.ftl" as spring/>
<#--<#assign s=JspTaglibs["http://www.springframework.org/tags"] />-->
<#assign s=JspTaglibs["/META-INF/spring.tld"] />

<#--&lt;#&ndash;<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>&ndash;&gt;-->
<#--<#assign sec=JspTaglibs["/META-INF/security.tld"] />-->


<#macro page_head>
<title>${title}</title>
<link rel="stylesheet" href="/styles/main.css">
<link rel="stylesheet" href="/styles/login.css">

<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700|Open+Sans:400,700,400italic,700italic'
      rel='stylesheet' type='text/css'>
</#macro>

<#macro page_body>
<h1>Basic Page</h1>
<p>This is the body of the page!</p>
</#macro>

<#macro display_page>
<!doctype html>
<html>
<head>
    <@page_head/>
</head>
<body>
    <#if errors??>
        <#list errors as error>
            <li>${error}</li>
        </#list>
    </#if>


<div id="nav">


    <a href="${s.mvcUrl("IC#index").build()}">Home</a>
    <#if auth.principal?? && auth.principal?is_hash && auth.principal.enabled>
        <a href="/logout">Logout</a>
    </#if>

</div>
    <@page_body/>
<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>
</#macro>