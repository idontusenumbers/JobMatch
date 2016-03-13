$.ajaxPrefilter(function (options, originalOptions, jqXHR) {
    jqXHR.setRequestHeader('X-CSRF-Token', window.CSRF);
});

$(function () {
    $('.fav-toggle').click(function () {
        setFavorite(this)
    });

    var sortLists = $(".sortable-list");

    window.setRanks = function () {

        sortLists.each(function () {
            var $sortList = $(this);
            var fieldName = $sortList.attr('data-field');
            $('input[name=' + fieldName + 'Ranks]').each(function () {
                var $rank = $(this);
                var choice = $rank.attr('data-choice');
                var $ranker = $('.sortable-list[data-field=' + fieldName + '] li[data-choice=' + choice + ']');
                $rank.val($ranker.index());

            });
        });
    };
    sortLists.each(function () {
        var $sortList = $(this);
        var fieldName = $sortList.attr('data-field');
        var $checkBoxes = $('[name=' + fieldName + ']');

        $sortList.sortable({'stop': setRanks}).disableSelection();
        $checkBoxes.on("click", function () { // TODO change event insteadof just click
            var $this = $(this);

            var choice = $this.val();
            if ($this.is(':checked')) {
                var text = $('label[for=' + $this.attr('id') + ']').text();
                var $item = $('<li>').text(text).attr('data-choice', choice);
                $this.siblings('.rank').val($sortList.children().length)
                $sortList.append($item);
            } else {
                $sortList.find('li[data-choice=' + choice + ']').remove();
            }
        })


    })


});

var disableUnchecked = function (pairs) {
    window.setRanks();
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

            if (newValue == true) {
                $el.find('.material-icons').text('favorite');
            } else {
                $el.find('.material-icons').text('favorite_border');
            }
        }

    })
    ;

}