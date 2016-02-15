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
		<p><a href="${s.mvcUrl("UC#delete").arg(0,user.id).build()}">delete my account</a></p>
	<@spring.bind "user" />
	<@spring.showErrors '*', 'errors' />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<@spring.formHiddenInput path="user.id"></@spring.formHiddenInput>

	<progress id="progress"></progress>


	<@paged_auth_page_body/>

	<input id="back" type="button" value="&lt; back" class="button">
	<input id="next" type="button" value="" class="call-to-action">

</form>

<script>
	var $progress = $('#progress');
	var $pages = $('section[data-page]');
	var $back = $('#back');
	var $next = $('#next');
	var $form = $('form');
	function onLastPage() {
		return getCurrentPageNumber() == $pages.length-1;
	}
	var updateButtons = function () {
		var currentPageNumber = getCurrentPageNumber();
		$back.attr('disabled', currentPageNumber == 0 ? 'disabled' : null);
		$next.attr('value', onLastPage() ? 'Submit' : 'next >');
		$progress.val(currentPageNumber);

	}
	function getCurrentPageNumber() {
		return $pages.filter(':visible').first().data('page');
	}
	var changePage = function (step) {
		var current = getCurrentPageNumber();
		var next = Math.max(Math.min(current + step, $pages.length-1), 0);

		$pages.hide().eq(next).show();
		updateButtons();
	}

	$back.on("click", function () {
		changePage(-1);
	});
	$next.on("click", function () {
		if (onLastPage())
			$form.submit();
		else
			changePage(1);
	});

	$progress.attr({
					   'max': $pages.length,
					   'value': 0
				   });
	changePage(-1000);
	updateButtons();


</script>
</#macro>
