package edu.duke.ece651.sallysstash;

public class InputHandler {
  private String input;
  private char color;
  private Board board;

  private int coordinate_x;
  private int coordinate_y;
  private char direction;
  private String shape;

  private int height;
  private int width;

  private int bit_valid;
  private int location_valid;
  private int is_valid;

  public InputHandler(String myinput, char mycolor, Board myboard) {
    this.input = myinput;
    this.color = mycolor;
    this.board = myboard;
    this.bit_valid = 0;
    this.location_valid = 0;
    BitCheck();
    if (this.bit_valid == 1) {
      ParseInput();
      LocationCheck();
    }
    this.is_valid = this.bit_valid & this.location_valid;
  }

  private void BitCheck() {
    int valid_bit_0 = 0;
    int valid_bit_1 = 0;
    int valid_bit_2 = 0;
    int valid_bit_3 = 0;
    char firstchar = input.charAt(0);
    char secondchar = input.charAt(1);
    char thirdchar = input.charAt(2);

    if (input.length() == 3) {
      valid_bit_0 = 1;
    }
    if ((firstchar >= 'A' && firstchar <= 'T') || (firstchar >= 'a' && firstchar <= 't')) {
      valid_bit_1 = 1;
    }
    if (secondchar >= '0' && secondchar <= '9') {
      valid_bit_2 = 1;
    }
    if (thirdchar == 'h' || thirdchar == 'H' || thirdchar == 'v' || thirdchar == 'V') {
      valid_bit_3 = 1;
    }
    this.bit_valid = valid_bit_0 & valid_bit_1 & valid_bit_2 & valid_bit_3;
    System.out.println("bit_valid in bit check=" + bit_valid);
  }

  private void ParseInput() {
    String temp = input.substring(0).toUpperCase();
    this.coordinate_x = temp.charAt(0) - 'A';
    this.coordinate_y = input.charAt(1) - '0';
    String temp_str = input.substring(2).toUpperCase();
    this.direction = temp_str.charAt(0);
    this.shape = Character.toString(color) + Character.toString(this.direction);
  }

  private void LocationCheck() {
    this.location_valid = ShapeAdapter.LocationCheck(coordinate_x, coordinate_y, shape, board);
    this.height = ShapeAdapter.getHeight(this.shape);
    this.width = ShapeAdapter.getWidth(this.shape);
    System.out.println("location_valid=" + location_valid);
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
  public int getHeight() {
    return this.height;
  }
  public int getWidth() {
    return this.width;
  }
}
