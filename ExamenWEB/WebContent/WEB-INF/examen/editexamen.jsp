<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../header/header.jsp"></jsp:include>


<div class="col-md-12">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Modifier un examen</h2>
            <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
        </div>
        <div class="card-body">
            <form action="Examen" method="POST">
               
                <div class="form-group ">
                	<label class="control-label">C'est quel examen</label>
                	<input type="hidden" name="id" class="form-control"  value="${list_exa.id}">
                    <input type="text" name="nom" class="form-control"  value="${list_exa.nom}">
                </div>
                <div class="form-group">
                	<label class="control-label">La date du deroulement</label>
                    <input type="date" name="dateE" class="form-control" value="${list_exa.dateexamen}">
                </div>
   		
                <input type="submit" class="btn btn-primary" name="page" value="Modifier"/>
                <input type="reset" value="Annuler" class="btn btn-danger "/>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../../footer/footer.jsp"></jsp:include>