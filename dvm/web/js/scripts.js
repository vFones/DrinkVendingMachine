$('#myTable').on('click', '.clickable-row', function(){
  $('.clickable-row').removeClass('bg-info');
  $(this).toggleClass('bg-info');
  $('.drinkId').removeAttr('name', 'drink');
  $(this).children().children().attr('name', 'drink');
})


$('#insertCoin').click(function(){
  var displayTmp = parseFloat($('#moneyDisplay').text());
    var result = parseFloat($('#selectedCoin').val());
    $('#moneyDisplay').text((displayTmp + result).toFixed(2));
    $('#inputDisplay').val((displayTmp + result).toFixed(2));
})
