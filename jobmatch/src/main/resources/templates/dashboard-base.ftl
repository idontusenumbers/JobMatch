<#include "base.ftl">


<#macro page_head>
<link rel="stylesheet" href="/static/styles/main.css">
</#macro>
<#macro dashoard_body>
You forgot to include the dashboard body
</#macro>
<#macro page_body>
<div id="wrapper">
	<header>
		<h1 class="headline"><span class="logo">JobMatch</span> | <span
				class="role-name">${currentUser.role.name}</span></h1>
	</header>

	<div id="sidebar">
		<div style="text-align:center;">
			<#if currentUser.contact??>
				<h2 class="company">${currentUser.contact.firstName} ${currentUser.contact.lastName}</h2>
			<#else>
				<h2 class="company">${currentUser.username}</h2>
			</#if>
		</div>
		<br>

		<#switch currentUser.role.name>
			<#case "Admin">

				<#break>
			<#case "Seeker">

				<#break>
			<#case "Employer">
				<a class="sidebar-button" href="${s.mvcUrl("JC#createJob").build()}">+ post a job</a>
				<#break>
			<#default>

				Unknown role ${currentUser.role.name}
				<#break>
		</#switch>


		<br>

		<nav>
			<ul id="sidebar-nav">
				<li><a href="${s.mvcUrl("JC#listJobs").build()}">Jobs</a></li>
				<li><a href="${s.mvcUrl("UC#getProfile").arg(0,currentUser.id).build()}">Profile</a></li>

				<#switch currentUser.role.name>
					<#case "Admin">

						<#break>
					<#case "Seeker">
						<li><a href="${s.mvcUrl("UC#getQualifications").arg(0,currentUser.id).build()}">Qualifications</a></li>
						<#break>
					<#case "Employer">

						<#break>
					<#default>

						Unknown role ${currentUser.role.name}
						<#break>
				</#switch>

				<li><a href="/logout">Logout</a></li>
			</ul>
		</nav>
	</div>

	<section id="content"><@dashboard_body /></section>

	<div class="clear"></div>
</div>
</#macro>

<#macro page_body_footer>
<script type="text/javascript" src="/static/js/auth.js"></script>
</#macro>