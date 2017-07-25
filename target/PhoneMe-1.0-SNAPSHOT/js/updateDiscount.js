/**
 * Created by taras on 6/8/2017.
 */

$(document).ready(function () {
    $('#update_form').validate({
        rules:{
            name:{
                required: true,
                minlength: 3
            },
            percent:{
                required:true,
                digits: true
            }
        }
    });
});