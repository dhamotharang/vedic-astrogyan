(function() {

	'use strict';

	angular.module('vedicAstroApp').controller('ChartProfileController',
			ChartProfileController);

	ChartProfileController.$inject = ['ProfileService'];

	function ChartProfileController(ProfileService) {
		var vm = this;

		vm.panelTitle = '< Personality Analysis >';
		vm.aspects = [ {
			id : 'body-tab',
			tabId : 'tabcontent1',
			fields : [ 'Entity Type', 'Name', 'Source', 'Impact' ],
			title : 'Body',
			data : []
		}, {
			id : 'mind-tab',
			tabId : 'tabcontent2',
			fields : [ 'Entity Type', 'Name', 'Source', 'Impact' ],
			title : 'Mind',
			data : []
		}, {
			id : 'soul-tab',
			tabId : 'tabcontent3',
			fields : [ 'Entity Type', 'Name', 'Source', 'Impact' ],
			title : 'Karmic',
			data : []
		} ];

		vm.activeTab = vm.aspects[0].id;
		vm.changeActiveTab = changeActiveTab;
		vm.isActiveTab = isActiveTab;

		(function init() {
			loadChartProfile();
		})();

		function loadChartProfile() {

			ProfileService.getChartProfile().then(function(chartProfile) {
				console.log(chartProfile);

				for (var i = 0; i < vm.aspects.length; i++) {

					var aspect = vm.aspects[i];

					if (aspect.id == 'body-tab') {
						aspect.data = chartProfile.body;
					} else if (aspect.id == 'mind-tab') {
						aspect.data = chartProfile.mind;
					} else if (aspect.id == 'soul-tab') {
						aspect.data = chartProfile.soul;
					}
				}
			});
		};
		
		function isActiveTab(tabId) {
			return tabId === vm.activeTab;
		};

		function changeActiveTab(tab) {
			vm.activeTab = tab;
		};
	}
	;

}());
