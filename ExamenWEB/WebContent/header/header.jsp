<%@page import="sn.isi.entities.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="h" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>EXAMEN</title>

    <!-- Custom fonts for this template-->
    <link href="public/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="public/assets/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="http://localhost:8080/ExamenWEB/">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">EXAMEN DITI4</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="http://localhost:8080/ExamenWEB/">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">
            
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="Dossier?page=liste">
                    <i class="fa fa-folder-open"></i>
                    <span>Dossiers</span></a>
            </li>
            
            <hr class="sidebar-divider d-none d-md-block">
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="Enseignant?page=liste">
                    <i class="fa fa-users"></i>
                    <span>Enseignants</span></a>
            </li>
            <hr class="sidebar-divider d-none d-md-block">
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="Epreuve?page=liste">
                    <i class="fa fa-envelope"></i>
                    <span>Epreuves</span></a>
            </li>
            <hr class="sidebar-divider d-none d-md-block">
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="Etablissement?page=liste">
                    <i class="fa fa-graduation-cap"></i>
                    <span>Etablissements</span></a>
            </li>
            <hr class="sidebar-divider d-none d-md-block">
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="Examen?page=liste">
                <i class="fas fa-file-alt"></i>
                    <span>Examens</span></a>
            </li>
            <hr class="sidebar-divider d-none d-md-block">
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="User?page=liste">
                <i class="fas fa-file-alt"></i>
                    <span>Utilisateurs</span></a>
            </li>
            <hr class="sidebar-divider d-none d-md-block">
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="Role?page=liste">
                <i class="fas fa-file-alt"></i>
                    <span>Roles</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
			
			 <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>


                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto"> 
                     <div class="topbar-divider d-none d-sm-block"></div>                      
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                	<%
                                	User user = (User)session.getAttribute("user_session");
                                	out.print("Bonjour  "+user.getPrenom());
                                	%>
                                </span>
                                <img class="img-profile rounded-circle"
                                    src="public/assets/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="Logout">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->
		<div class="container-fluid">
                    <div class="row">