function deleteTrain(trainNumber) {
    $.ajax({
        url : '/admin/trains/'+ trainNumber,
        type : "DELETE",
        success: function(data)
        {
            window.location.reload();
        },
    })};
