$('#myTable').on('click', '.clickable-row', function(){
  $('.clickable-row').removeClass('bg-info')
  $(this).toggleClass('bg-info')
})



$('#insertCoin').click(function(){
  var tmp = parseFloat($('#moneyDisplay').text())
  var result = parseFloat($('#selectedCoin').val())
  $('#moneyDisplay').text((tmp+result).toFixed(2))
})
