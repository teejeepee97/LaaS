const signInButton = document.getElementById("signInButton")
const signInForm   = document.getElementById("signIn")

async function getCredentials(){
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value
    const login_response = await fetch("http://localhost:8082/Login2.html/" + username + "/" + password);
    console.log(login_response);
}

async function checkCredentials(){
    let un = document.getElementById("username").value
    let pw = document.getElementById("password").value
	console.log(un);
	console.log(pw);
        try{
            //const login_response = await fetch("http://localhost:8082/Login2.html/" + username + "/" + password);
			const response  = await fetch("http://localhost:8082/userdata");
            if(!response.ok){
                throw new Error(`Response status: ${response.status}`);
            }
            const json = await response.json();
            console.log(json);
            
            for(var x = 0; x < json.length; x++){
				console.log("found_password " + json[x].password);
				console.log("found_username " + json[x].username);
                if(json[x].username == un){
                    if(json[x].password == pw.value){
                        //Give acces to next page
                        console.log("Username and Password correct: access granted.");
						window.location.replace("admin_start.html");
						break;
                    }
                    else{
                        //print "Wrong password, try again"
                        console.log("Password incorrect: access denied, try again.");
						break;
                    }
                }    
                else{
                    //print "This username does not exist"
                    console.log("Username does not exist: acces denied, try again.");
                }
            }
        }
        catch(error){
            console.error(error.message)
        }
}

function getTeachingMaterials(){
	document.getElementById("allTeachingMaterials").innerHTML = "Haha prank hier staat helemaal niks!!!";
}
