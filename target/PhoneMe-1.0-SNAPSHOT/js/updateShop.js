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
            description:{
                required: true,
                minlength: 20
            }
        },
        messages:{
            name:{
                required:"field name is empty",
                minlength:"min 3 letters"
            }
        }
    });
})