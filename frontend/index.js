function setCookie(name, value, days) {
    const date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    const expires = `expires=${date.toUTCString()}`;
    document.cookie = `${name}=${value};${expires};path=/`;
  }
    function deleteCok(){
        deleteCookie("id_player");
        deleteCookie("name");
        window.location.href="index.html"
    }
    function deleteCookie(name) {
    setCookie(name, '', -1);
  }
     function getCookie(name) {
         const value = `; ${document.cookie}`;
         const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}
let username = getCookie('name');

if (username != null) {
    console.log("Welcome ", username );
    // User is logged in
  document.getElementById("login-button").style.display = "none";
  document.getElementById("register-button").textContent = "     "+ username;
  document.getElementById("register-button").className="fa fa-fw fa-user";
  getScores();

  
} else {
    // User is not logged in
    console.log("kl ", username );
    document.getElementById("Log Out").style.display = "none";
    document.getElementById("userScore").textContent="Please login to see scores";
 
}
async function getScores() {
    const scores = [];  // create an empty list to store the scores
    

    // call the /game endpoint to get a list of games
    const response = await fetch('http://localhost:8080/game', {
      method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
    });
    const games = await response.json();  // parse the response as JSON
  
    // for each game in the list, call the /maxscore endpoint to get the maximum score of the user
    for (const game of games) {
        let id = getCookie('id_player');
        const url = `http://localhost:8080/score/max?playerId=${id}&gameId=${game.id_game}`;
        console.log(url);
       
      const scoreResponse = await fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
            
        }
        
      })
      const maxScoreResponse = await fetch(`http://localhost:8080/score/globalmax?gameId=${game.id_game}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        }})
      const score = await scoreResponse.json(); 
      const maxscore = await maxScoreResponse.json();
      
      // parse the response as JSON
      scores.push({ id_game: game.id_game, score: score,gname: game.name , maxscore:maxscore});  // add the score to the list
      
      
    }
    // for each score in the scores array, create a new row and append it to the table
    const table = document.querySelector('#users');
 for (const score of scores) {
    const row = document.createElement('tr');
    row.innerHTML = `<td>${score.id_game} (${score.gname})</td><td>${score.score} ( ${(100/score.score).toFixed(5)} ms )</td><td>${score.maxscore} ( ${(100/score.maxscore).toFixed(5)} ms)</td>`;
    table.appendChild(row);
    }

  
    
  }


  




