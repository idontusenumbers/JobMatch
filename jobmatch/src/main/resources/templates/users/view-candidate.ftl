<#include "../dashboard-base.ftl">

<#macro dashboard_nav>
<li><a href="#">Jobs</a></li>
</#macro>
<#macro dashboard_body>
<div id="wrapper">

    <section id="content">
        <div id="job-post">
            <div class="view-job">
                <h2>Candidate Name</h2>
            </div>
            <div class="view-job">
                <h3>Candidate Name</h3>
            </div>
            <div class="view-job">
                <h3>Candidate Experience</h3>
            </div>
            <div class="view-job">
                <h3>Candidate Contact Info</h3>
            </div>
            <div style="float:left">
                <h3>Skills</h3>
                    <ul>
                        <li>First item</li>
                        <li>Second item</li>
                        <li>Third item</li>
                        <li>Fourth item</li>
                        <li>Fifth item</li>
                    </ul>
            </div>

            <div style="float:left">
                <h3>Culture Traits</h3>
                    <ul>
                        <li>First item</li>
                        <li>Second item</li>
                        <li>Third item</li>
                        <li>Fourth item</li>
                        <li>Fifth item</li>
                    </ul>
            </div>

            <div style="clear:both"></div><br>

        </div>
    </section>

    <div class="clear"></div>
</div>
</#macro>

<@display_page />