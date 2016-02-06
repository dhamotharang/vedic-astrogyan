(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('NatalChartController',
			NatalChartController);

	NatalChartController.$inject = [ 'ChartService' ];
	function NatalChartController(ChartService) {
		var vm = this;

		vm.panelTitle = ' < Rashi Chart >';
		vm.chartType = 'D1';
		vm.zodiacMap = d3.scale.ordinal().domain(
				[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ]).range(
				[ "ARE", "TAU", "GEM", "CAN", "LEO", "VIR", "LIB", "SCO",
						"SAG", "CAP", "AQU", "PIS" ]);

		vm.nakMap = d3.scale.ordinal().domain(
				[ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
						18, 19, 20, 21, 22, 23, 24, 25, 26, 27 ]).range(
				[ "", "Aswini", "Bharani", "Krithika", "Rohini", "Mrigashiras",
						"Arudra", "Punarvasu", "Pushyami", "Ashlesha", "Magha",
						"PoorvaPhalguni", "UthraPhalguni", "Hastha", "Chitra",
						"Swaathi", "Vishaakha", "Anuraadha", "Jyeshta",
						"Moola", "PoorvaShaada", "UthraShaada", "Shraavan",
						"Dhanishta", "Shathabhisha", "PoorvaBhadra",
						"UthraBhadra", "Revathi" ]);

		vm.chartData = [ {
			id : "H1",
			content : {},
			layout : {
				points : "200,0,100,100,200,200,300,100",
				text : {
					"x" : 175,
					"y" : 90
				}
			}
		}, {
			id : "H2",
			content : {},
			layout : {
				points : "0,0,200,0,100,100",
				text : {
					"x" : 70,
					"y" : 20
				}
			}
		}, {
			id : "H3",
			content : {},
			layout : {
				points : "0,0,0,200,100,100",
				text : {
					"x" : 15,
					"y" : 90
				}
			}
		}, {
			id : "H4",
			content : {},
			layout : {
				points : "200,200,100,100,0,200,100,300",
				text : {
					"x" : 70,
					"y" : 180
				}
			}
		}, {
			id : "H5",
			content : {},
			layout : {
				points : "0,200,0,400,100,300",
				text : {
					"x" : 15,
					"y" : 290
				}
			}
		}, {
			id : "H6",
			content : {},
			layout : {
				points : "0,400,100,300,200,400",
				text : {
					"x" : 70,
					"y" : 350
				}
			}
		}, {
			id : "H7",
			content : {},
			layout : {
				points : "200,200,100,300,200,400,300,300",
				text : {
					"x" : 175,
					"y" : 270
				}
			}
		}, {
			id : "H8",
			content : {},
			layout : {
				points : "200,400,300,300,400,400",
				text : {
					"x" : 270,
					"y" : 350
				}
			}
		}, {
			id : "H9",
			content : {},
			layout : {
				points : "300,300,400,200,400,400",
				text : {
					"x" : 335,
					"y" : 290
				}
			}
		}, {
			id : "H10",
			content : {},
			layout : {
				points : "200,200,300,100,400,200,300,300",
				text : {
					"x" : 270,
					"y" : 180
				}
			}
		}, {
			id : "H11",
			content : {},
			layout : {
				points : "400,200,400,0,300,100",
				text : {
					"x" : 335,
					"y" : 90
				}
			}
		}, {
			id : "H12",
			content : {},
			layout : {
				points : "200,0, 400,0, 300,100",
				text : {
					"x" : 270,
					"y" : 20
				}
			}
		} ];
		
		(function init() {
			prepareChart(vm.chartType);
		})();

		function prepareChart(chartType) {

			ChartService.getChartData(chartType).then(function(resChartData) {
				console.log("res =" + resChartData);

				for (var i = 0; i < vm.chartData.length; i++) {
					for (var j = 0; j < resChartData.length; j++) {
						if (resChartData[j].id == vm.chartData[i].id) {
							vm.chartData[i].content = resChartData[j].content;
						}
					}
				}
				console.log("js =" + vm.chartData);
				renderChart(vm.chartData);
			});
		};
	
		function renderChart(chartData) {
			// var chart_data = d3.json("chart_data.json");
			var svg = d3.select("#natal_chart_panel").append("svg").attr("id",
					"birthChart").attr("width", 400).attr("height", 400);

			var houses = svg.selectAll("polygon").data(vm.chartData).enter()
					.append("polygon").attr("id", function(d) {
						return d.id;
					}) // x,y points
					.attr("points", function(d) {
						return d.layout.points;
					}); // x,y points

			var houseText = svg.selectAll("g").data(vm.chartData).enter().append(
					"g").append("text").attr("y", function(d) {
				return d.layout.text.y;
			}) // set y position of bottom of text
			.append("tspan").attr("x", function(d) {
				return d.layout.text.x;
			}).attr("class", "zodiac").text(function(d) {
				return vm.zodiacMap(d.content.zod);
			}) // define the text to display
			.append("tspan").attr("x", function(d) {
				return d.layout.text.x;
			}).attr("dy", 15).attr("dx", -10).attr("class", "planet").text(
					function(d) {
						return d.content.planets;
					}) // define the text to display
			.append("tspan").attr("x", function(d) {
				return d.layout.text.x;
			}).attr("dy", 15).attr("dx", -10).attr("class", "nakshatra").text(
					function(d) {
						return vm.nakMap(d.content.nak);
					});
		}
		;
	}
})();
