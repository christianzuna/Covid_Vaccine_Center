let getPatients = async function (){
    let listingPatients = await fetch('ProfileE') //going to the location to get information 
    let patients = await listingPatients.json() 
    return patients
};

//at the bottom 
(async() => {
    let patients = await getPatients()
    // console.log(patients)
    if(patients.length > 0 ) {
        var temp = ""; 
        patients.forEach((element) => {
            temp += "<tr>";
            temp += "<th scope='row'>" + element.id + "</th>";
            temp += "<td>" + element.fname + "</td>";
            temp += "<td>" + element.lname + "</td>";
            temp += "<td>" + element.age + "</td>";
            temp += "<td>" + element.email + "</td></tr>";
        });
    }
    document.getElementById('patientsData').innerHTML = temp; //this will append temp to the table id='data' 
})();