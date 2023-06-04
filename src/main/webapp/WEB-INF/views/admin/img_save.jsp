<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<div class="container">
  <h1>Please enter menu information and menu image file to upload</h1>
  <hr>
  <form id="menuImageForm" action="/admin/${img.imgId}/image" method="post" enctype="multipart/form-data">
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
      <button type="reset" id="deleteImageButton" class="btn btn-danger" disabled>이미지삭제</button>
      <button type="submit" id="submitImageButton" class="btn btn-primary" disabled>이미지등록</button>
    </div>
  </form>
</div>
<script>
  $(function() {
// // Enable image preview and submit button when a file is selected
    $('#menuImage').on('change', function() {
      var file = this.files[0];
      var reader = new FileReader();
      reader.onload = function(e) {
        $('#menuImagePreview').attr('src', e.target.result);
      }
      reader.readAsDataURL(file);
      $('#submitImageButton').prop('disabled', false);
    });

    // Clear the file input and preview when the delete button is clicked
    $('#deleteImageButton').on('click', function() {
      $('#menuImage').val('');
      $('#menuImagePreview').attr('src', '');
      $('#submitImageButton').prop('disabled', true);
      $('#deleteImageButton').prop('disabled', true);
      $('#menuImageForm').get(0).reset(); // reset the form
    });

    // Enable the delete button when an image is selected
    $('#menuImage').on('click', function() {
      $('#deleteImageButton').prop('disabled', false);
    });

    // Submit the form when the submit button is clicked
    $('#submitImageButton').on('click', function() {
      $('#menuImageForm').submit();
    });
  });
</script>
</body>
</html>
