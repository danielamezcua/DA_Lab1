angular.module('app.controllers', [])
  
.controller('portfolioCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {
	$scope.mdl = {};
	$scope.mdl.symbol = "";

}])
   
.controller('detailsCtrl', ['$scope', '$stateParams', '$http',// The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams, $http) {
	$scope.mdl = {};
	$scope.mdl.symbol = $stateParams.symbol;
	$scope.mdl.currentStockPrice = "";
	$scope.mdl.dateOfAnalysis = "";
	$scope.mdl.trend = 0;
	$scope.mdl.recommendation = "";
	$scope.mdl.colorRecommendation = "#ED4C4C";

	url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + $scope.mdl.symbol + "&apikey=ZRGN4QXXHNVJ7MIS";

	//Make the request
	$http.get(url).then(function successCallback(response){
		console.log(url);
		$scope.mdl.currentStockPrice = Number(response["Global Quote"]["05. price"]);
		$scope.mdl.dateOfAnalysis = response["Global Quote"]["07. latest trading day"];
		$scope.mdl.trend = $scope.mdl.currentStockPrice - Number(response["Global Quote"]["08. previous close"]);
		$scope.recommendation = (($scope.mdl.trend > 0) ? 'Keep!' : 'Sell now!');
		$scope.colorRecommendation = (($scope.mdl.trend > 0) ? '#3bc63d' : '#ED4C4C');
	}, function errorCalback(response){
		console.log(response);
	});
}])
 