

var disableUnchecked = function(pairs){

	for (var k in pairs) {
		$('[name=' + k + ']').each(function(i){
			var $this = $(this);
			var toEnable = $('[name=' + pairs[k] + ']').eq(i);
			toEnable.attr('disabled', $this.is(':checked') ? null: 'disabled');
		});
	}
	
};