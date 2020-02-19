package edu.duke.ece651.sallysstash;

public class InputHandler {
  private String input;
  private Board board;

  private int coordinate_x;
  private int coordinate_y;
  private char direction;
  private int is_valid;

  public InputHandler(String myinput, Board myboard) {
    this.input = myinput;
    this.board = myboard;
    this.is_valid = 0;
  }

  public void CheckTwoBits() {
    this.input += 'V';
    int location_valid = 0;

    CheckThreeBits();
    if (this.is_valid == 1) {
      if ((coordinate_x >= 0 && coordinate_x < board.getHeighth())
          && (coordinate_y >= 0 && coordinate_y < board.getWidth())) {
        location_valid = 1;
      }
    }
    this.is_valid = this.is_valid & location_valid;
  }

  public void CheckThreeBits() {
    int valid_bit_0 = 0;
    int valid_bit_1 = 0;
    int valid_bit_2 = 0;
    int valid_bit_3 = 0;

    if (input.length() == 3) {
      valid_bit_0 = 1;
    }
    if (valid_bit_0 == 1) {
      char firstchar = Character.toUpperCase(input.charAt(0));
      char secondchar = input.charAt(1);
      char thirdchar = Character.toUpperCase(input.charAt(2));

      if (firstchar >= 'A' && firstchar <= 'T') {
        valid_bit_1 = 1;
        this.coordinate_x = firstchar - 'A';
      }
      if (secondchar >= '0' && secondchar <= '9') {
        valid_bit_2 = 1;
        this.coordinate_y = secondchar - '0';
      }
      if (thirdchar == 'H' || thirdchar == 'V' || thirdchar == 'U' || thirdchar == 'D'
          || thirdchar == 'L' || thirdchar == 'R') {
        valid_bit_3 = 1;
        this.direction = thirdchar;
      }
    }
    this.is_valid = valid_bit_0 & valid_bit_1 & valid_bit_2 & valid_bit_3;
  }

  public int getCoordinateX() {
    return this.coordinate_x;
  }
  public int getCoordinateY() {
    return this.coordinate_y;
  }
  public char getDirection() {
    return this.direction;
  }
  public int getValid() {
    return this.is_valid;
  }
}
