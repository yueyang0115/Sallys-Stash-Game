package edu.duke.ece651.sallysstash;

public class Pixel {
  private int is_occupied;
  private int is_hitted;
  private int is_missed;
  private char color;
  private int id;
  private int order; // order in a stack(e.g. 1,2,3
  private char toself;
  private char toother;
  // private Shape shape;
  // private int start_x;
  // private int start_y;

  public Pixel() {
    // this.color = ' ';
    this.toself = ' ';
    this.toother = ' ';
  }

  public void setOccupied(int i) {
    this.is_occupied = i;
    if (i == 0) {
      this.toself = ' ';
    }
  }

  public void setMoveHitted(int i) {
    this.is_hitted = i;
    if (i == 1) {
      this.toself = '*';
    }
  }

  public void setHitted(int i) {
    this.is_hitted = i;
    if (i == 1) {
      this.toself = '*';
      this.toother = this.color;
    }
  }
  public void setMissed(int i) {
    this.is_missed = i;
    if (i == 1) {
      this.toother = 'X';
    }
  }
  public void setColor(char c) {
    this.color = c;
    this.toself = this.color;
  }
  public void setID(int i) {
    this.id = i;
  }
  public void setOrder(int i) {
    this.order = i;
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
  public int getID() {
    return this.id;
  }
  public int getOrder() {
    return this.order;
  }
  public char getToself() {
    return this.toself;
  }
  public char getToother() {
    return this.toother;
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
