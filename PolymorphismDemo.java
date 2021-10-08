
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.ArrayList;

public class PolyDemo{






}

class GuessWhat extends Player{
private SecureRandom randIndex;
private int targetIndex;
private Words dict;

//Constructor for Game
public GuessWhat(String player, int lives, int stage){
  // call the super class
  // initialize the Player
  super(player,lives,stage);
  dict =  new Words();
}

public generat






}


class Player{
private int lives;
private String playerName;
private boolean isUserElligible;
private int playerStage;

public Player(String playername, int lives,int stage){

this.setPlayerName(playername);
this.setPlayerLives(lives);
this.setPlayerStage(stage);
this.setUserElligibleStatus(true);
}

//Set Player's name
public void setPlayerName(String name){
  this.playerName = name;
}
// Get Player's Name
public String getPlayerName(){
  return this.playerName;
}
// Set Lives of Player
public void setPlayerLives(int lives){
  this.lives = lives;
}
// Get Remaining Lives of the Player
public String getPlayerLives(){
  return this.lives;
}
// Set if User allow to Play
public void setUserElligibleStatus(boolean isElligible){
  this.isUserElligible = isElligible;
}
// Check if user is Allowed to play
public boolean getUserElligibleStatus(){
  return this.isUserElligible;
}
//Set Player Stage
public void setPlayerStage(int stage){
  this.playerStage = stage.
}
// Get Player Current Stage
public int getPlayerStage(){
  return this.playerStage;
}
}


class Words{

private ArrayList gameDictionary;

private int dictionarySize;
private String targetWord;
private int wordLength;
private char[] hiddenWord;


public Words(){
   this.gameDictionary = new ArrayList();
  this.dictionarySize = this.gameDictionary.size;
}



}