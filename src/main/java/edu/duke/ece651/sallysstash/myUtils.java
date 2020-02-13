package edu.duke.ece651.sallysstash;

public class myUtils {
  public static void WELCOME(String a, String b) {
    System.out.print("\nPlayer " + a
        + ", you are going place Sally’s stash on the board. Make sure Player " + b
        + " isn’t looking!\nFor each stack, type the coordinate of the upper left side of the stash, followed by either H (for horizontal) or V (for vertical).\nFor example, M4H would place a stack horizontally starting at M4 and going to the right.\nYou have\n 2 Green stacks that are 1x2\n 3 Purple stacks that are 1x3\n 3 Red stacks that are 1x4\n 2 Blue stacks that are 1x6\n");
  }

  public static void ASK_PUT(String player, String colorname) {
    System.out.print(
        "\nPlayer " + player + ", where do you want to place this " + colorname + " stack?\n");
  }
}
