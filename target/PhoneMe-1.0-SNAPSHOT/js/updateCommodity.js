/**
 * Created by taras on 6/8/2017.
 */

$(document).ready(function () {
    $('#update_form').validate({
        rules:{
            commodityName :{
                required: true,
                minlength: 3
            },
            commodityPrice :{
                required: true,
                digits: true
            },
            commodityDescription:{
                required:true,
                minlength: 10
            },
            image:{
                required: true
            }
        }
    });
});
