<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<html ng-app="myApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <script src="../js/angular.min.js"></script>
        <script src="../js/app.js"></script>
        <link rel="stylesheet" href="../styles/bootstrap.min.css">
        <title>Time in words</title>
    </head>
    <body class="content">
	<div ng-controller="myCtrl" class="panel-body">
                <div class="panel-heading">
                    <h4 class="panel-title">Time in words</h4>
                </div>
                <div class="panel-body">
		<form ng-submit="calcularHora()" class="form">
			<label class="col-sm-2">Hora</label>
                        <div class="col-sm-4">
                            <input ng-model="hora" class="form-control"/>
                        </div>
                        <label class="col-sm-2">Minutos</label>
                        <div class="col-sm-4">
                            <input ng-model="minutos" class="form-control"/>
                        </div>
                        <div class="col-sm-3">
                            <button type="submit" class="form-control">Calcular</button>
                        </div>
		</form>
                </div>
		<p class="panel-footer">Respuesta: {{message}}</p>
	</div>
    </body>
</html>