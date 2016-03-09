<#import "/spring.ftl" as spring/>
<#assign s=JspTaglibs["/META-INF/spring.tld"] />

<#include "macros.ftl" />

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
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>
    <!-- Disable tap highlight on IE -->
    <meta name="msapplication-tap-highlight" content="no">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="application-name" content="Web Starter Kit">
    <link rel="icon" sizes="192x192" href="/static/styles/images/touch/chrome-touch-icon-192x192.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Web Starter Kit">
    <link rel="apple-touch-icon" href="/static/styles/images/touch/apple-touch-icon.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="/static/styles/images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#2F3BA2">

    <!-- Color the status bar on mobile devices -->
    <meta name="theme-color" content="#2F3BA2">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->
    <link href="/static/styles/jquery-ui.min.css" rel="stylesheet" type="text/css">
    <link href="/static/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css">
    <link href="/static/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css">
    <link href="/static/styles/material.min.css" rel="stylesheet" type="text/css">
    <link href="/static/styles/main.css" rel="stylesheet" type="text/css">
    <@page_head/>
    <script>
        window.FAVE_URL = '${s.mvcUrl("JC#setFavorite").build()}';
        window.CSRF = '${_csrf.token}';

    </script>
</head>
<body>
    <@page_body/>
    <@import_js/>
    <@page_body_footer/>
</body>
</html>
</#macro>

<#macro page_body_footer>

</#macro>