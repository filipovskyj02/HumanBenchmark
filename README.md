## BI-TJV-Semestral

## Name
Human benchmark

## Description
Application that aims to measure your cognitive abilites and speed.
Stores user scores, tracks your progress and allows you to compete with others on the 
global leaderboards.

## Client side
The client side will be realized as a dynamic website using html/css. Usage of a fancy JS frontend framework is  under consideration. The users will be greeted with a choice of multiple games and the option to log in / register on the side bar. Playing a game will result in a score that will be analysed and sent to the database.


## Database schema
<small>Highscore private key is a combination of coresponding game and user private keys and that combination is unique, which is what we expect from a user and his highscore for a single game.</small>


<img width=800% height=*00% src="./images/dbschema.png">

## Complex database query
Select the user with the most played games / with the highest amount of medals

## Complex operation
- Sending a score (Insert into db, read the highscore, if new score is higher then update the highscore)
- Comparison to other players (Find the highscore of every player, calculate percentile, show it to the player)
- Creating an account / changing a password (Check if email/ username is already present then create. Compare hashed password before updating)

## Disclaimer
Heavily inspired by https://humanbenchmark.com/
