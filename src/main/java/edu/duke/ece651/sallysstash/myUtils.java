package edu.duke.ece651.sallysstash;

public class myUtils {
  public static void WELCOME(char name, char oppo_name) {
    System.out.print("\nPlayer " + name
        + ", you are going place Sally’s stash on the board. Make sure Player " + oppo_name
        + " isn’t looking!\nFor each stack, type the coordinate of the upper left side of the stash, followed by either H (for horizontal) or V (for vertical).\nFor example, M4H would place a stack horizontally starting at M4 and going to the right.\nYou have\n 2 Green stacks that are 1x2\n 3 Purple stacks that are 1x3\n 3 Red stacks that are 1x4\n 2 Blue stacks that are 1x6\n");
  }

  public static void ASK_PUT(char name, String colorname) {
    System.out.print(
        "\nPlayer " + name + ", where do you want to place this " + colorname + " stack?\n");
  }

  public static void HIT_WELCOME(char name, char oppo_name) {
    System.out.print("\nPlayer " + name + ", you are going hit Sally’s stash on Player " + oppo_name
        + "'s board. Make sure Player " + oppo_name + " isn’t looking!\n");
  }
  public static void ASK_HIT(char name, char oppo_name) {
    System.out.print(
        "\nPlayer " + name + ", where do you want to hit Player " + oppo_name + "'s board?\n");
  }
  public static void IS_HIT() {
    System.out.print("\nYou found a stack!\n");
  }
  public static void IS_MISS() {
    System.out.print("\nYou missed!\n");
  }
  public static void IS_WIN(char name) {
    System.out.print("\nPlayer" + name + " win!\n");
  }
}
