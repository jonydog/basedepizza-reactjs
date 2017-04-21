$(document).ready(function() {
    /* charts */
    var chartContainer = document.getElementById('myChart');

    if(chartContainer) {
        var ctx = chartContainer.getContext('2d');
        Chart.defaults.global.responsive = true;

        var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S'],
            datasets: [{
            label: 'Positive',
            data: [12, 19, 3, 17, 6, 3, 7],
            backgroundColor: "rgba(153,255,51,0.4)",
            borderColor: "rgba(153,255,51,0.4)"
            }, {
            label: 'Negative',
            data: [2, 29, 5, 5, 2, 3, 10],
            backgroundColor: "rgba(255,68,68,0.4)",
            borderColor: "rgba(255,68,68,0.4)"
            }]
        }
        });
    }


    getToday = function() {
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; 
        var yyyy = today.getFullYear();

        if(dd<10) {
            dd = "0"+dd;
        }

        if(mm<10) {
            mm = "0"+mm;
        }

        today = yyyy + "-" + mm + "-" + dd;
        return today;
    };

    /*
    @see http://www.daterangepicker.com/ 
    */
    var today = getToday();
    $('input[name="daterange"]').daterangepicker(
    {
        timePicker: true,
        timePicker24Hour: true,
        locale: {
        format: 'YYYY-MM-DD',
        },
        startDate: today,
        endDate: today
    });

    $('input[name="calendar"]').daterangepicker({
        singleDatePicker: true,
        locale: {
            format: 'YYYY-MM-DD',
        },
        minDate: today,
        timePicker: true        
    });


    //count characters
    function countChars(val, charLimit) {
        var limit = (charLimit !== undefined)? charLimit : 140;

        var len = val.value.length;
        if (len > limit) {
            val.value = val.value.substring(0, limit);
        } else {
            $('.charNum').text(limit - len);
        }
    }

    $(".countChars").on("keyup", function() {
        countChars(this); 
    });

    //Bootstrap tooltips
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    });
});