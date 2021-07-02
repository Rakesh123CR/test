            $(document).ready(function(){
                var line1 = [7,0,7,7,7,0,0,0,7,0,0,1,0,0,7,6,7,1,0,4,0,1,1,0,0,0,0,6,6,6,0,0,6,6,0,0,0,0,0,0,0,0];
                var line2 = [0,0,0,0,0,0,0,0,0,0,0,6,0,0,0,1,0,6,0,3,0,6,6,0,0,0,0,1,1,1,0,0,1,1,0,0,8,0,0,8,8,8];
                var line3 = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,8,8,7,7,8,8,8];

var ticks = [33,34,35,36,37,38,39,40,41,42];$.jqplot('line', [line1, line2, line3], {
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
