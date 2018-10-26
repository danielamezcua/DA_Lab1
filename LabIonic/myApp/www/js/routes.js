angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    

      .state('myDummyApp', {
    url: '/index',
    templateUrl: 'templates/myDummyApp.html',
    controller: 'myDummyAppCtrl'
  })

  .state('random', {
    url: '/random',
    templateUrl: 'templates/random.html',
    controller: 'randomCtrl'
  })

  .state('torreN', {
    url: '/torreon',
    templateUrl: 'templates/torreN.html',
    controller: 'torreNCtrl'
  })

$urlRouterProvider.otherwise('/index')


});