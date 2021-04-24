let getPatients = async function (){
    let listingPatients = await fetch('ProfileE') //going to the location to get information 
    let patients = await listingPatients.json() 
    return patients
};

//at the bottom 
(async() => {
    let patients = await getPatients()
    // console.log(patients)
    // let container = document.createElement('p');
    // container.innerHTML = 'hello';
    document.getElementById('test').innerText = patients[1].fname //this will append the fname of patient 1 to id='test' 
})();