(function() {
	'use strict';

	angular.module('vedicAstroApp').controller('HouseStrengthsController',
			HouseStrengthsController);

	HouseStrengthsController.$inject = [ '$location', '$scope', 'AuthService',
			'FlashService' ];
	function HouseStrengthsController($location, $scope, AuthService,
			FlashService) {
		var vm = this;

		vm.panelTitle = '< House Strengths >';
		vm.selectedHouseIndex = 0;
		vm.popupTemplateUrl = 'app/vedicAstroApp/modals/house_strength_pop_up.html';
		vm.getHouseSelected = getHouseSelected;
		vm.setHouseSelected = setHouseSelected;
		vm.houseStrengths = [ {
			id : 'h1_gauge',
			house : 'H1',
			score : 39.6
		}, {
			id : 'h2_gauge',
			house : 'H2',
			score : 43.5
		}, {
			id : 'h3_gauge',
			house : 'H3',
			score : 23.5
		}, {
			id : 'h4_gauge',
			house : 'H4',
			score : 13.5
		}, {
			id : 'h5_gauge',
			house : 'H5',
			score : 42.5
		}, {
			id : 'h6_gauge',
			house : 'H6',
			score : 26.5
		}, {
			id : 'h7_gauge',
			house : 'H7',
			score : 27.0
		}, {
			id : 'h8_gauge',
			house : 'H8',
			score : 51.0
		}, {
			id : 'h9_gauge',
			house : 'H9',
			score : 12.5
		}, {
			id : 'h10_gauge',
			house : 'H10',
			score : 22.0
		}, {
			id : 'h11_gauge',
			house : 'H11',
			score : 17.4
		}, {
			id : 'h12_gauge',
			house : 'H12',
			score : 57.0
		} ];
		vm.houseSignificances = {
			headers : [ 'House','Body part', 'Mental', 'Accumulate', 'Action',
					'Personality trait', 'Relationship(s)' ],
			significances : [ {
				house : 'H1',
				bodyPart : 'H1 body part',
				mental : 'H1 mental',
				accumulate : 'H1 accumulate',
				action : 'H1 action',
				personalityTrait : 'H1 personality trait',
				relationship : 'H1 relationship'
			}, {
				house : 'H2',
				bodyPart : 'H2 body part',
				mental : 'H2 mental',
				accumulate : 'H2 accumulate',
				action : 'H2 action',
				personalityTrait : 'H2 personality trait',
				relationship : 'H2 relationship'
			}, {
				house : 'H3',
				bodyPart : 'H3 body part',
				mental : 'H3 mental',
				accumulate : 'H3 accumulate',
				action : 'H3 action',
				personalityTrait : 'H3 personality trait',
				relationship : 'H3 relationship'
			}, {
				house : 'H4',
				bodyPart : 'H4 body part',
				mental : 'H4 mental',
				accumulate : 'H4 accumulate',
				action : 'H4 action',
				personalityTrait : 'H4 personality trait',
				relationship : 'H4 relationship'
			}, {
				house : 'H5',
				bodyPart : 'H5 body part',
				mental : 'H5 mental',
				accumulate : 'H5 accumulate',
				action : 'H5 action',
				personalityTrait : 'H5 personality trait',
				relationship : 'H5 relationship'
			}, {
				house : 'H6',
				bodyPart : 'H6 body part',
				mental : 'H6 mental',
				accumulate : 'H6 accumulate',
				action : 'H6 action',
				personalityTrait : 'H6 personality trait',
				relationship : 'H6 relationship'
			}, {
				house : 'H7',
				bodyPart : 'H7 body part',
				mental : 'H7 mental',
				accumulate : 'H7 accumulate',
				action : 'H7 action',
				personalityTrait : 'H7 personality trait',
				relationship : 'H7 relationship'
			}, {
				house : 'H8',
				bodyPart : 'H8 body part',
				mental : 'H8 mental',
				accumulate : 'H8 accumulate',
				action : 'H8 action',
				personalityTrait : 'H8 personality trait',
				relationship : 'H8 relationship'
			}, {
				house : 'H9',
				bodyPart : 'H9 body part',
				mental : 'H9 mental',
				accumulate : 'H9 accumulate',
				action : 'H9 action',
				personalityTrait : 'H9 personality trait',
				relationship : 'H9 relationship'
			}, {
				house : 'H10',
				bodyPart : 'H10 body part',
				mental : 'H10 mental',
				accumulate : 'H10 accumulate',
				action : 'H10 action',
				personalityTrait : 'H10 personality trait',
				relationship : 'H10 relationship'
			}, {
				house : 'H11',
				bodyPart : 'H11 body part',
				mental : 'H11 mental',
				accumulate : 'H11 accumulate',
				action : 'H11 action',
				personalityTrait : 'H11 personality trait',
				relationship : 'H11 relationship'
			}, {
				house : 'H12',
				bodyPart : 'H12 body part',
				mental : 'H12 mental',
				accumulate : 'H12 accumulate',
				action : 'H12 action',
				personalityTrait : 'H12 personality trait',
				relationship : 'H12 relationship'
			} ]
		};
		(function init() {
			constructGauges(vm.houseStrengths);
		})();

		function setHouseSelected(index){
			vm.selectedHouseIndex = index;
		};
		
		function getHouseSelected(){
			return vm.houseSignificances.significances[vm.selectedHouseIndex];
		};

		
		function constructGauges(houseStrengths) {

			for (var i = 0; i < houseStrengths.length; i++) {
				var houseStrength = houseStrengths[i];
				constructGauge(houseStrength);
			}
		}
	}
	;

	function constructGauge(houseStrength) {
		var gauge = new JustGage({
			id : houseStrength.id,
			value : houseStrength.score,
			title : houseStrength.house,
			min : 0,
			max : 60,
			decimals : 2,
			gaugeWidthScale : 0.9,
			titleMinFontSize : 14,
			valueMinFontSize : 14,
			customSectors : [ {
				color : "red",
				lo : 0,
				hi : 20
			}, {
				color : "yellow",
				lo : 20,
				hi : 40
			}, {
				color : "green",
				lo : 40,
				hi : 60
			} ],
			shadowOpacity : 1,
			shadowSize : 3,
			shadowVerticalOffset : 5,
			pointer : true
		});
	}
	;
})();
