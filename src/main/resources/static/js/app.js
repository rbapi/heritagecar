'use strict';

// Creating angular Application with module name "HeritageCarService"
var app = angular.module('HeritageCarService',[]);

app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);