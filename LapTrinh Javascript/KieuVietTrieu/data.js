var listRoom = [
    {
        id: "1",
        name: "Phong A",
        price: "250.000",
        firstDate: "15-04-2024",
        endDate: "19-04-2024",
        image: "https://th.bing.com/th/id/R.fef9f63136d06c6ff2247449d087c3ae?rik=j2jHyhAm%2fyqnAQ&pid=ImgRaw&r=0&sres=1&sresct=1",
    },
    {
        id: "2",
        name: "Loai B",
        price: "250.000",
        firstDate: "15-04-2024",
        endDate: "19-04-2024",
        image: "https://th.bing.com/th/id/R.fef9f63136d06c6ff2247449d087c3ae?rik=j2jHyhAm%2fyqnAQ&pid=ImgRaw&r=0&sres=1&sresct=1",
    },
    {
        id: "3",
        name: "Phong tang 3",
        price: "250.000",
        firstDate: "15-04-2024",
        endDate: "19-04-2024",
        image: "https://th.bing.com/th/id/R.fef9f63136d06c6ff2247449d087c3ae?rik=j2jHyhAm%2fyqnAQ&pid=ImgRaw&r=0&sres=1&sresct=1",
    },
    {
        id: "4",
        name: "Phong tang 4",
        price: "250.000",
        firstDate: "15-04-2024",
        endDate: "19-04-2024",
        image: "https://th.bing.com/th/id/R.fef9f63136d06c6ff2247449d087c3ae?rik=j2jHyhAm%2fyqnAQ&pid=ImgRaw&r=0&sres=1&sresct=1",
    },
    {
        id: "5",
        name: "Phong K",
        price: "250.000",
        firstDate: "15-04-2024",
        endDate: "19-04-2024",
        image: "https://th.bing.com/th/id/R.fef9f63136d06c6ff2247449d087c3ae?rik=j2jHyhAm%2fyqnAQ&pid=ImgRaw&r=0&sres=1&sresct=1",
    }
];

function redirectToPage(url) {
    console.log(url);
    window.location.href = url;
}

function redirectHome() {
    redirectToPage("home.html");
}

function listProducts() {
    var demo = '';
    for (let i = 0; i <= listRoom.length - 1; i++) {
        demo += '<div class="col-3 mr-3 mb-3">';
        demo += '<div class="card" style="width: 18rem;">';
        demo += '<img src="' + listRoom[i].image + '" class="card-img-top" style="height: 400px;">';
        demo += '<div class="card-body">';
        demo += '<h5 class="card-title">' + listRoom[i].name + '</h5>';
        demo += '<p class="card-text">' + listRoom[i].price + '</p>';
        demo += '<a href="#" class="btn btn-primary mr-1" onclick="order()">Đặt Phòng</a>';
        demo += '<a href="#" class="btn btn-primary" onclick="detailProduct(' + listRoom[i].id + ')">Chi tiết</a>';
        demo += '</div>';
        demo += '</div>';
        demo += '</div>';
    }
    document.getElementById("listDisplay").innerHTML = demo;
    console.log(listRoom)
}

