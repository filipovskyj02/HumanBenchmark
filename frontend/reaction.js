  

  
    function deleteCok(){
        deleteCookie("id_player");
        deleteCookie("name");
        window.location.href="reaction.html"
    }
    function deleteCookie(name) {
    setCookie(name, '', -1);
  }
     function getCookie(name) {
         const value = `; ${document.cookie}`;
         const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}


function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
  }
  
 function setCookie(name, value, days) {
    const date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    const expires = `expires=${date.toUTCString()}`;
    document.cookie = `${name}=${value};${expires};path=/`;
  }
  
  function deleteCookie(name) {
    setCookie(name, '', -1);
  }
  function score(reactionTime) {
    if (reactionTime < 0 || reactionTime > 500) {
    return 0;
    }
    return 1000000 * (1 - (reactionTime / 500));
    }
    function createGameIfNotPresent(){
      const url = 'http://localhost:8080/game';
        fetch(url, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
        })
        .then(response => {
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);

          }
          return response.json();
        })
        .then(data => {

            
        })
        .catch(error => {
          createReq();
        });
        game();

    }
    function createReq(){
      const data = {name: 'Reaction Test'}
      const url = 'http://localhost:8080/game';
        fetch(url, {
          method: 'POST',
          body: JSON.stringify(data),
          headers: {
            'Content-Type': 'application/json',
            
          }
        })
        .then(response => {
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);

          }
          return response.json();
        })
        .then(data => {

            
        })
        .catch(error => {
        
        });

    }
  

    function game(){
  
      let username = getCookie('name');

if (username != null) {
    console.log("Welcome ", username );
    // User is logged in
  document.getElementById("login-button").style.display = "none";
  document.getElementById("register-button").textContent = "     "+ username;
  document.getElementById("register-button").className="fa fa-fw fa-user"

  
} else {
    // User is not logged in
    console.log("kl ", username );
    document.getElementById("Log Out").style.display = "none";
    
}
  
  
    const startButton = document.getElementById('start-button');
    const target = document.getElementById('target');
    
    
      
    
    
    let done = false;
    let startTime;
    let endTime;
    let changedToGreen = false;
    startButton.addEventListener('click', function() {
      startButton.style.display = 'none';
      target.style.display = 'block';
      target.textContent="Wait for green..."
      
      setTimeout(() => {
        changedToGreen = true;
        target.style.backgroundColor='green';
        startTime = new Date().getTime();
        }, Math.floor(Math.random() * 10000));
    });
    

    
    target.addEventListener('click', function() {
        if(done){
            window.location.href="reaction.html"

        }

        if (changedToGreen){
            endTime = new Date().getTime();
            const timeTaken = (endTime - startTime) / 1000;
            target.textContent = `Your reaction time was ${timeTaken} seconds`;
            sendScore(timeTaken);
            done = true;

        }
        else {
            target.textContent = 'Too soon';
            target.style.backgroundColor = "red";
            done = true;
            
        }
        
    });

   

    function sendScore(timeTaken){
        const data = {  id_player: getCookie('id_player') * 1, id_game: 1, score: 100/timeTaken};

        const url = 'http://localhost:8080/score';
        fetch(url, {
          method: 'POST',
          body: JSON.stringify(data),
          headers: {
            'Content-Type': 'application/json'
          }
        })
        .then(response => {
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
          }
          return response.json();
        })
        .then(data => {
            
        })
        .catch(error => {
        
        });
      }
    ;

    }