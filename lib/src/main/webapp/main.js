let getUsers = async function (){
    let listingUsers = await fetch('ProfileE') //going to the location to get information 
    let users = await listingUsers.json() 
    return users
};






//at the bottom 
(async() => {
    let users = await getUsers()
    console.log(users)
    // let container = document.createElement('p');
    // container.innerHTML = 'hello'; 
    // document.getElementById('test').appendChild(container);
})();