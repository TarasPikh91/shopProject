/**
 * Created by taras on 6/8/2017.
 */

$(document).ready(function () {
    $('#update_form').validate({
        rules:{
            firstName:{
                required: true,
                digits: false
            },
            lastName:{
                required: true,
                digits: false
            },

            email:{
                required: true,
                email: true
            },

            phoneNumber:{
                required: true,
                digits: true,
                minlength: 10
            },

            image:{
                required : true
            }

        }
    })
})