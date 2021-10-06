<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../header/header.jsp"></jsp:include>


<div class="col-md-12">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Ajouter un examen</h2>
            <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
        </div>
        <div class="card-body">
            <form action="Examen" method="POST">
				<input type="hidden" value="${ model.mode }" name="mode"/>
                <div class="form-group ">
                	<label class="control-label">C'est quel examen</label>
                    <input type="text" name="nom" class="form-control"  >
                </div>
                <div class="form-group">
                	<label class="control-label">La date du deroulement</label>
                    <input type="date" name="dateE" class="form-control">
                </div>
				
                <input type="submit" class="btn btn-primary" name="page" value="Enregistrer"/>
                <input type="reset" value="Annuler" class="btn btn-danger "/>
            </form>
        </div>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Liste des examens</h2>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Date</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
						<c:forEach items="${list_examens}" var="ex">
							<tr>
								<td>${ex.id}</td>
								<td>${ex.nom }</td>
								<td>${ex.dateexamen }</td>
								<td>
									<a class="btn btn-warning waves-effect waves-light" href="Examen?page=Recuperer&id=${ex.id}">Edit</a>
								</td>
								<td>
			                  		<a class="btn btn-danger waves-effect waves-light" href="Examen?page=Supprimer&id=${ex.id}">Supprimer</a>
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