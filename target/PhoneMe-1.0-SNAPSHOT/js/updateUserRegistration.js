/**
 * Created by taras on 6/8/2017.
 */
$(document).ready(function () {
    $('#update_form').validate({
        rules:{
            userFirstName:{
                required: true,
                digits: false
            },
            userLastName:{
                required: true,
                digits: false
            },

            userEmail:{
                required: true,
                email: true
            },

            userLogin:{
                required: true,
            },

            userPassword:{
                required: true,
                minlength: 8
            },

            phoneNumber:{
                required: true,
                digits: true,
                minlength: 10
            },

            userAge:{
                required: true,
                digits: true,
                maxlength: 3
            },

            image:{
                required:true
            }




        }
    })
})