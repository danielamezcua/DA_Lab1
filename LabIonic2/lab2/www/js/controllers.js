//$scope is a container that manages all the data elements in the model of the current view
//$stateParams is a container that manages all the data elements that were sent to the
//current iew from the previous
angular.module('app.controllers', [])
  
.controller('indexCtrl', ['$scope', '$stateParams', '$http', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {
	$scope.cityName = "";
}])
   
.controller('statsCtrl', ['$scope', '$stateParams','$http', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams, $http) {
	$scope.mdl = {};
	$scope.mdl.cityName = "";
	$scope.mdl.temperature = "";
	$scope.mdl.windSpeed = "";	
	$scope.mdl.description = "";
	//extract the city name
	city = $stateParams.cityName;
	//do the request
	url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&mode=JSON&appid=4c170c3205b6541cd3fb2638524c62e4";
	$http.get(url).then(function successCallback(response){
		$scope.mdl.cityName = response.data.name;
		$scope.mdl.temperature = response.data.main.temp;
		$scope.mdl.windSpeed = response.data.wind.speed;	
		$scope.mdl.description = response.data.weather.description;
	}, function errorCalback(response){
		$scope.mdl.cityName = response.data;
	});
}])
