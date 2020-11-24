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
                         { title: "Profile" },
                         { title: "EmployeeNumber" },
                         { title: "TeamWork" },
                         { title: "GoalSettings" },
                         { title: "TimeManagement" },
                         { title: "OverAllPerformance" },
                         { title: "TypeOfBand" },
                         { title: "Skills" },
                         { title: "Languages" }
                     ]
                 });
             });
   })
}
