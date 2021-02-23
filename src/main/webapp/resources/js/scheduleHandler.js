function deleteNode(nodeNumber) {
    $.ajax({
        url : '/admin/schedules/'+ nodeNumber,
        type : "DELETE",
        success: function(data)
        {
            window.location.reload();
        },
    })};
