(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('VargaChartController',
			VargaChartController);

	VargaChartController.$inject = [ 'ChartService', 'ReferenceDataService' ];
	function VargaChartController(ChartService, ReferenceDataService) {
		var vm = this;

		vm.panelTitle = ' < Div Chart >';
		vm.vargas = [];
		vm.vargaChartSelected = {};
		vm.changeInput = changeInput;

		vm.zodiacMap = d3.scale.ordinal().domain(
				[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ]).range(
				[ "ARE", "TAU", "GEM", "CAN", "LEO", "VIR", "LIB", "SCO",
						"SAG", "CAP", "AQU", "PIS" ]);

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
			loadAllVargaOpts();
		})();

		function loadAllVargaOpts() {
			ReferenceDataService.getData('vargas').then(function(vargas) {
				vm.vargas = vargas;
				vm.vargaChartSelected = vm.vargas[0];

				prepareChart(vm.vargaChartSelected.code);
			});
		}

		function prepareChart(chartType) {

			ChartService
					.getVargaChartData(chartType)
					.then(
							function(resChartData) {
								for (var i = 0; i < vm.chartData.length; i++) {
									for (var j = 0; j < resChartData.length; j++) {
										if (resChartData[j].id == vm.chartData[i].id) {
											vm.chartData[i].content = resChartData[j].content;
										}
									}
								}
								renderChart(vm.chartData);
							});
		}

		function renderChart(chartData) {
			// var chart_data = d3.json("chart_data.json");
			var svg = d3.select("#varga_chart_panel").append("svg").attr("id",
					"birthChart").attr("width", 400).attr("height", 400);

			var houses = svg.selectAll("polygon").data(vm.chartData).enter()
					.append("polygon").attr("id", function(d) {
						return d.id;
					}) // x,y points
					.attr("points", function(d) {
						return d.layout.points;
					}); // x,y points

			var houseText = svg.selectAll("g").data(vm.chartData).enter()
					.append("g").append("text").attr("y", function(d) {
						return d.layout.text.y;
					});

			houseText.append("tspan").attr("x", function(d) {
				return d.layout.text.x;
			}).attr("class", "zodiac").text(function(d) {
				return vm.zodiacMap(d.content.zod);
			}); // define the text to display
		//	houseText.append("tspan").attr("class", "lord").text(function(d) {
		//		return "[" + d.content.lord + "]";
		//	}); // define the text to display
			houseText.append("tspan").attr("x", function(d) {
				return d.layout.text.x;
			}).attr("dy", 15).attr("dx", -10).attr("class", "planet").text(
					function(d) {
						return d.content.planets;
					}); // define the text to display
		}

		function changeInput() {
			var svg = d3.select("#varga_chart_panel");
			svg.selectAll("*").remove();
			prepareChart(vm.vargaChartSelected.code);
		}
	}
})();
