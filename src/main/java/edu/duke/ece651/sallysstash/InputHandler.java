package edu.duke.ece651.sallysstash;

public class InputHandler {
  private String input;
  private String Input;
  private int is_valid;
  private char firstchar;
  private char secondchar;
  private char thirdchar;

  public InputHandler(String myinput) {
    this.is_valid = 0;
    this.input = myinput;
    firstchar = input.charAt(0);
    secondchar = input.charAt(1);
    thirdchar = input.charAt(2);
  }

  public void BasicCheck() {
    int valid_bit_0 = 0;
    int valid_bit_1 = 0;
    int valid_bit_2 = 0;
    int valid_bit_3 = 0;

    if (input.length() != 3) {
      valid_bit_0 = 0;
    }
    if ((firstchar >= 'A' && firstchar <= 'T') || (firstchar >= 'a' && firstchar <= 't')) {
      valid_bit_1 = 1;
    }
    if (secondchar >= '0' && secondchar <= '9') {
      valid_bit_2 = 1;
    }
    if ((thirdchar >= 'A' && thirdchar <= 'T') || (thirdchar >= 'a' && thirdchar <= 't')) {
      valid_bit_3 = 1;
    }
    is_valid = valid_bit_0 & valid_bit_1 & valid_bit_2 & valid_bit_3;
  }

  public void ParseInput() {
    this.Input = input.substring(0, 1).toUpperCase() + input.substring(1, 1)
        + input.substring(2, 1).toUpperCase();
  }

  public int getValid() {
    return this.is_valid;
  }
}
