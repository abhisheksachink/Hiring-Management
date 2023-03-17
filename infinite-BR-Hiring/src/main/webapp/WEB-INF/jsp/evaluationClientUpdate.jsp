<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1">
<title>Infinite Admin Dashboard</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
</head>
<body>
	<%@include file="menu.jsp"%>
	<main>

		<div class="page-header">
			<h1>Evaluation</h1>
			<small>Home / Evaluation</small>
		</div>

		<div class="page-content">

			<div class="analytics">

				<div class="card">
					<div class="card-head">
						<h2>107,200</h2>
						<span class="las la-user-friends"></span>
					</div>
					<div class="card-progress">
						<small>User activity this month</small>
						<div class="card-indicator">
							<div class="indicator one" style="width: 60%"></div>
						</div>
					</div>
				</div>

				<div class="card">
					<div class="card-head">
						<h2>340,230</h2>
						<span class="las la-eye"></span>
					</div>
					<div class="card-progress">
						<small>Page views</small>
						<div class="card-indicator">
							<div class="indicator two" style="width: 80%"></div>
						</div>
					</div>
				</div>

				<div class="card">
					<div class="card-head">
						<h2>$653,200</h2>
						<span class="las la-shopping-cart"></span>
					</div>
					<div class="card-progress">
						<small>Monthly revenue growth</small>
						<div class="card-indicator">
							<div class="indicator three" style="width: 65%"></div>
						</div>
					</div>
				</div>

				<div class="card">
					<div class="card-head">
						<h2>47,500</h2>
						<span class="las la-envelope"></span>
					</div>
					<div class="card-progress">
						<small>New E-mails received</small>
						<div class="card-indicator">
							<div class="indicator four" style="width: 90%"></div>
						</div>
					</div>
				</div>

			</div>


			<div class="records table-responsive">


				<div class="container">
					<div class="content">
						<div class="title">Candidate Client Evaluation</div>
						<form action="<%=request.getContextPath()%>/clientevaluateupdate/${evaluation_id}/${admin_id}/${admin_name}/${admin_role}" method="POST">
							<div class="user-details">
								<div class="input-box">
									<span class="details">Candidate Full Name</span> 
									<input type="text" name="cand_name"  value="${Cand_name}" readonly>
								</div>
								
								<div class="input-box">
									<span class="details">Internal/External</span> 
									<input type="text" name="through" value="${Through}" readonly>
								</div>
								<div class="input-box">
									<span class="details">Location</span> 
									<input type="text" name="location" value="${Location}" readonly>
								</div>
								
								<div class="input-box">
									<span class="details">Source</span>
									 <input type="text" name="esource" value="${Esource}" readonly>
								</div>
								<div class="input-box">
									<span class="details">Required Skill Set</span> 
									<input type="text" name="skill" value="${Skill}" readonly>
								</div>
								<div class="input-box">
									<span class="details">Target BR</span> 
									<input type="text" name="br_number" value="${Br_number}" readonly>
								</div>
								<div class="input-box">
									<span class="details">Grade</span> 
									<input type="text" name="grade" value="${Grade}" required>
								</div>
								<div class="input-box">
									<span class="details">Screening Date</span> 
									<input type="text" name="scrndate" value="${screen_date}" readonly>
								</div>
					
						

								
								<div class="input-box">
									<span class="details">Screening Result</span> 
									<input type="text" name="screen_result" value="${screen_result}" readonly/>
								</div>
								<div class="input-box">
									<span class="details">L1 Evaluation Date</span> 
									<input type="text" name="l1_Date" value="${l1_date}" readonly/>
								</div>
								<div class="input-box">
									<span class="details">L1 Evaluation Result</span> 
									<input type="text" name="l1_Result" value="${l1_result}" readonly/>
								</div>
								  
								<div class="input-box">
									<span class="details">Client Evaluation Date</span> 
									<input class="inputstyle" type="date" name="appr_date"  placeholder="Approved Date" />
								</div>
							</div>
							
							<div class="gender-details">
								 
									 <input type="radio" name="client_result" id="dot-3" value="Pass"> 
									 <input type="radio" name="client_result" id="dot-4" value="Fail"> 
									 <span class="gender-title">Client Evaluation Result</span>
								<div class="category">
									<label for="dot-3"> <span class="dot three"></span> <span
										class="gender">Pass</span>
									</label> 
									<label for="dot-4"> <span class="dot four"></span> <span
										class="gender">Fail</span>
										</label>
									
								</div>
							</div>


							<div class="input-box">
							<span class="details">Comments</span> 
							<textarea rows="4" cols="100" name="evln_comnts">${evln_comment}</textarea>
							</div><br>
							
							
							<div class="button">
								<input type="submit" value="Evaluate candidate">
							</div>
						</form>
					</div>
				</div>


			</div>

		</div>


	</main>






<%@include file="style.jsp"%>
</body>
</html>

<style>
 @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins',sans-serif;
}
.container{
  max-width: 700px;
  width: 100%;
  background-color: #fff;
  padding: 25px 30px;
  margin-left:200px;
  border-radius: 5px;
  box-shadow: 0 5px 10px rgba(0,0,0,0.15);
}
.container .title{
  font-size: 25px;
  font-weight: 500;
  position: relative;
}
.container .title::before{
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 30px;
  border-radius: 5px;
  background: linear-gradient(135deg, #71b7e6, #9b59b6);
}
.content form .user-details{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
form .user-details .input-box{
  margin-bottom: 15px;
  width: calc(100% / 2 - 20px);
}
form .input-box span.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}
.user-details .input-box input{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
  border-color: #9b59b6;
}
 form .gender-details .gender-title{
  font-size: 20px;
  font-weight: 500;
 }
 form .category{
   display: flex;
   width: 80%;
   margin: 14px 0 ;
   justify-content: space-between;
 }
 form .category label{
   display: flex;
   align-items: center;
   cursor: pointer;
 }
 form .category label .dot{
  height: 18px;
  width: 18px;
  border-radius: 50%;
  margin-right: 10px;
  background: #d9d9d9;
  border: 5px solid transparent;
  transition: all 0.3s ease;
}
 #dot-1:checked ~ .category label .one,
 #dot-2:checked ~ .category label .two,
 #dot-3:checked ~ .category label .three,
 #dot-4:checked ~ .category label .four,
 #dot-5:checked ~ .category label .five,
 #dot-6:checked ~ .category label .six{
   background: #9b59b6;
   border-color: #d9d9d9;
 }
 form input[type="radio"]{
   display: none;
 }
 form .button{
   height: 45px;
   margin: 35px 0
 }
 form .button input{
   height: 100%;
   width: 100%;
   border-radius: 5px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background: linear-gradient(135deg, #71b7e6, #9b59b6);
 }
 form .button input:hover{
  /* transform: scale(0.99); */
  background: linear-gradient(-135deg, #71b7e6, #9b59b6);
  }
 @media(max-width: 584px){
 .container{
  max-width: 100%;
}
form .user-details .input-box{
    margin-bottom: 15px;
    width: 100%;
  }
  form .category{
    width: 100%;
  }
  .content form .user-details{
    max-height: 300px;
    overflow-y: scroll;
  }
  .user-details::-webkit-scrollbar{
    width: 5px;
  }
  }
  @media(max-width: 459px){
  .container .content .category{
    flex-direction: column;
  }
}


</style>
