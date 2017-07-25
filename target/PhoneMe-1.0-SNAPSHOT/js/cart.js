/**
 * Created by taras on 7/14/2017.
 */

// $(document).ready(function () {
//     $('td#commodityPrice').on('change', function () {
//         $('td#totalPrice').val(valueFunction());
//     });
//     $('select#quantity').on('change', function () {
//         $('td#totalPrice').val(valueFunction());
//     });
// });
// function valueFunction(quan) {
//     var $selection = $('#commodityPrice').getAttribute().val();
//     var quantity = $('#quantity').val();
//     var total = 0;
//     $selection.each(function () {
//         total +=$(this).data('price')*quantity;
//     });
//     return total;
// }

$('#quantity').css('color', 'red');

var total = $('#quantity').val();
var price = $('#commodityPrice').val();

var fullPrice = 3*3;

console.log(fullPrice);