<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../header/header.jsp"></jsp:include>


<div class="col-md-12">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Veuillez remplir ce dossier</h2>
            <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
        </div>
        <div class="card-body">
            <form action="Dossier" method="POST">
                
                <div class="form-group ">
                	<label class="control-label">Quel est votre nom</label>
                    <input type="text" name="nom" class="form-control"  required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Votre date de naissance</label>
                    <input type="date" name="datenaiss" class="form-control" required="">
                </div>
                <div class="form-group ">
                       <select name="Idetab" class="form-control">
                         <option  selected>Choisir votre etablissement ...</option>
                            <c:forEach items="${list_etablissement}" var="et">
                               <option value="${et.id }">${et.nom }</option>
                            </c:forEach>
                      </select>
                </div>
                <div class="form-group ">
                       <select name="Idexamen" class="form-control">
                         <option  selected>Vous candidaté pour quel examen ...</option>
                            <c:forEach items="${list_examens}" var="ex">
                               <option value="${ex.id }">${ex.nom }</option>
                            </c:forEach>
                      </select>
                </div>
                
                <input type="submit" class="btn btn-primary" value="Enregister"/>
                <input type="reset" value="Annuler" class="btn btn-danger "/>
            </form>
        </div>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Liste des dossiers remplis</h2>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Date naissance</th>
                            <th>Etablissement</th>
                            <th>Examen</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
						<c:forEach items="${list_dossiers}" var="do">
							<tr>
								<td>${do.id}</td>
								<td>${do.nom }</td>
								<td>${do.datenaissance }</td>
								<td>${do.etablissement.nom }</td>
								<td>${do.examen.nom }</td>
								<td>
									<a class="btn btn-warning waves-effect waves-light" href="User?page=edit&id=${u.id}">Edit</a>
								</td>
								<td>
			                  		<a class="btn btn-danger waves-effect waves-light" href="">Supprimer</a>
								</td>
							</tr>
						</c:forEach>
							</tbody>
                	</table>
            </div>
        </div>
    </div>
</div>                                         


<jsp:include page="../../footer/footer.jsp"></jsp:include>