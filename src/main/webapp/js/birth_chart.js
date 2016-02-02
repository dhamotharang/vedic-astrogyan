console.log('Loading birth chart');

   var zodiacMap = d3.scale.ordinal()
                            .domain([1,2,3,4,5,6,7,8,9,10,11,12])
                            .range(["ARE","TAU","GEM","CAN","LEO","VIR","LIB","SCO","SAG","CAP","AQU","PIS"]);

            var nakMap = d3.scale.ordinal()
                            .domain([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27])
                            .range(["","Aswini","Bharani","Krithika","Rohini","Mrigashiras","Arudra","Punarvasu","Pushyami","Ashlesha",          "Magha","PoorvaPhalguni","UthraPhalguni","Hastha","Chitra","Swaathi","Vishaakha","Anuraadha","Jyeshta","Moola","PoorvaShaada","UthraShaada",
                                    "Shraavan","Dhanishta","Shathabhisha","PoorvaBhadra","UthraBhadra","Revathi"]);
            
            d3.json("chart_data.json", function(chartData) {
                renderChart(chartData);
            });

            function renderChart(chartData){
           // var chart_data = d3.json("chart_data.json");
            var svg = d3.select("#natal_chart")
                                .append("svg")
                                .attr("id","birthChart")
                                .attr("width",400)
                                .attr("height",400);
            
            var houses = svg.selectAll("polygon").data(chartData)
                            .enter().append("polygon")
                            .attr("id", function(d){return d.id;})  // x,y points 
                            .attr("points", function(d){ return d.points;});  // x,y points
            
            var houseText = svg.selectAll("g").data(chartData)
                            .enter().append("g")
                                  .append("text")
                                  .attr("y", function(d){ return d.text_layout.y;})           // set y position of bottom of text 
                                  .append("tspan")
                                  .attr("x", function(d){ return d.text_layout.x;})
                                  .attr("class", "zodiac")
                                  .text(function(d){ return zodiacMap(d.zod);})     // define the text to display 
                                  .append("tspan")
                                  .attr("x", function(d){ return d.text_layout.x;})
                                  .attr("dy", 15)
                                  .attr("dx", -10)
                                  .attr("class", "planet")
                                  .text(function(d){ return d.planets;})     // define the text to display 
                                  .append("tspan")
                                  .attr("x", function(d){ return d.text_layout.x;})
                                  .attr("dy", 15)
                                  .attr("dx", -10)
                                  .attr("class", "nakshatra")
                                  .text(function(d){ return nakMap(d.nak);});     
            }
