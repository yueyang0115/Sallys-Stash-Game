package edu.duke.ece651.sallysstash;

public class Pixel {
  private int is_occupied;
  private int is_hitted;
  private int is_missed;
  private char color;
  // private Shape shape;
  // private int start_x;
  // private int start_y;

  public Pixel() {
    this.color = ' ';
  }

  public void setOccupied(int i) {
    this.is_occupied = i;
  }
  public void setHitted(int i) {
    this.is_hitted = i;
  }
  public void setMissed(int i) {
    this.is_missed = i;
  }
  public void setColor(char c) {
    this.color = c;
  }

  public int getOccupied() {
    return this.is_occupied;
  }
  public int getHitted() {
    return this.is_hitted;
  }
  public int getMissed() {
    return this.is_missed;
  }
  public char getColor() {
    return this.color;
  }
  /*
  public void setShape(Shape myshape) {
    this.shape = myshape;
    this.color = myshape.getColor();
  }
  public void setCoordinate(int i, int j) {
    this.start_x = i;
    this.start_y = j;
    }*/
}
