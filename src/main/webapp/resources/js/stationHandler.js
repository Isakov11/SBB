function deleteStation(stationNumber) {
    $.ajax({
        url : '/admin/stations/'+ stationNumber,
        type : "DELETE",
        success: function(data)
        {
            if (data !== "ok"){
                alert(data);
            }
            window.location.reload();
        },
    })};
