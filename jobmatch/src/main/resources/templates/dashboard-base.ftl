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
        <h1 class="headline"><a href="/" class="logo-link"><span class="logo">JobMatch</span> | <span
                class="role-name">${currentUser.role.name}</span></a></h1>
	</header>

	<div id="sidebar">
		<div style="text-align:center;">
			<#if currentUser.contact?? && ( currentUser.contact.firstName?has_content || currentUser.contact.lastName?has_content)>
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
                        <li>
                            <a href="${s.mvcUrl("UQC#getQualifications").arg(0,currentUser.id).build()}">Qualifications</a>
                        </li>
						<li><a href="${s.mvcUrl("JC#listFavoriteJobPosts").arg(0,currentUser.id).build()}">Favorites</a></li>
					<#break>
					<#case "Employer">
					<li><a href="${s.mvcUrl("CC#getCompany").arg(0,currentUser.company.id).build()}">My company</a></li>
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