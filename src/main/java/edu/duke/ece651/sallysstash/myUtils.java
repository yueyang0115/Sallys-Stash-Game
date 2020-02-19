package edu.duke.ece651.sallysstash;

public class myUtils {
  public static void WELCOME(char name, char oppo_name) {
    System.out.print(
        "\n--------------------------------------------------------------------\nPlayer " + name
        + ", you are going place Sally’s stash on the board. Make sure Player " + oppo_name
        + " isn’t looking!\nFor each stack, type the coordinate of the upper left side of the stash, followed by H, V, U, D, L or R.\nFor example, M4H would place a stack horizontally starting at M4 and going to the right.\nYou have\n 2 Green stacks that are 1x2\n 3 Purple stacks that are 1x3\n 3 Red Superstacks \n 2 Blue Crazystacks\n\n");
  }

  public static void ASK_PUT(char name, String colorname) {
    System.out.print("\nPlayer " + name + ", where do you want to place this " + colorname
        + " stack?(e.g. A0H)\n");
  }

  public static void ASK_ACTION(char name, int move_remain, int sonar_remain) {
    System.out.print(
        "\n--------------------------------------------------------------------\nPossible actions for Player "
        + name + ":\n\nD Dig in a square \nM Move a stack to another square (" + move_remain
        + " remaining) \nS Sonar scan (" + sonar_remain + " remaining)\n\nPlayer " + name
        + ", what would you like to do?\n");
  }

  public static void HIT_WELCOME(char name, char oppo_name) {
    System.out.print("\nPlayer " + name + ", you are going to look for Sally’s stash on Player "
        + oppo_name + "'s board. Make sure Player " + oppo_name + " isn’t looking!\n");
  }
  public static void ASK_HIT(char name, char oppo_name) {
    System.out.print("\nPlayer " + name + ", where do you want to dig Player " + oppo_name
        + "'s board?(e.g.A0)\n");
  }
  public static void IS_HIT() {
    System.out.print("\nYou found a stack!\n");
  }

  public static void ASK_MOVE(char name, char oppo_name) {
    System.out.print("\nPlayer " + name
        + ", You are going to move the stash on your board. Make sure Player " + oppo_name
        + " isn't looking!\nWhich stack do you want to move?(e.g. A0)\n");
  }
  public static void ASK_MOVE_TO(char name) {
    System.out.print("\nPlayer " + name + ", where do you want this stack move to?(e.g. A0H)\n");
  }

  public static void ASK_SONAR(char name, char oppo_name) {
    System.out.print("\nPlayer " + name + ", you are going to sonar the stash on Player "
        + oppo_name + "'s board. Make sure Player " + oppo_name
        + " isn't looking!\nWhere is your sonar center?(e.g. A0)\n");
  }
  public static void SONAR_RESULT(int G_num, int P_num, int R_num, int B_num) {
    System.out.print("\n Green stacks occupy " + G_num + " squares\n Purple stacks occupy " + P_num
        + " squares\n Red stacks occupy " + R_num + " squares\n Blue stacks occupy " + B_num
        + " square\n");
  }

  public static void GOBACK() {
    System.out.print("Go back to select an action again!\n");
  }

  public static void IS_MISS() {
    System.out.print("\nYou missed!\n");
  }
  public static void IS_WIN(char name) {
    System.out.print("\nPlayer" + name + " win!\n");
  }
}
