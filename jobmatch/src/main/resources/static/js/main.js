
$.ajaxPrefilter(function (options, originalOptions, jqXHR) {
  jqXHR.setRequestHeader('X-CSRF-Token', window.CSRF);
});


var disableUnchecked = function (pairs) {

	for (var k in pairs) {
		$('[name=' + k + ']').each(function (i) {
			var $this = $(this);
			var toEnable = $('[name=' + pairs[k] + ']').eq(i);
			toEnable.attr('disabled', $this.is(':checked') ? null : 'disabled');
		});
	}

};

var setFavorite = function (el) {
	var $el = $(el);
	var current = $el.attr('data-favorite');

	var newValue = (current == "false");

	$.ajax(window.FAVE_URL, {
		method: "POST",
		data: JSON.stringify({
			 jobPostId: $el.data('job-post-id'),
			 isFavorite: newValue,
		 }),
		contentType: "application/json; charset=utf-8",


		success: function () {
			$el.attr('data-favorite', newValue);
		}

	})
	;

}