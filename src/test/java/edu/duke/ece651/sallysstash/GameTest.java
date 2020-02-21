package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

public class GameTest {
  @Test
  public void test_robot() throws FileNotFoundException {
    String filename = "./src/test/resources/robot.txt";
    System.setIn(new FileInputStream(filename));
    Game mygame = new Game();
    mygame.main(null);
  }

  @Test
  public void test_player() throws FileNotFoundException {
    String filename = "./src/test/resources/pp.txt";
    System.setIn(new FileInputStream(filename));
    Game mygame = new Game();
    mygame.main(null);
  }
}
