<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu registration page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="path/to/jquery.form.js"></script>
</head>
<body>
<div class="container">
    <h1>Please enter menu information and menu image file to upload</h1>
    <hr>
    <form id="menuImageForm" action="/admin/${menu.id}/image" method="post" enctype="multipart/form-data">
    <div class="form-group">
            <label for="menuImage">Menu Image</label>
            <div class="custom-file">
                <input type="file" class="custom-file-input" id="menuImage" name="imageFile">
                <label class="custom-file-label" for="menuImage">Select the file.</label>
            </div>
        </div>
        <div class="form-group">
            <img id="menuImagePreview" src="#" alt="Menu Image Preview" style="max-width: 100%; max-height: 200px;">
        </div>
        <div class="form-group">
            <button type="button" id="attachImageButton" class="btn btn-primary">미리보기</button>
            <button type="reset" id="deleteImageButton" class="btn btn-danger" disabled>이미지삭제</button>
            <button type="submit" id="submitImageButton" class="btn btn-primary" disabled>이미지등록</button>
        </div>
    </form>
    <hr>
    <!-- Menu Registration Form -->
    <h3>Menu registration</h3>
    <form id="menuForm" method="post" action="/admin/menu_save">
        <div class="form-group">
            <label for="name">Menu name</label>
            <input type="text" class="form-control" id="name" name="${menu.name}" required>
        </div>
        <div class="form-group">
            <label for="price">가격</label>
            <input type="number" class="form-control" id="price" name="${menu.price}" required>
        </div>
        <div class="form-group">
            <label for="type">Menu type</label>
            <select class="form-control" id="type" name="${menu.type}" required>
                <option value="COFFEE">COFFEE</option>
                <option value="DRINK">DRINK</option>
                <option value="DESSERT">DESSERT</option>
            </select>
        </div>
        <div class="form-group">
            <label for="size">Size</label>
            <select class="form-control" id="size" name="${menu.size}" required>
                <option value="MEDIUM">MEDIUM</option>
                <option value="LARGE">LARGE</option>
            </select>
        </div>
        <div class="form-group">
            <label for="options">옵션</label>
            <select class="form-control" id="options" name="${menu.options}" required>
                <option value="HOT">HOT</option>
                <option value="ICED">ICED</option>
            </select>
        </div>
        <div class="form-group">
            <label for="stock">Inventory quantity</label>
            <input type="text" class="form-control" id="stock" name="${menu.stock}" required>
        </div>
        <button type="submit" class="btn btn-primary">메뉴등록</button>
    </form>
</div>
</body>
</html>
