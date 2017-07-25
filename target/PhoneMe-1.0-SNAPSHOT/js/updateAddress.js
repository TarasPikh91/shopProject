/**
 * Created by taras on 6/8/2017.
 */

$(document).ready(function () {
    $('#update_form').validate({
        rules:{
           streetName: {
               required : true,
               minlength: 3
           },
           houseNumber: {
               required : true,
               digits: true
           },
            districtName: {
               required: true,
                minlength: 3

            }
        }
    })
});

