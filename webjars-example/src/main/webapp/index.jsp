<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>WebJars Sample - Jetty WAR</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.1/css/bootstrap.min.css'>
    <script type='text/javascript' src='webjars/jquery/1.11.1/jquery.min.js'></script>
    <script type='text/javascript' src='webjars/bootstrap/3.3.1/js/bootstrap.min.js'></script>
    <style type="text/css">
        body {
            margin-top: 50px;
        }
    </style>
</head>
<body>
<hr/>
<h1>Hello, Webjars!</h1>
<hr/><br/>

<div class="container">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Show modal</button>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">webjars</h4>
            </div>
            <div class="modal-body">
                <p>Bootstrap depends on jQuery.  So when you specify Bootstrap as a dependency you get jQuery too.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>