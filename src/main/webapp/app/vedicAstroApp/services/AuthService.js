(function() {
	'use strict';

	angular.module('vedicAstroApp').factory('AuthService', AuthService);

	AuthService.$inject = [ '$http', '$cookieStore', '$rootScope' ];
	function AuthService($http, $cookieStore, $rootScope) {
		var service = {};

		service.login = login;
		service.setCredentials = setCredentials;
		service.clearCredentials = clearCredentials;
		service.updateLastViewedMember = updateLastViewedMember;
		service.getAllAdmins = getAllAdmins;
		service.loadAdmin = loadAdmin;
		service.saveAdmin = saveAdmin;
		
		return service;

		function login(username, password, callback) {

			$http.post('/api/login', {
				email : username,
				password : password
			}).success(function(response) {
				callback(response);
			});

		}

		function setCredentials(username, password, responseData) {
			var authdata = Base64.encode(username + ':' + password);

			$rootScope.globals = {
				currentUser : {
					username : username,
					authdata : authdata,
					firstName : responseData.firstName,
					lastName : responseData.lastName,
					role : responseData.role,
					memberId : responseData.lastViewedPid,
					id : responseData.id
				}
			};

			console.log($rootScope.globals);
			$http.defaults.headers.common['Authorization'] = 'Basic '
					+ authdata; // jshint ignore:line
			$cookieStore.put('globals', $rootScope.globals);
		}

		function clearCredentials() {
			$rootScope.globals = {};
			$cookieStore.remove('globals');
			$http.defaults.headers.common.Authorization = 'Basic';
		}

		function updateLastViewedMember() {

			return $http.post('/api/update/lastViewedMember', {
				id : $rootScope.globals.currentUser.id,
				lastViewedPid : $rootScope.globals.currentUser.memberId
			}).then(handleSubmitSuccess,
					handleError('Error updating last viewed member'));
		}
		
		function getAllAdmins() {
			return $http.get('/api/user/all').then(handleGetSuccess,
					handleError('Error getting all users'));
		}

		function loadAdmin(id) {
			return $http.get('/api/user/get/' + id).then(handleGetSuccess,
					handleError('Error loading Admin'));
		}
		
		function saveAdmin(admin) {
			return $http.post('/api/user/save', admin).then(handleSubmitSuccess,
					handleError('Error while saving user'));
		}
		
		function handleGetSuccess(res) {
			return res.data.responseData;
		}

		function handleSubmitSuccess(res) {
			return res.data;
		}

		function handleSubmitWithResponse(res) {
			return res.data.responseData;
		}

		function handleError(error) {
			return function() {
				return {
					success : false,
					message : error
				};
			};
		}
	}
	// Base64 encoding service used by AuthenticationService
	var Base64 = {

		keyStr : 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',

		encode : function(input) {
			var output = "";
			var chr1, chr2, chr3 = "";
			var enc1, enc2, enc3, enc4 = "";
			var i = 0;

			do {
				chr1 = input.charCodeAt(i++);
				chr2 = input.charCodeAt(i++);
				chr3 = input.charCodeAt(i++);

				enc1 = chr1 >> 2;
				enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
				enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
				enc4 = chr3 & 63;

				if (isNaN(chr2)) {
					enc3 = enc4 = 64;
				} else if (isNaN(chr3)) {
					enc4 = 64;
				}

				output = output + this.keyStr.charAt(enc1)
						+ this.keyStr.charAt(enc2) + this.keyStr.charAt(enc3)
						+ this.keyStr.charAt(enc4);
				chr1 = chr2 = chr3 = "";
				enc1 = enc2 = enc3 = enc4 = "";
			} while (i < input.length);

			return output;
		},

		decode : function(input) {
			var output = "";
			var chr1, chr2, chr3 = "";
			var enc1, enc2, enc3, enc4 = "";
			var i = 0;

			// remove all characters that are not A-Z, a-z, 0-9, +, /, or =
			var base64test = /[^A-Za-z0-9\+\/\=]/g;
			if (base64test.exec(input)) {
				window
						.alert("There were invalid base64 characters in the input text.\n"
								+ "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n"
								+ "Expect errors in decoding.");
			}
			input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

			do {
				enc1 = this.keyStr.indexOf(input.charAt(i++));
				enc2 = this.keyStr.indexOf(input.charAt(i++));
				enc3 = this.keyStr.indexOf(input.charAt(i++));
				enc4 = this.keyStr.indexOf(input.charAt(i++));

				chr1 = (enc1 << 2) | (enc2 >> 4);
				chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
				chr3 = ((enc3 & 3) << 6) | enc4;

				output = output + String.fromCharCode(chr1);

				if (enc3 != 64) {
					output = output + String.fromCharCode(chr2);
				}
				if (enc4 != 64) {
					output = output + String.fromCharCode(chr3);
				}

				chr1 = chr2 = chr3 = "";
				enc1 = enc2 = enc3 = enc4 = "";

			} while (i < input.length);

			return output;
		}
	};

})();