var $progress = $('#progress');
var $pages = $('section[data-page]');
var $back = $('#back');
var $next = $('#next');
var $form = $('form');

$(function () {
    $progress.progressbar({
        value: getCurrentPageNumber(),
        max: $pages.length - 1
    });
});

function onLastPage() {
    return getCurrentPageNumber() == $pages.length - 1;
}
var updateButtons = function () {
    var currentPageNumber = getCurrentPageNumber();
    $back.attr('disabled', currentPageNumber == 0 ? 'disabled' : null);
    $next.attr('value', onLastPage() ? 'Submit' : 'next >');
    $progress.val(currentPageNumber);

};
function getCurrentPageNumber() {
    return $pages.filter(':visible').first().data('page');
}
var changePage = function (step) {
    var current = getCurrentPageNumber();
    var next = Math.max(Math.min(current + step, $pages.length - 1), 0);

    $progress.progressbar({
        value: next
    });

    var $nextPage = $pages.hide().eq(next);
    $nextPage.show();
    $nextPage.find('input, textarea').first().focus();
    updateButtons();
};

$back.on("click", function () {
    changePage(-1);
});
$next.on("click", function () {
    if (onLastPage())
        $form.submit();
    else
        changePage(1);
});

$('.js-page-container').each(function(){
    var $container = $(this);
    $container.find('input').on("keypress", function(ev){
        if (ev.charCode == 13) // enter key
            $next.trigger("click");
    })
})

changePage(0);
updateButtons();

// TODO handle focus, required field checking, and enter key to advance to next field