angular.module('hello', [])
.controller('BusinessCtrl', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {


	$rootScope.title = '流水列表';
 
    $scope.currentPage = 1;
    $scope.totalPage = 1;
    $scope.pageSize = 3;
    $scope.pages = [];
    $scope.endPage = 1;
	
	$scope.cx = function(){
		 $scope.load();
	};
	
	$scope.getCount = function(key){
    	$http({
            method  : 'POST',
            data    : $.param({key:key}),
            url     : 'http://localhost:8080/test3/user/getCount',
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function(data) {
            	
            	alert(data);
            	
            	$scope.total = data;
                 
            });
    };
 
    $scope.load = function () {			
    	$http({
            method  : 'POST',
            data    : $.param(params = {page:$scope.currentPage,size:$scope.pageSize,key:$scope.key}),
            url     : 'http://localhost:8080/test3/user/list',
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
        })
        	.success(function (data) {
        		alert(data);
        		
        		$scope.items = data;
        		
//        		$scope.total = data.count;
	            
	            //获取总页数
	            $scope.totalPage = Math.ceil($scope.total / $scope.pageSize);
	            
	            $scope.endPage = $scope.totalPage;
	            //生成数字链接
		            if ($scope.currentPage > 1 && $scope.currentPage < $scope.totalPage) {
		                $scope.pages = [
		                    $scope.currentPage - 1,
		                    $scope.currentPage,
		                    $scope.currentPage + 1
		                ];
		            } else if ($scope.currentPage == 1 && $scope.totalPage > 1) {
		                $scope.pages = [
		                    $scope.currentPage,
		                    $scope.currentPage + 1
		                ];
		            } else if ($scope.currentPage == $scope.totalPage && $scope.totalPage > 1) {
		                $scope.pages = [
		                    $scope.currentPage - 1,
		                    $scope.currentPage
		                ];
		            }
	        }
        	
        	
        );
		
    };
    $scope.getCount($scope.key);
    $scope.load();
    $scope.sortName="id";
    $scope.sortType="-";

    $scope.sort = function(id){
        $scope.sortName = id;

        if($scope.sortType === ""){
            $scope.sortType="-";
        }else{
            $scope.sortType="";
        }
    };
    $scope.next = function () {
        if ($scope.currentPage < $scope.totalPage) {
            $scope.currentPage++;
            $scope.load();
        }
    };
 
    $scope.prev = function () {
        if ($scope.currentPage > 1) {
            $scope.currentPage--;
            $scope.load();
        }
    };
 
    $scope.loadPage = function (page) {
        $scope.currentPage = page;
        $scope.load();
    };
    
   //edit modal
    $scope.edit = function(id){
    	$scope.title = "修改用户信息";
    	$scope.id = id;
    	 angular.forEach($scope.items,function(item,index){
    		 if(item.u_ID == id){
    			 $scope.editData = item;
    			 $scope.oldData = angular.copy($scope.editData);
    			 return;
    		 }
    	 });
    	 
    	 $('#myModal').modal('show');
    	
    };
    //add modal
    $scope.add = function () {
    	$scope.title = "添加用户";
    	$scope.editData = null;
    	$('#myModal').modal('show');
    };
    
    
    
    var ckall = "";
    $scope.qx = function(){
    	ckall = "";
    	if($scope.all === undefined){
    		$scope.all=true;
    		$scope.xall=true;
    		angular.forEach($scope.items,function(item,index){
    			if(ckall == ""){
    				ckall = item.u_ID;
    			}else{
    				ckall +=","+item.u_ID;
    			}
    		});
    	}else{
    	
    	if($scope.all){
    		alert($scope.all);
    		
    		$scope.xall=false;

    		ckall= "";
    	}else{
    		alert($scope.all);
    		$scope.xall=true;
    		angular.forEach($scope.items,function(item,index){
    			if(ckall == ""){
    				ckall = item.u_ID;
    			}else{
    				ckall +=","+item.u_ID;
    			}
    		});
    	}}
    };
    $scope.dx = function(id){
    	
    	alert(ckall.contains(id));
    	if(ckall.contains(id)){
    		
			if(ckall.contains(","+id)){
				
				ckall = ckall.replace(","+id, "");
				
			}else{
				
				ckall = ckall.replace(id+",", "");
				
			}
    			
    	}else{
    		if(ckall == ""){
    			
    			ckall += id;
    			
    		}else{
    			
    			ckall += ","+id;
    			
    		}
    	}
    	alert(ckall);
    };
    $scope.sc = function(){
    	if(ckall == ""){
    		
    		alert("必须选中一项");
    		
    	}else{
    		alert(ckall);
    		$scope.delAll();
    	}
    	
    };
    
    $scope.delAll = function(){
    	$http({
            method  : 'POST',
            data    : $.param({ckall: ckall}),
            url     : 'http://localhost:8080/test3/user/deleteall',
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function(data) {
                if(data=="true"){
                	
             	   alert("删除成功");
             	   
             	  location.href="index.html";
                }
                else{
                 		 
               	   alert("删除失败");
               	   location.href="index.html";
                } 
            });
    };
    
    
    
    $scope.del = function(id){
    	$http({
            method  : 'POST',
            data    : $.param({id:id}),
            url     : 'http://localhost:8080/test3/user/delete',
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function(data) {
                if(data=="true"){
             	   alert("更新成功");
             	  angular.forEach($scope.items,function(item,index){
             		  if(item.u_ID == id){
             			  $scope.items.splice(index,1);
             		  }
             	  });
                }
                else{
             	  // angular.forEach($scope.data,function(item,index){
                 		 
               	   alert("更新失败");
               	   location.href="index.html";
                //  })
             	
                } 
                
            });
    };
    $scope.update = function(){
    	$http({
            method  : 'POST',
            data    : $.param($scope.editData),
            url     : 'http://localhost:8080/test3/user/update',
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
        })
            .success(function(data) {
            	console.log(data);
               if(data === "true"){
            	   alert("更新成功111");
//            	   angular.forEach($scope.items,function(item,index){
//              		  if(item.u_ID == $scope.editData.u_ID){
//              			  item = $scope.editData;
//              		  }
//              	  });
            	   
            	   location.href="index.html";
               }else if(data === "addtrue"){
            	   alert("新增成功！");
            	   location.href="index.html";
               }
               else{
            	  // angular.forEach($scope.data,function(item,index){
                		 
              	   alert("更新失败");
              	   
                 //})
               }   
               $('#myModal').modal('hide');
            });
    };
    
    
    
}]);
  