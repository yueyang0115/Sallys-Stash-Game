package edu.duke.ece651.sallysstash;

public class Game {
  public static void main(String[] args) {
    System.out.println("This is my main method!\n");
    Board board_A = new Board();
    Board board_B = new Board();
    Action player_A = new Action(board_A);
    Action player_B = new Action(board_B);
    player_A.putAllStack("A", "B");
    player_B.putAllStack("B", "A");
  }
}

/*
  Scanner input = new Scanner(System.in);
  String myString = input.next();
  int x = InputHandler.getCoordinateX(myString);
  int y = InputHandler.getCoordinateY(myString);
  char direc = InputHandler.getDirection(myString);
  System.out.println(x);
  System.out.println(y);
  System.out.println(direc);
  */
