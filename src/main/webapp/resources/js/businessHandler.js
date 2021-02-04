$(document).ready(function () {
    window.locale = "en";

    function selectTrain (departStationId, arrivalStationId, departDate ){

    $.ajax({
        url : '/wizard/trainfinder',
        data: {
            "departStationId": departStationId,
            "arrivalStationId": arrivalStationId,
            "departDate":departDate
        },
        type : "GET",
        dataType : "json",
        success: function(data)
        {
            let  markup = '';
            markup += '<table className="table table-striped table-bordered">' +
                '<thead>' +
                '<tr>' +
                    '<th className="align-middle" scope="col">Number</th>' +
                    '<th className="align-middle" scope="col">Name</th>' +
                    '<th className="align-middle" scope="col">Seats number</th>' +
                    '<th className="align-middle" scope="col">' +
                        '<table className="table table-borderless">' +
                            '<thead className="align-middle">' +
                            '<tr>' +
                                '<th scope="col">Station</th>' +
                                '<th scope="col">Arrival date</th>' +
                                '<th scope="col">Departure date</th>' +
                            '</tr>' +
                            '</thead>' +
                        '</table>' +
                    '</th>' +
                    '<th className="align-middle text-center" scope="col">Action</th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>'

                for(let i = 0; i < data.length; i++) {
                    markup +=
                        '<tr>' +
                        '<td className="align-middle">' + data[i].getAttribute("number") + '</td>' +
                        '<td className="align-middle">' + data[i].getAttribute("name") + '</td>' +
                        '<td className="align-middle">' + data[i].getAttribute("seatNumber") + '</td>' +
                        '<td>' +
                        '</td>' +
                        '<td>' +
                            '<form action="/wizard/trainselecter" method="get">' +
                                    '<input type="hidden" name="departStationId" value="${departStationId}">' +
                                    '<input type="hidden" name="trainId" value="${dto.id}">' +
                                    '<button type="submit" className="btn btn-primary">Select train</button>' +
                                '</form>' +
                            '</td>' +
                        '</tr>'
                }
                markup += '</tbody>' +  '</table>';
                $('#items').append().html(markup);
        },
    })};

});

