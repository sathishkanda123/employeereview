var dataSet = [];
initFunction();

function initFunction(){
 fetch('http://localhost:8080/employee/view')
   .then(response => response.json())
   .then(data => {
      data.forEach(element =>{
       dataSet.push(Object.values(element));
      });
      $(document).ready(function() {
                 $('#example').DataTable( {
                     data: dataSet,
                     columns: [
                         { title: "EmployeeName" },
                         { title: "EmployeeNumber" },
                         { title: "Profile" },
                         { title: "TeamWork" },
                         { title: "GoalSettings" },
                         { title: "Attendance" },
                         { title: "OverAllPerformance" },
                         { title: "Skills" },
                         { title: "Languages" },
                         { title: "TypeOfBand" }
                     ]
                 });
             });
   })
}

