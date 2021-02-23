function deleteTicket(ticketNumber) {
    $.ajax({
        url : '/admin/tickets/'+ ticketNumber,
        type : "DELETE",
        success: function(data)
        {
            window.location.reload();
        },
    })};
