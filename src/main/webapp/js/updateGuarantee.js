/**
 * Created by taras on 6/8/2017.
 */

$(document).ready(function () {
    $('#update_form').validate({
        rules:{
            guaranteeTime:{
                required: true,
                digits:true,
                maxlength: 2
            }
        }
    })
})