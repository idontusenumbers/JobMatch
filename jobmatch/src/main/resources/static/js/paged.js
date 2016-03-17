$(function () {
    var $progress = $('#progress');
    var $pages = $('section[data-page]');
    var $back = $('#back');
    var $next = $('#next');
    var $form = $('form');

    $progress.progressbar({
        value: getCurrentPageNumber(),
        max: $pages.length - 1
    });

    $back.on("click", function () {
        changePage(-1);
    });
    $next.on("click", function () {
        if (onLastPage()) {
            if (hasEmptyInput(getCurrentPageNumber())) {
                return false;
            }

            $form.submit();
        } else {
            changePage(1);
        }
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

        if (next > current) {
            if (hasEmptyInput(current)) {
                return false;
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

    var hasEmptyInput = function (current) {
        // Prevent User from advancing when fields aren't filled out
        var emptyInputs = $('[data-page=' + current + '] input[required]').filter(function () {
            return $.trim(this.value).length <= 0;
        });
        return emptyInputs.length > 0;
    };

    $('.js-page-container').each(function () {
        var $container = $(this);
        $container.find('input').on("keypress", function (ev) {
            if (ev.charCode == 13) // enter key
                $next.trigger("click");
        })
    });

    changePage(0);
    updateButtons();
});