            $(document).ready(function(){
                var line1 = [5,5,5,5,2,5,4,3,3,4,6,8,7,8,9,9,9,4,9,9,0,10,0,10,11,0,6,11,0,0,0,12,7,6,12,13,3,3,3,4,4,13,2,2,2,2,2,2,2,2,2,2,2,3,3,3,4,4,4,5,2,5,5,5,5,5,5,4,5,5,5,0,5,5,4,5,6,1,5,0,5,6,2,6,6,0,6,6,6,6,6,6,6,6,6,7,6,6,6,7,7,0,0,7,7,8,8,8,8,7,9,9,9,9,9,9,0,9,10,11,11,10,11,11,11,12,10,9,13,13,7,13,13,13,13,14,14,13,15,15,15,15,15,14,15,0,14,14,14,14,15,15,16,15,16,0,4,0,0,0,0];
                var line2 = [2,0,0,0,0,1,2,1,1,0,0,4,5,4,3,3,3,0,0,1,0,0,0,1,0,0,6,1,0,0,0,0,6,7,1,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,1,0,4,1,1,1,1,1,1,2,1,1,1,0,1,1,2,1,0,5,1,0,1,1,5,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,0,0,1,1,0,1,1,1,2,0,1,1,1,1,1,0,1,0,0,1,2,1,1,1,0,3,4,0,1,7,1,1,1,1,0,0,2,0,0,0,0,0,1,0,0,1,1,1,1,0,1,0,1,0,0,9,0,0,0,0];
                var line3 = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1];

var ticks = [152,153,154,155,156,157,158,159,160,161];$.jqplot('line', [line1, line2, line3], {
        animate: true,
axesDefaults:{min:0,tickInterval: 1},        seriesDefaults: {
            rendererOptions: {
                smooth: true
            }
        },
        series: [{lineWidth: 1.5, label: 'Passed'},
            {lineWidth: 1.5, label: 'Failed'},
            {lineWidth: 1.5, label: 'Skipped'}],
        axes: {
            xaxis: {
                label: "Test Iterations <font size = 1> <i> (The graph illustrates last 10 executions) </i> </font>",
                ticks: ticks,
                tickOptions: {
                    formatString: "%'d "
                },
                pad: 1.2,
                rendererOptions: {
                    tickInset: 0.3,
                    minorTicks: 1
                }
            },
            yaxis: {
                label: "No.of Test Cases"
                ,tickOptions: {
                    formatString: "%'d tc "
                },
            }
        },
        highlighter: {
            show: true,
            sizeAdjust: 10,
            tooltipLocation: 'n',
            tooltipAxes: 'y',
            tooltipFormatString: '%d :&nbsp;<b><i><span style="color:black;">Test Cases</span></i></b>',
            useAxesFormatters: false
        },
        cursor: {
            show: true
        },
        grid: {background: '#ffffff', drawGridLines: true, gridLineColor: '#cccccc', borderColor: '#cccccc',
            borderWidth: 0.5, shadow: false},
        legend: {show: true, placement: 'outside', location: 'e'},
        seriesColors: ["#7BB661", "#E03C31", "#21ABCD"]
    });
});
