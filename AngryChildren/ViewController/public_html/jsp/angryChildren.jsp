<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<html ng-app="myApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <script src="js/angular.min.js"></script>
        <script src="js/app.js"></script>
        <link rel="stylesheet" href="styles/bootstrap.min.css">
        <title>Angry Children</title>
    </head>
    <body class="content">
	<div ng-controller="myCtrl" class="panel-body">
                <div class="panel-heading">
                    <h4 class="panel-title">Angry Children</h4>
                </div>
                <div class="panel-body">
		<form ng-submit="sendPost()" class="form">
			<label class="col-sm-2">Número de elementos</label>
                        <div class="col-sm-4">
                            <input ng-model="num" ng-change="addValores()" class="form-control"/>
                        </div>
                        <label class="col-sm-2">Cantidad</label>
                        <div class="col-sm-4">
                            <input ng-model="k" class="form-control"/>
                        </div>
                        <div ng-repeat="valor in lista">
                            <label class="col-sm-2">Valor {{valor.index}}</label>
                            <div class="col-sm-4">
                                <input ng-model="valor.valor" class="form-control"/>
                            </div>
                        </div>
                        </p>
                        <div class="col-sm-3">
                            <button type="submit" class="form-control">Calcular</button>
                        </div>
		</form>
                </div>
		<p class="panel-footer">Respuesta: {{message}}</p>
	</div>
    </body>
</html>