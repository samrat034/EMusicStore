var cartApp = angular.module("cartApp",[]);

cartApp.controller("cartCtrl", function ($scope, $http) {
    $scope.refreshCart=function (cartId) {
        $http.get('/eMusicStore/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
        });

    };

    $scope.clearCart=function () {
        $http.delete('/eMusicStore/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));

    };

    $scope.initCartId=function (cartId) {
        $scope.cartId=cartId;
        $scope.refreshCart(cartId);

    };


    $scope.addToCart = function (productId) {
        alert("I am at addcart");
        //console.log(productId);
        $http.put('/eMusicstore/rest/cart/add/' +productId)
            .success(function (data) {
                alert("Product Successfully added to the Cart!");
            }).error(function _errorPut() {
        });
    };

    $scope.removeFromCart=function (productId) {
        $http.put('/eMusicStore/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/eMusicStore/rest/cart/cartId'));

        });

    };

});



