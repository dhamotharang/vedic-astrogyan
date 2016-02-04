(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('NatalChartController',
			NatalChartController);

	NatalChartController.$inject = [ '$location', '$scope', 'AuthService',
			'FlashService' ];
	function NatalChartController($location, $scope, AuthService, FlashService) {
		var vm = this;

		vm.panelTitle = ' < Rashi Chart >';
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
			zod : 3,
			planets : [ "MON", "KET" ],
			nak : 3,
			points : "200,0,100,100,200,200,300,100",
			text_layout : {
				"x" : 175,
				"y" : 90
			}
		}, {
			id : "H2",
			zod : 4,
			planets : [],
			nak : 0,
			points : "0,0,200,0,100,100",
			text_layout : {
				"x" : 70,
				"y" : 20
			}
		}, {
			id : "H3",
			zod : 5,
			planets : [],
			nak : 0,
			points : "0,0,0,200,100,100",
			text_layout : {
				"x" : 15,
				"y" : 90
			}
		}, {
			id : "H4",
			zod : 6,
			planets : [],
			nak : 0,
			points : "200,200,100,100,0,200,100,300",
			text_layout : {
				"x" : 70,
				"y" : 180
			}
		}, {
			id : "H5",
			zod : 7,
			planets : [ "MAR" ],
			nak : 4,
			points : "0,200,0,400,100,300",
			text_layout : {
				"x" : 15,
				"y" : 290
			}
		}, {
			id : "H6",
			zod : 8,
			planets : [ "VEN", "MER" ],
			nak : 3,
			points : "0,400,100,300,200,400",
			text_layout : {
				"x" : 70,
				"y" : 350
			}
		}, {
			id : "H7",
			zod : 9,
			planets : [ "JUP", "SUN", "RAH" ],
			nak : 3,
			points : "200,200,100,300,200,400,300,300",
			text_layout : {
				"x" : 175,
				"y" : 270
			}
		}, {
			id : "H8",
			zod : 10,
			planets : [],
			nak : 0,
			points : "200,400,300,300,400,400",
			text_layout : {
				"x" : 270,
				"y" : 350
			}
		}, {
			id : "H9",
			zod : 11,
			planets : [],
			nak : 0,
			points : "300,300,400,200,400,400",
			text_layout : {
				"x" : 335,
				"y" : 290
			}
		}, {
			id : "H10",
			zod : 12,
			planets : [],
			nak : 0,
			points : "200,200,300,100,400,200,300,300",
			text_layout : {
				"x" : 270,
				"y" : 180
			}
		}, {
			id : "H11",
			zod : 1,
			planets : [],
			nak : 0,
			points : "400,200,400,0,300,100",
			text_layout : {
				"x" : 335,
				"y" : 90
			}
		}, {
			id : "H12",
			zod : 2,
			planets : [ "SAT" ],
			nak : 12,
			points : "200,0, 400,0, 300,100",
			text_layout : {
				"x" : 270,
				"y" : 20
			}
		} ];
		(function init() {
			renderChart(vm.chartData);

		})();

		function renderChart(chartData) {
			// var chart_data = d3.json("chart_data.json");
			var svg = d3.select("#natal_chart_panel").append("svg").attr("id",
					"birthChart").attr("width", 400).attr("height", 400);

			var houses = svg.selectAll("polygon").data(chartData).enter()
					.append("polygon").attr("id", function(d) {
						return d.id;
					}) // x,y points 
					.attr("points", function(d) {
						return d.points;
					}); // x,y points

			var houseText = svg.selectAll("g").data(chartData).enter().append(
					"g").append("text").attr("y", function(d) {
				return d.text_layout.y;
			}) // set y position of bottom of text 
			.append("tspan").attr("x", function(d) {
				return d.text_layout.x;
			}).attr("class", "zodiac").text(function(d) {
				return vm.zodiacMap(d.zod);
			}) // define the text to display 
			.append("tspan").attr("x", function(d) {
				return d.text_layout.x;
			}).attr("dy", 15).attr("dx", -10).attr("class", "planet").text(
					function(d) {
						return d.planets;
					}) // define the text to display 
			.append("tspan").attr("x", function(d) {
				return d.text_layout.x;
			}).attr("dy", 15).attr("dx", -10).attr("class", "nakshatra").text(
					function(d) {
						return vm.nakMap(d.nak);
					});
		};
	}
})();
