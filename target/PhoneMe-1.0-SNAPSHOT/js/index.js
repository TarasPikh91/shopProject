/**
 * Created by taras on 7/8/2017.
 */

$('#confirmation').click(function (event) {
    alert("check your email");
});

$('#cart').click(function (event) {

})

$(document).ready(function () {
    $('ul#filter a').click(function () {
    $(this).css('outline','none');
    $('ul#filter .current').removeClass('current');
    $(this).parent().addClass('current');

    var filterVal = $(this).text().toLowerCase().replace(' ','-');

    if (filterVal == 'all'){
        $('main#portfolio div.hidden').fadeIn('slow').removeClass('hidden');
    }else{
        $('main#portfolio #commodity').each(function () {
            if(!$(this).hasClass(filterVal)){
                $(this).fadeOut('normal').addClass('hidden');
            }else{
                $(this).fadeIn('slow').removeClass('hidden');
            }
        });
    }
    return false;
    });
});