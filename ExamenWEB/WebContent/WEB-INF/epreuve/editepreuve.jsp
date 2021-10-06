<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<jsp:include page="../../header/header.jsp"></jsp:include>

<div class="col-md-12">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">Veuillez ajouter une epreuve</h2>
            <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
        </div>
        <div class="card-body">
            <form action="Epreuve" method="POST">
                
                <div class="form-group ">
                	<label class="control-label">Quel est votre nom</label>
                    <input type="text" name="nom" class="form-control" value="${list_ep.nom}" required="">
                </div>
                <div class="form-group">
                	<label class="control-label">Le coefficent</label>
                    <input type="number" name="coeff" class="form-control" value="${list_ep.coefficient}"  required="">
                </div>                
                <div class="form-group ">
                       <select name="Idexamen" class="form-control">
                         <option  selected>Pour quel examen ...</option>
                            <c:forEach items="${list_examens}" var="ex">
                               <option value="${ex.id }">${ex.nom }</option>
                            </c:forEach>
                      </select>
                </div>
                
                <input type="submit" class="btn btn-primary" name="page" value="Modifier"/>
                <input type="reset" value="Annuler" class="btn btn-danger "/>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../../footer/footer.jsp"></jsp:include>