function createProduct() {
    var idRoom = document.getElementById('idRoom').value;
    var name = document.getElementById('name').value;
    var price = document.getElementById('price').value;
    var firstDate = document.getElementById('firstDate').value;
    var endDate = document.getElementById('endDate').value;
    var image = document.getElementById('image').value;


    if (idRoom === '' || name === '' || price === '' || firstDate === '' || endDate === '' || image === '') {
      alert('Vui lòng nhập đầy đủ thông tin điểm');
      return;
    }
    console.log(idRoom);
    listRoom.push({idRoom, name, price, firstDate, endDate, image});
    console.log(listRoom);
    alert('Tạo phòng thành công!', listRoom);
    redirectToPage("home.html");
}

  function handleSearch() {
    var nameSearch = document.getElementById('nameSearch').value;
    console.log(nameSearch);
    let listSearch = listRoom.filter(item => item.name.toLowerCase().includes(nameSearch.trim().toLowerCase()));
    var demo = '';
    for (let i = 0; i <= listSearch.length - 1; i++) {
        demo += '<div class="col-3 mr-3 mb-3">';
        demo += '<div class="card" style="width: 18rem;">';
        demo += '<img src="' + listSearch[i].image + '" class="card-img-top" style="height: 400px;">';
        demo += '<div class="card-body">';
        demo += '<h5 class="card-title">' + listSearch[i].name + '</h5>';
        demo += '<p class="card-text">' + listSearch[i].price + '</p>';
        demo += '<a href="#" class="btn btn-primary mr-1" onclick="order()">Đặt Phòng</a>';
        demo += '<a href="#" class="btn btn-primary" onclick="detailProduct(' + listSearch[i].id + ')">Chi tiết</a>';
        demo += '</div>';
        demo += '</div>';
        demo += '</div>';
    }
    document.getElementById("listDisplay").innerHTML = demo;
  }

  function detailProduct(idProduct) {
    document.getElementById("listRoom").style.display = 'none';
      let productDetail;
      listRoom.forEach((item) => {
          if(idProduct == item.id) {
              productDetail = item;
            }
        })
        let demo = '<h1 class="mb-2">CHI TIET PHONG</h1>';
        demo += '<div class="col-10">';
        demo += '<div class="" style="width: `100%`;">';
        demo += '<img src="' + productDetail.image + '" class="card-img-top" style="height: 400px;">';
        demo += '<div class="mt-2">';
        demo += '<h5 class="">' + productDetail.name + '</h5>';
        demo += '<p class="">Giá phòng: '+ productDetail.price + '</p>';
        demo += '<p class="">Thời gian: từ ngày '+ productDetail.firstDate + ' đến ngày ' + productDetail.endDate +'</p>';
        demo += '<button class="btn btn-primary" onclick="redirectHome()">Quay lại </button>';
        demo += '</div>';
        demo += '</div>';
        demo += '</div>';
        document.getElementById("detail").innerHTML = demo;
  }

  function deleteRoom(idDelete) {
    console.log(idDelete);
    let isDelete = confirm("Bạn chắc chắn muốn xóa chứ?")
    if(!isDelete) {
        return;
    }
    listRoom = listRoom.filter(item => item.id != idDelete);
    var tableBody = document.querySelector('#myTable tbody');
    tableBody.innerHTML = '';
    listRoom.forEach(function(item) {
      var row = document.createElement('tr');
      row.innerHTML = '<td>' + item.id + '</td><td>' + item.name + '</td><td>' + item.price + '</td><td>' + item.firstDate + '</td><td>' + item.endDate + '</td><td>' + '<a href="#" class="btn btn-primary" onclick="deleteRoom(' + item.id + ')">Xoá</a>' + '</td>'+ '<td>' + '<a href="#" class="btn btn-primary" onclick="order()">Sửa</a>' + '</td>';
      tableBody.appendChild(row);
    });
  }

  ed

  function displayTable() {
    var tableBody = document.querySelector('#myTable tbody');
    tableBody.innerHTML = '';
    listRoom.forEach(function(item) {
      var row = document.createElement('tr');
      row.innerHTML = '<td>' + item.id + '</td><td>' + item.name + '</td><td>' + item.price + '</td><td>' + item.firstDate + '</td><td>' + item.endDate + '</td><td>' + '<a href="#" class="btn btn-primary" onclick="deleteRoom(' + item.id + ')">Xoá</a>' + '</td>'+ '<td>' + '<a href="#" class="btn btn-primary" onclick="displayEditForm(' + item.id + ')">Sửa</a>' + '</td>';
      tableBody.appendChild(row);
    });
  }

  function displayEditForm(id) {
    var list = listRoom.filter(item => item.id == id);
    var selectedItem = list[0];
    if(!selectedItem) return;
    var formHtml = '<div id="formContainer" class="mt-4"> <h2 class="mb-3 mt-4">SỬA THÔNG TIN PHÒNG</h2>';
    formHtml += '<form id="editForm">';
    formHtml += '<label for="editName">Name:</label>';
    formHtml += '<input type="text" class="form-control" id="editName" name="editName" value="' + selectedItem.name + '"><br>';
    formHtml += '<label for="editPrice">Price:</label>';
    formHtml += '<input type="text" class="form-control" id="editPrice" name="editPrice" value="' + selectedItem.price + '"><br>';
    formHtml += '<label for="editStartDate">Start Date:</label>';
    formHtml += '<input type="text" class="form-control" id="editStartDate" name="editStartDate" value="' + selectedItem.firstDate + '"><br>';
    formHtml += '<label for="editEndDate">End Date:</label>';
    formHtml += '<input type="text" class="form-control" id="editEndDate" name="editEndDate" value="' + selectedItem.endDate + '"><br>';
    formHtml += '<label for="linkImage">Link ảnh:</label>';
    formHtml += '<input type="text" class="form-control" id="linkImage" name="linkImage" value="' + selectedItem.image + '"><br>';
    formHtml += '<input class="btn btn-primary" type="button" value="Lưu thay đổi">';
    formHtml += '</form> </div>';
  
    document.getElementById('formContainer').innerHTML = formHtml;
  }