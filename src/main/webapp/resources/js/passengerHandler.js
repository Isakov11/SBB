function deletePassenger(passengerNumber) {
    $.ajax({
        url : '/admin/passengers/'+ passengerNumber,
        type : "DELETE",
        success: function(data)
        {
            window.location.reload();
        },
    })};
