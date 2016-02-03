<#import "/spring.ftl" as spring/>
<#--<#assign s=JspTaglibs["http://www.springframework.org/tags"] />-->
<#assign s=JspTaglibs["/META-INF/spring.tld"] />

<#macro page_head>
  <title>${title}</title>
  <link rel="stylesheet" href="/styles/main.css">
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
      <script type="text/javascript" src="/js/main.js"></script>
    </head>
    <body>
      <div id="nav"><a href="${s.mvcUrl("IC#index").build()}">Home</a></div>
      <@page_body/>
    </body>
  </html>
</#macro>