<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../header/header.jsp"></jsp:include>


<div class="col-md-12">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Veuillez modifier un enseignant</h2>
            <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
        </div>
        <div class="card-body">
            <form action="Enseignant" method="POST">
                <div class="form-group ">
                	<label class="control-label">Quel est votre matricule</label>
                    <input type="text" name="matri" class="form-control" value="${list_ensei.matricule}"   required="">
                </div>
                <div class="form-group ">
                	<label class="control-label">Quel est votre nom</label>
                    <input type="text" name="nom" class="form-control" value="${list_ensei.nom}"   required="">
                </div>
                <div class="form-group ">
                	<label class="control-label">Quel est votre numero telephone</label>
                    <input type="tel" name="tele" class="form-control" value="${list_ensei.telephone}"   required="">
                </div>
                <div class="form-group ">
                	<label class="control-label">Quel est votre ville</label>
                    <input type="text" name="ville" class="form-control" value="${list_ensei.ville}"  required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Votre adresse</label>
                    <input type="text" name="adresse" class="form-control" value="${list_ensei.adresse}"  required="">
                </div>                
                <div class="form-group">
                	<label class="control-label">Pour quel examen</label>
                    <input type="text" name="Idexamen" class="form-control" value="${list_ensei.examen.nom}"  required="">
                </div> 
                
                <input type="submit" class="btn btn-primary" name="page" value="Modifier"/>
                <input type="reset" value="Annuler" class="btn btn-danger "/>
            </form>
        </div>
    </div>

</div>                                         


<jsp:include page="../../footer/footer.jsp"></jsp:include>