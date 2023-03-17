<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
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
			<h1>Dashboard</h1>
			<small>Home / Dashboard</small>
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

				<div class="record-header">
					<div class="add">
						<span>Entries</span> <select name="" id="">
							<option value="">ID</option>
						</select>
						<div><button class="button-add" data-modal="modalOne">Add record</button></div>
					</div>
					 

					<div class="browse">
						<input type="search" placeholder="Search" class="record-search">
						<select name="" id="">
							<option value="">Status</option>
						</select>
					</div>
				</div>
				
				

				<div>
					<table width="100%">
						<thead>
							<tr>
								<th>#BR</th>
								<th><span class="las la-sort"></span> PROJECT</th>
								<th><span class="las la-sort"></span> ISSUED DATE</th>
								<th><span class="las la-sort"></span> STATUS</th>
								<th><span class="las la-sort"></span> AGE</th>
								<th><span class="las la-sort"></span> ACTIVITY</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${bussinessReqdata}" var="br">
							<tr>
								<td><a href="">#${br.getBr_num()}</a></td>
								<td>
									<div class="client">
										<div class="client-info">
											<h4>${br.getProject()}</h4>
											
										</div>
									</div>
								</td>

								<td><fmt:formatDate value="${br.getApprove_date()}" pattern="dd-MM-yyyy"/></td>
								<td><span class="paid">${br.getStatus()}</span></td>
							
							<c:set var="olddate" value="${br.getApprove_date()}"/>
								<td>
								<%
								
								String stringDate2 = new SimpleDateFormat("yyyy-MM-dd").format(pageContext.getAttribute("olddate"));
								LocalDate apprlocalDate = LocalDate.parse(stringDate2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
								LocalDate curDate = LocalDate.now();
								Period period = Period.between(apprlocalDate, curDate);  
								int age=((period.getYears()*365)+(period.getMonths()*30)+(period.getDays()));
								out.print(age);
								%>
								 days</td>
								<td>
									<div class="actions">
										<span class="lab la-telegram-plane"></span> <span
											class="las la-eye"></span> <span class="las la-ellipsis-v"></span>
									</div>
								</td>
							</tr>
							</c:forEach>
							

						</tbody>
					</table>
				</div>

			</div>

		</div>
		<div id="modalOne" class="modal">
      <div class="modal-content">
        <div class="add-form">
          <a class="close">&times;</a>
          <form id="addform" action="<%=request.getContextPath()%>/addRecord/${admin_id}/${admin_name}/${admin_role}" method="post">
            <h2>Add BR Record</h2>
            <div>
              <input class="inputstyle" type="text" name="br_num" placeholder="BR Number" />
              <input class="inputstyle" type="text" name="project" placeholder="Project" />
              <input class="inputstyle" type="date" name="appr_date" placeholder="Approved Date" />
         
              <select class="inputstyle" name="status"  id="status">
                                <option value="" disabled selected hidden>Status</option>
								<option value="OPEN">OPEN</option>
								<option value="CLOSED">CLOSED</option>
								<option value="HOLD">HOLD</option>
								<option value="CANCELLED">CANCELLED</option>
			</select>
            <button id="formbutton" type="submit" >Submit</button>
          </form>
        </div>
      </div>
    </div>

	</main>






  <script>
      let modalBtns = [...document.querySelectorAll(".button-add")];
      modalBtns.forEach(function (btn) {
        btn.onclick = function () {
          let modal = btn.getAttribute("data-modal");
          document.getElementById(modal).style.display = "block";
        };
      });
      let closeBtns = [...document.querySelectorAll(".close")];
      closeBtns.forEach(function (btn) {
        btn.onclick = function () {
          let modal = btn.closest(".modal");
          modal.style.display = "none";
        };
      });
      window.onclick = function (event) {
        if (event.target.className === "modal") {
          event.target.style.display = "none";
        }
      };
    </script>
</body>
</html>
<%@include file="style.jsp"%>
<style>
 .modal {
        display: none;
        position: fixed;
        z-index: 8;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgb(0, 0, 0);
        background-color: rgba(0, 0, 0, 0.4);
      }
      .modal-content {
        margin: 50px auto;
        border: 1px solid #999;
        width: 60%;
      }


      #addform {
        padding: 25px;
        margin: 25px;
        box-shadow: 0 2px 5px #f5f5f5;
        background: #eee;
      }
     .inputstyle {
        width: 90%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #1c87c9;
        outline: none;
      }
      .add-form button {
        width: 100%;
        padding: 10px;
        border: none;
        background: #1c87c9;
        font-size: 16px;
        font-weight: 400;
        color: #fff;
      }
      #formbutton:hover {
        background: #2371a0;
      }
      .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
      }
      .close:hover,
      .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
      }



</style>
