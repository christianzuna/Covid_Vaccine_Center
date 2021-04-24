let getEmployees = async function (){
    let listingEmployees = await fetch('ProfileP'); //going to the location to get information 
    let employees = await listingEmployees.json(); 
    return employees;
};

//at the bottom 
(async() => {
    let employees = await getEmployees()
    // console.log(employees);
    if(employees.length > 0 ) {
        var temp = ""; 
        employees.forEach((element) => {
            temp += "<tr>";
            temp += "<td>" + element.id + "</td>";
            temp += "<td>" + element.fname + "</td>";
            temp += "<td>" + element.lname + "</td>";
            temp += "<td>" + element.age + "</td>";
            temp += "<td>" + element.email + "</td></tr>";
        });
    }
    document.getElementById('data').innerHTML = temp; //this will append temp to the table id='data' 
})();