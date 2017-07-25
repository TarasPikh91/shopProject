/**
 * Created by taras on 6/8/2017.
 */

$(document).ready(function () {
    $('#update_form').validate({
        rules:{
            name:{
                required: true,
            },
            email:{
                required: true,
                email: true
            },
            phoneNumber:{
                required: true,
                digits: true,
                minlength: 6
            },
            image:{
                required: true
            }
        },
        messages:{
            name:{
                required:"this field is empty"
            },
            phoneNumber:{
                required:"field phone number is empty"
            },
            email:{
                required:"field email is empty",
                email:"enter please correct email"

            }

        }
    })
})