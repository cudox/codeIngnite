(function () {
'use strict';
var style = {};
	angular.module('myApp', [])
	.controller('myCtrl',  ["$scope", '$http', function ($scope, $http) {
            $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
            
            $scope.num = 0;
            $scope.k = 0;
            $scope.message = "";
            $scope.lista = [];
            $scope.hora = 0;
            $scope.minutos = 0;
            $scope.addValores = function(){
                $scope.lista = [];
              for(var i = 0; i < $scope.num; i++){
                  $scope.lista.push({'id':'lista'+i, 'index': i + 1});
              }
            };
            $scope.sendPost = function() {
                    $http({
                            url : 'AngryChildren',
                            method : "POST",
                            //dataType: "json",
                            data : {
                                'accion' : 0, 'num' : $scope.num, 'k' : $scope.k, 'lista': $scope.lista
                            }
                    }).then(function(response) {
                            $scope.message = response.data;
                    }, function(response) {
                            $scope.message = response;
                    });
            };
            $scope.calcularHora = function () {
                    $http({
                            url : '../AngryChildren',
                            method : "POST",
                            //dataType: "json",
                            data : {
                                'accion' : 1, 'hora' : $scope.hora, 'minutos': $scope.minutos
                            }
                    }).then(function(response) {
                            $scope.message = response.data;
                    }, function(response) {
                            $scope.message = response;
                    });
            };
        }]);
})();