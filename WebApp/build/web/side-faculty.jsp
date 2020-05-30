<%@page import="javax.xml.bind.DatatypeConverter"%><%@page import="java.sql.*"%><%@page import="cerberus.*"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html lang="en"> 
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="images/logo-circle-removebg.png" type="image/gif">
        <title>Admission MSU</title>
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="css/loader.css" type="text/css">
        <link rel="stylesheet" href="css/anim.css" type="text/css">
        <link rel="stylesheet" href="css/dropdowns.css" type="text/css">
        <style>.body{}</style>
    </head>
    <body id="page-top">
        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
            &nbsp;&nbsp;<img src="images/logomain.png" height="40" align='center' width="40"> 
            <a class="navbar-brand mr-1" href="about.html">
                Admission
            </a>
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"> </form>
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <div id='pic'></div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="javascript:setContent('/Admission/profile');">My Profile</a> 
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a> 
                    </div>
                </li>
            </ul>
        </nav>
        <div id="wrapper">
            <script>document.getElementById('pic').innerHTML = "<img style='width:30px;height:30px;' src='images/student.png' style='border-radius:50%;'/>";</script> 
                <div id="content-wrapper"> 
                    <div class="container-fluid">
                        <ol class="breadcrumb" id='navigator'> 
                            <li class="breadcrumb-item"> 
                                <a href="javascript:setContent('/Admission/homepage');">Homepage</a> </li>
                            <li class="breadcrumb-item active">Overview</li>
                        </ol> 
                        <div id='main' style='display: none;' align='center'> 