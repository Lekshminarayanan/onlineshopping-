/**
 * 
 */
app.controller('UserController',function($scope,$location,UserService){
	$scope.registerUser=function(user){
		UserService.registerUser(user).then(
		function(response){
			alert('Registered Successfully... please login again..')
			$location.path('/home')
		},function(response){
			$scope.error=response.data
		})
		}
	$scope.login=function(user){
		console.log('UserController -> login')
		console.log(user)
		UserService.login(user).then(function(response){
		console.log('success')
		console.log(response.data)
		$location.path('/home')
		},function(response){
		console.log('error')
		$scope.error=response.data
		$location.path('/login')
	})
	}
	
})