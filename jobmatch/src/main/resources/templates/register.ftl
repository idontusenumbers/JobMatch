<#include "authentication-base.ftl">

<#macro header>REGISTER</#macro>

<#macro auth_page_body>
<form action="/register" name="user" method="post" class="form form-login">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="form-field">
        <input id="username" name="username" type="text" class="form-input" placeholder="Username" required/>
    </div>

    <div class="form-field">
        <input id="password" name="password" type="password" class="form-input" placeholder="Password" required/>
    </div>

    <!-- Start Contact Model Input -->
    <div class="form-field">
        <input id="firstName" name="contact.firstName" type="text" class="form-input" placeholder="First Name"
               required/>
    </div>

    <div class="form-field">
        <input id="lastName" name="contact.lastName" type="text" class="form-input" placeholder="Last Name" required/>
    </div>

    <div class="form-field">
        <input id="email" name="contact.email" type="email" class="form-input" placeholder="Email" required/>
    </div>

    <div class="form-field">
        <input id="phone" name="contact.phone" type="tel" class="form-input" placeholder="Phone Number" required/>
    </div>

    <div class="form-field">
        <input id="address" name="contact.address" type="text" class="form-input" placeholder="Address" required/>
    </div>

    <div class="form-field">
        <input id="zipcode" name="contact.zipcode" type="text" class="form-input" placeholder="ZipCode" required/>
    </div>

    <div class="form-field">
        <input id="website" name="contact.website" type="text" class="form-input" placeholder="Website"/>
    </div>
    <!-- End Contact Model Input -->

    <div class="form-field">
        <label for="optIn">Opt In</label>
        <input id="optIn" name="optIn" type="checkbox" class="form-input" required/>
    </div>


    <a href="/" class="forgot-password">Login</a>
    <div class="form-field">
        <input type="submit" value="Register"/>
    </div>
    <div class="clear"></div>
</form>

</#macro>
<@display_page/>