var $progress = $('#progress');
var $pages = $('section[data-page]');
var $back = $('#back');
var $next = $('#next');
var $form = $('form');

$(document).ready(function () {
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
    $next.html(onLastPage() ? 'Save' : 'Next >');
    $progress.val(currentPageNumber);
};
function getCurrentPageNumber() {
    return $pages.filter(':visible').first().data('page');
}
var changePage = function (step) {
    var current = getCurrentPageNumber();
    var next = Math.max(Math.min(current + step, $pages.length - 1), 0);

    // Prevent User from advancing when fields aren't filled out
    if (next > current) {
        switch (current) {
            case 0:
                if (isEmpty($('#firstName').val()) || isEmpty($('#lastName').val())) {
                    return false;
                }
                break;
            case 1:
                if (isEmpty($('#address').val()) || isEmpty($('#zipcode').val())) {
                    return false;
                }
                break;
            default:
                break;
        }
    }

    $progress.progressbar({
        value: next,
        max: $pages.length - 1
    });

    var $nextPage = $pages.hide().eq(next);
    $nextPage.show();
    $nextPage.find('input, textarea').first().focus();
    updateButtons();
};

var isEmpty = function (val) {
    return val === '';
};

$back.on("click", function () {
    changePage(-1);
});
$next.on("click", function () {
    if (onLastPage()) {
        if (isEmpty($('#phone').val())) {
            return false;
        }

        $form.submit();
    } else {
        changePage(1);
    }
});

$('.js-page-container').each(function () {
    var $container = $(this);
    $container.find('input').on("keypress", function (ev) {
        if (ev.charCode == 13) // enter key
            $next.trigger("click");
    })
});

changePage(0);
updateButtons();

// TODO handle focus, required field checking, and enter key to advance to next field