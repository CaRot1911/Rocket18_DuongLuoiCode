$(function(){
    $(".header").load("header.html"); 
    $(".footer").load("footer.html"); 
    $(".main").load("home.html"); 
  });

function clickNavHome(){
    $(".main").load("home.html");    
}

function clickNavView(){
    $(".main").load("viewlist.html"); 
    initTable();
}

var emp = [] ;
var count = 0;

function Employee(departmentName){
    this.departmentID = ++count;
    this.departmentName = departmentName;
}
function initEmp(){
    emp = [];

    // call API
    $.get("http://localhost:8080/api/v1/departments",function(data,status){
        emp = data;
        fillempToTable();
    });
    
}

function initTable(){
    $('tbody').empty();
    initEmp();

    fillempToTable();
}

function fillempToTable(){
    emp.forEach(function(item){
        $('tbody').append(
            '<tr>'+
                '<td>'+item.departmentName+'</td>'+
                '<td>'+
                    '<a class="edit" title="Edit" data-toggle="tooltip" onclick=" openUpdateMadel('+item.departmentID +')"><i class="material-icons">&#xE254;</i></a>'+
                    '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openDeleteMadel('+item.departmentID +')"><i class="material-icons">&#xE872;</i></a>'+
                '</td>'+
            '</tr>')
    });
}


function openAddMadel(){
    resetFrom();
    openMadel();
}

function resetFrom(){
    // document.getElementById("id").value = "";
    document.getElementById("name").value = "";

}
function openMadel(){
    $('#myModal').modal('show');
}

function hideMadel(){
    $('#myModal').modal('hide');
}

function addEmp(){
    var departmentName = document.getElementById("name").value;

    // todo validate
    // return
    var emp1 = {
        departmentName : departmentName
    }

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(emp),
        contentType: "application/json",
        success: function(data,textStatus,xhr){
            console.log(data);
            hideMadel();
            showSuccessAlert();
            initTable();
        },
        error(jqXHR,textStatus,errorThow){
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThow)
        }
    });
}

function openUpdateMadel(departmentID){

    var index = emp.findIndex(x => x.departmentID == departmentID)

    document.getElementById("id").value = emp[index].departmentID;
    document.getElementById("name").value = emp[index].departmentName;
    openMadel();


}

function save(){
    var departmentID = document.getElementById("id").value;
    if(departmentID == null || departmentID == ""){
        addEmp();
    }else{
        updateEmp();
    }
}

function updateEmp(){
    var departmentID = document.getElementById("id").value;
    var departmentName = document.getElementById("name").value;
    // call API
    var emp1 = {
        departmentName : departmentName
    }

    $.ajax({
        url :  'http://localhost:8080/api/v1/departments/' + departmentID,
        type : 'PUT',
        data : emp1,
        success: function(result){
            if(result == undefined || result == null){
                alert('Error when load data');
                return;
            }

            hideMadel();
            showSuccessAlert()
            initTable();
  
        }
    });
    console.log(emp.departmentName);
}

function showSuccessAlert(){
    $("#success-alert").fadeTo(2000,500).slideUp(500,function(){
        $("#success-alert").slideUp(500);
    });
}
function openDeleteMadel(departmentID){

    var index = emp.findIndex(x => x.departmentID == departmentID);

    var result = confirm("Want to delete!");
    if(result){
        deleteEmp(departmentID);
    }
}

function deleteEmp(departmentID){
    
    $.ajax({
        url :  'http://localhost:8080/api/v1/departments/' + departmentID,
        type : 'DELETE',
    
        success: function(result){
            if(result == undefined || result == null){
                alert('Error when load data');
                return;
            }
            showSuccessAlert()
            initTable();
        }
        
    });

}