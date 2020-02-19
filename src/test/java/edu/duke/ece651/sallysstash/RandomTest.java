package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomTest {
  @Test
  public void test_random() {
    for (int i = 0; i < 10; i++) {
      System.out.println(RobotAction.GenerateTwo());
    }
    for (int j = 0; j < 10; j++) {
      System.out.println(RobotAction.GenerateThree('P'));
    }
    for (int j = 0; j < 10; j++) {
      System.out.println(RobotAction.GenerateThree('B'));
    }
    for (int j = 0; j < 10; j++) {
      System.out.println(RobotAction.GenerateOne());
    }
  }
}
