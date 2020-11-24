var employee;

function save(){

  employee = {
    "empName" : document.getElementById('empName').value,
    "empNo" : document.getElementById('empNo').value,
    "profile" : document.getElementById('profile').value,
    "teamWork" : document.getElementById('teamWork').value,
    "goalSettings" : document.getElementById('goalSettings').value,
    "timeManagement" : document.getElementById('timeManagement').value,
    "attendance" : document.getElementById('attendance').value,
    "overAllPerformance" : document.getElementById('overAllPerformance').value,
    "skills" : document.getElementById('skills').value,
    "languages" : document.getElementById('languages').value,
    "typeOfBand" : document.getElementById('typeOfBand').value
  }
  addEmployee();
  // $("#success-toast" ).trigger( "click" );
}

$(document).ready(function(){
    $("#success-toast").click(function(){
        $("#succssToast").toast({ delay: 3000 });
        $("#succssToast").toast('show');
    });
     $("#error-toast").click(function(){
            $("#errorToast").toast({ delay: 3000 });
            $("#errorToast").toast('show');
   });
});

function addEmployee(){
 fetch('http://localhost:8080/employee/save', {
   headers: { "Content-Type": "application/json; charset=utf-8" },
   method: 'POST',
   body: JSON.stringify(employee)
}).then(function(response) {
          if(response.status === 201){
            console.log("Successfully saved");
            alert("Saved successfully");
          }else if(response.status === 208) {
          console.log("Employee Already exists");
          alert("Employee already exists with same emp no");
          }else {
          console.log("Failed while saving");
          alert("Sorry some thing failed while saving ..Check once with admin :) ");
          }
      }).catch(function() {
          alert("Sorry some thing failed while saving ..Check once with admin :) ");
          console.log("error occurs");
 });
}