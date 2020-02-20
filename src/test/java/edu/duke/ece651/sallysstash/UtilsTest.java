package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UtilsTest {
  @Test
  public void test_utils() {
    myUtils.HELLO();
    myUtils.ROLE_CHOOSE('A');
    myUtils.WELCOME('A', 'B');
    myUtils.ASK_PUT('A', "Green");
    myUtils.ASK_ACTION('A', 2, 1);
    myUtils.HIT_WELCOME('A', 'B');
    myUtils.ASK_HIT('A', 'B');
    myUtils.IS_HIT();
    myUtils.ASK_MOVE('A', 'B');
    myUtils.ASK_MOVE_TO('A');
    myUtils.ASK_SONAR('A', 'B');
    myUtils.SONAR_RESULT(1, 2, 3, 4);
    myUtils.GOBACK();
    myUtils.SPECIAL('B');
    myUtils.FOUND('A', 'G', 3, 0);
    myUtils.IS_MISS();
    myUtils.IS_WIN('A');
    myUtils.IS_INVALID();
    myUtils.NOSTACK();
  }
}
