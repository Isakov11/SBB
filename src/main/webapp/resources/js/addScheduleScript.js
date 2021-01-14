
function sendNewSchedule() {
    let route = document.querySelectorAll(".wrapper");

    let trainId2  = document.getElementById("trainId").value;
    let stationId2  = document.getElementById("stationId").value;
    let stationOrder2  = document.getElementById("stationOrder").value;
    let arrivalDate2  =  document.getElementById("arrivalTime").value;
    let departureDate2  =  document.getElementById("departuretime").value;

    let ScheduleCreateDTO = {"trainId": trainId2, "stationId": stationId2, "stationOrder": stationOrder2,"arrivalTime": arrivalDate2,"departureTime": departureDate2};
    $.ajax({
        url: "/schedules/add",
        type : "POST",
        data : JSON.stringify(ScheduleCreateDTO),
        dataType : "json",
        contentType: 'application/json',

    });
}
