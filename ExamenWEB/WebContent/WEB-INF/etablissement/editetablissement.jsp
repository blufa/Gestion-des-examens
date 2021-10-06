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
                	<input type="hidden" name="id" class="form-control" value="${list_etabli.id}" >
                	<label class="control-label">Entrer le code</label>
                    <input type="text" name="code" class="form-control"  value="${list_etabli.code}" >
                </div>
                <div class="form-group">
                	<label class="control-label">Entrer le nom</label>                	
                    <input type="text" name="nom" class="form-control" value="${list_etabli.nom}" >
                </div>
                <div class="form-group">
                	<label class="control-label">Quel est son adresse ?</label>
                    <input type="text" name="adresse" class="form-control" value="${list_etabli.adresse}" >
                </div>
                <div class="form-group">
                	<label class="control-label">Il se trouve dans quelle ville ?</label>
                    <input type="text" name="ville" class="form-control" value="${list_etabli.ville}"  >
                </div>
                
                <input type="submit" class="btn btn-primary" name="page" value="Modifier"/>
                <input type="reset" value="Annuler" class="btn btn-danger "/>
            </form>
        </div>
    </div>

</div>                                         


<jsp:include page="../../footer/footer.jsp"></jsp:include>