function deleteUser(userNumber) {
    $.ajax({
        url : '/admin/users/'+ userNumber,
        type : "DELETE",
        success: function(data)
        {
            window.location.reload();
        },
    })};
