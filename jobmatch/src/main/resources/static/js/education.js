$(function () {
    $('#tAddEducation').hide();
    $('#addEducationToggle').click(function () {
        $('#tAddEducation').fadeToggle("slow");

        $target = $('#tAddEducation');
        $('html, body').stop().animate({
            'scrollTop': $target.offset().top - 40
        }, 900, 'swing', function () {
            window.location.hash = $target;
        });
    });
});