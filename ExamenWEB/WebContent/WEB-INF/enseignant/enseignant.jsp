<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../header/header.jsp"></jsp:include>


<div class="col-md-12">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Ajouter un etablissement</h2>
            <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
        </div>
        <div class="card-body">
            <form action="Enseignant" method="POST">
                <div class="form-group ">
                	<label class="control-label">Quel est votre matricule</label>
                    <input type="text" name="matri" class="form-control"  required="">
                </div>
                <div class="form-group ">
                	<label class="control-label">Quel est votre nom</label>
                    <input type="text" name="nom" class="form-control"  required="">
                </div>
                <div class="form-group ">
                	<label class="control-label">Quel est votre numero telephone</label>
                    <input type="tel" name="tele" class="form-control"  required="">
                </div>
                <div class="form-group ">
                	<label class="control-label">Quel est votre ville</label>
                    <input type="text" name="ville" class="form-control" required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Votre adresse</label>
                    <input type="text" name="adresse" class="form-control" required="">
                </div>                
                <div class="form-group ">
                       <select name="Idexamen" class="form-control">
                       			<option >Pour quel examen</option>
                       		<c:forEach items="${list_examens}" var="ex">
                               <option value="${ex.id }">${ex.nom}</option>
                             </c:forEach>
                      </select>
                </div>
                
                <input type="submit" class="btn btn-primary" name="page" value="Enregistrer"/>
                <input type="reset" value="Annuler" class="btn btn-danger "/>
            </form>
        </div>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Liste des etablissements</h2>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Matricule</th>
                            <th>Nom</th>
                            <th>Telephone</th>
                            <th>Adresse</th>
                            <th>Ville</th>
                            <th>Examen</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
						<c:forEach items="${list_enseignants}" var="en">
							<tr>
								<td>${en.id}</td>
								<td>${en.matricule }</td>
								<td>${en.nom }</td>
								<td>${en.telephone }</td>
								<td>${en.adresse}</td>
								<td>${en.ville}</td>
								<td>${en.examen.nom}</td>
								<td>
									<a class="btn btn-warning waves-effect waves-light" href="Etablissement?page=Recuperer&id=${en.id}">Edit</a>
								</td>
								<td>
			                  		<a class="btn btn-danger waves-effect waves-light" href="Etablissement?page=Supprimer&id=${en.id}">Supprimer</a>
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