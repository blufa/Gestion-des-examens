<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../header/header.jsp"></jsp:include>


<div class="col-md-12">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Ajouter un etablissement</h2>
            <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
        </div>
        <div class="card-body">
            <form action="Etablissement" method="POST">
                
                <div class="form-group ">
                	<label class="control-label">Entrer le code</label>
                    <input type="text" name="code" class="form-control"  required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Entrer le nom</label>
                    <input type="text" name="nom" class="form-control" required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Quel est son adresse ?</label>
                    <input type="text" name="adresse" class="form-control" required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Il se trouve dans quelle ville ?</label>
                    <input type="text" name="ville" class="form-control" required="" >
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
                            <th>Code</th>
                            <th>Nom</th>
                            <th>Adresse</th>
                            <th>Ville</th>
                            <th>Action</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
						<c:forEach items="${list_etablissement}" var="et">
							<tr>
								<td>${et.id}</td>
								<td>${et.code }</td>
								<td>${et.nom }</td>
								<td>${et.adresse }</td>
								<td>${et.ville}</td>
								<td>
									<a class="btn btn-warning waves-effect waves-light" href="Etablissement?page=Recuperer&id=${et.id}">Edit</a>
								</td>
								<td>
			                  		<a class="btn btn-danger waves-effect waves-light" href="Etablissement?page=Supprimer&id=${et.id}">Supprimer</a>
								</td>
								<td>
			                  		<a class="btn btn-success waves-effect waves-light" href="Etablissement?page=Visualiser&id=${et.id}">Visualiser</a>
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