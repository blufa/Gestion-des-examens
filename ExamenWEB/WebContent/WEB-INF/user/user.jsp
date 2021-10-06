<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../header/header.jsp"></jsp:include>


<div class="col-md-12">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Ajouter un utilisateur</h2>
            <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
        </div>
        <div class="card-body">
            <form action="User" method="POST">
                
                <div class="form-group">
                	<label class="control-label">Entrer le nom</label>
                    <input type="text" name="nom" class="form-control"  required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Entrer le prenom</label>
                    <input type="text" name="prenom" class="form-control" required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Email</label>
                    <input type="email" name="email" class="form-control" required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Password</label>
                    <input type="password" name="password" class="form-control" required="" >
                </div>
                
                 <div class="form-group ">   
                       <label class="label-control" for="Idrole">Choizissez un role</label>
                       <c:forEach items="${liste_roles}" var="r">
                         <input type="checkbox" name="Idrole" value="${r.id }"/>${r.nom }
						</c:forEach>
                </div>
                <input type="submit" class="btn btn-primary" value="Enregister"/>
                <input type="reset" value="Annuler" class="btn btn-danger"/>
            </form>
        </div>
    </div>

    <div class="card">
        <div class="card-header">
            <h2 class="m-0 font-weight-bold text-primary">Liste des utilisateurs</h2>            
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Email</th>
                            <th>Roles</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
						<c:forEach items="${list_users}" var="u">
							<tr>
								<td>${u.id}</td>
								<td>${u.nom }</td>
								<td>${u.prenom }</td>
								<td>${u.email }</td>
								<td>
									<c:forEach items="${u.roles}" var="r">
										${r.nom } &nbsp;
									</c:forEach>
								</td>
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