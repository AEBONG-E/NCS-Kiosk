<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Menu Information</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <h1>Menu Information</h1>
  <hr>
  <!-- Menu Information Display -->
  <h3>Registered Menu Image</h3>
  <div class="form-group">
    <img id="menuImage" src="${menu.menuImage}" alt="Menu Image" style="max-width: 100%; max-height: 200px;">
  </div>
  <div class="form-group">
    <label for="id">Registered Menu ID</label>
    <p id="id">${menu.id}</p>
  </div>
  <div class="form-group">
    <label for="name">Registered Menu Name</label>
    <p id="name">${menu.name}</p>
  </div>
  <div class="form-group">
    <label for="price">Registered Menu Price</label>
    <p id="price">${menu.price}</p>
  </div>
  <div class="form-group">
    <label for="type">Registered Menu Type</label>
    <p id="type">${menu.type}</p>
  </div>
  <div class="form-group">
    <label for="size">Registered Menu Size</label>
    <p id="size">${menu.size}</p>
  </div>
  <div class="form-group">
    <label for="options">Registered Menu Options</label>
    <p id="options">${menu.options}</p>
  </div>
  <div class="form-group">
    <label for="stock">Inventory Quantity</label>
    <p id="stock">${menu.stock}</p>
  </div>
  <div class="form-group">
    <label for="regDate">Registered Date</label>
    <p id="regDate">${menu.regDate}</p>
  </div>
  <hr>
  <!-- Modify and Delete Buttons -->
  <div class="form-group">
    <form id="menuUpdateForm" action="/admin/menu_update" method="post" enctype="multipart/form-data">
      <input type="hidden" name="menuId" value="${menu.menuId}">
      <button type="submit" class="btn btn-primary">Modify Menu</button>
    </form>
    <form id="menuDeleteForm" action="/admin/menu_delete" method="post" onsubmit="return confirm('Are you sure you want to delete this menu?');">
      <input type="hidden" name="menuId" value="${menu.menuId}">
      <button type="submit" class="btn btn-danger">Delete Menu</button>
    </form>
  </div>
</div>
</body>
</html>

