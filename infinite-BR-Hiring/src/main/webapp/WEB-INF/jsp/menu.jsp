<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <input type="checkbox" id="menu-toggle">
    <div class="sidebar">
        <div class="side-header">
            <h3>I<span>nfinite</span></h3>
        </div>
        
        <div class="side-content">
            <div class="profile">
                <div class="profile-img bg-img" style="background-image: url(img/3.jpeg)"></div>
                <h4>${admin_name}</h4>
                <small>${admin_role}</small>
            </div>

            <div class="side-menu">
                <ul>
                    <li>
                       <a href="<%=request.getContextPath()%>/home/${admin_id}/${admin_name}/${admin_role}" class="active">
                            <span class="las la-home"></span>
                            <small>Dashboard</small>
                        </a>
                    </li>
                    <li>
                       <a href="">
                            <span class="las la-user-alt"></span>
                            <small>Profile</small>
                        </a>
                    </li>
                    <li>
                       <a href="">
                            <span class="las la-info-circle"></span>
                            <small>Summary</small>
                        </a>
                    </li>
                    <li>
                       <a href="<%=request.getContextPath()%>/evaluation/${admin_id}/${admin_name}/${admin_role}">
                            <span class="las la-clipboard-list"></span>
                            <small>Evaluation</small>
                        </a>
                    </li>
                    
                    <li>
                       <a href="">
                            <span class="las la-tasks"></span>
                            <small>Tasks</small>
                        </a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
    
    <div class="main-content">
        
        <header>
            <div class="header-content">
                <label for="menu-toggle">
                    <span class="las la-bars"></span>
                </label>
                
                <div class="header-menu">
                    <label for="">
                        <span class="las la-search"></span>
                    </label>
                    
                    <div class="notify-icon">
                        <span class="las la-envelope"></span>
                        <span class="notify">4</span>
                    </div>
                    
                    <div class="notify-icon">
                        <span class="las la-bell"></span>
                        <span class="notify">3</span>
                    </div>
                    
                    <div class="user">
                        <div class="bg-img" style="background-image: url(img/1.jpeg)"></div>
                        
                        
                        <a href="<%=request.getContextPath()%>/"><span class="las la-power-off"></span><span>Logout</span></a>
                        
                    </div>
                </div>
            </div>
        </header>
        
 
</body>
</html>