package edu.duke.ece651.sallysstash;

import java.util.HashMap;
import java.util.HashSet;

public class ShapeAdapter {
  public static HashMap<String, HashMap<int[], int[]>> AllMap;
  static {
    AllMap = new HashMap<String, HashMap<int[], int[]>>();

    HashMap<int[], int[]> gHMap = new HashMap<int[], int[]>();
    gHMap.put(new int[] {0, 0},
        new int[] {1, 2, 1, 1}); //(x_offset,y_offset),(height,width,order,flip_order_flag)
    AllMap.put("GH", gHMap); // 1+i*1= order

    HashMap<int[], int[]> gVMap = new HashMap<int[], int[]>();
    gVMap.put(new int[] {0, 0}, new int[] {2, 1, 1, 1});
    AllMap.put("GV", gVMap);

    HashMap<int[], int[]> pHMap = new HashMap<int[], int[]>();
    pHMap.put(new int[] {0, 0}, new int[] {1, 3, 1, 1});
    AllMap.put("PH", pHMap);

    HashMap<int[], int[]> pVMap = new HashMap<int[], int[]>();
    pVMap.put(new int[] {0, 0}, new int[] {3, 1, 1, 1});
    AllMap.put("PV", pVMap);

    HashMap<int[], int[]> rUMap = new HashMap<int[], int[]>();
    rUMap.put(new int[] {0, 0}, new int[] {1, 1, 1, 1}); // order=1+i*1
    rUMap.put(new int[] {1, -1}, new int[] {1, 3, 2, 1});
    AllMap.put("RU", rUMap);

    HashMap<int[], int[]> rRMap = new HashMap<int[], int[]>();
    rRMap.put(new int[] {1, 1}, new int[] {1, 1, 1, 1});
    rRMap.put(new int[] {0, 0}, new int[] {3, 1, 2, 1}); // order = 2+i*1
    AllMap.put("RR", rRMap);

    HashMap<int[], int[]> rDMap = new HashMap<int[], int[]>();
    rDMap.put(new int[] {0, 0}, new int[] {1, 3, 4, -1}); // order=4-i*1
    rDMap.put(new int[] {1, 1}, new int[] {1, 1, 1, -1});
    AllMap.put("RD", rDMap);

    HashMap<int[], int[]> rLMap = new HashMap<int[], int[]>();
    rLMap.put(new int[] {0, 0}, new int[] {3, 1, 4, -1});
    rLMap.put(new int[] {1, -1}, new int[] {1, 1, 1, -1});
    AllMap.put("RL", rLMap);

    HashMap<int[], int[]> bUMap = new HashMap<int[], int[]>();
    bUMap.put(new int[] {0, 0}, new int[] {3, 1, 1, 1});
    bUMap.put(new int[] {2, 1}, new int[] {3, 1, 4, 1});
    AllMap.put("BU", bUMap);

    HashMap<int[], int[]> bRMap = new HashMap<int[], int[]>();
    bRMap.put(new int[] {0, 0}, new int[] {1, 3, 1, 1});
    bRMap.put(new int[] {-1, 2}, new int[] {1, 3, 4, 1});
    AllMap.put("BR", bRMap);

    HashMap<int[], int[]> bDMap = new HashMap<int[], int[]>();
    bDMap.put(new int[] {0, 0}, new int[] {3, 1, 6, -1});
    bDMap.put(new int[] {2, -1}, new int[] {3, 1, 3, -1});
    AllMap.put("BD", bDMap);

    HashMap<int[], int[]> bLMap = new HashMap<int[], int[]>();
    bLMap.put(new int[] {0, 0}, new int[] {1, 3, 6, -1});
    bLMap.put(new int[] {1, 2}, new int[] {1, 3, 3, -1});
    AllMap.put("BL", bLMap);
  }

  private int x;
  private int y;
  private char color;
  private char direction;
  private String shape;
  private Board board;
  private int id;
  private int is_valid;
  private HashMap<int[], int[]> map;

  public ShapeAdapter(int my_x, int my_y, char mycolor, char mydirection, Board myboard, int myid) {
    this.x = my_x;
    this.y = my_y;
    this.color = mycolor;
    this.direction = mydirection;
    this.board = myboard;
    this.shape = Character.toString(this.color) + Character.toString(this.direction);
    this.id = myid;
    Check();
  }

  private void Check() {
    if (AllMap.get(shape) == null) {
      this.is_valid = 0;
      // System.out.println("\nInvalid direction for this shape. Please retype!");
    } else {
      this.map = AllMap.get(shape);
      CheckAll();
    }
  }

  private void CheckAll() {
    for (HashMap.Entry<int[], int[]> entry : this.map.entrySet()) {
      int x_offset = entry.getKey()[0];
      int y_offset = entry.getKey()[1];
      int height = entry.getValue()[0];
      int width = entry.getValue()[1];
      CheckRectangle(x_offset, y_offset, height, width);
      if (this.is_valid == 0) {
        return;
      }
    }
  }

  private void CheckRectangle(int x_offset, int y_offset, int height, int width) {
    int new_x = this.x + x_offset;
    int new_y = this.y + y_offset;
    if ((new_x >= 0 && new_x < board.getHeighth())
        && ((new_x + height - 1 >= 0) && (new_x + height - 1 < board.getHeighth()))
        && ((new_y >= 0) && (new_y < board.getWidth()))
        && ((new_y + width - 1 >= 0) && (new_y + width - 1 < board.getWidth()))) {
      this.is_valid = 1;
    } else {
      this.is_valid = 0;
      // System.out.println("\nInvalid location, stack goes off the grid. Please retype!");
      return;
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if ((board.getPixel(new_x + i, new_y + j).getOccupied() == 1)
            && (board.getPixel(new_x + i, new_y + j).getID() != this.id)) {
          this.is_valid = 0;
        }
      }
    }
    if (this.is_valid == 0) {
      // System.out.println("\nInvalid location, stack collides with other stacks on board. Please
      // retype!");
    }
  }

  public void Create() {
    SuperStack stack = new SuperStack(map, color, id);
    stack.putonBoard(x, y, board);
  }
  public void Move(HashSet<Integer> hit_set) {
    SuperStack stack = new SuperStack(map, color, id);
    stack.movetoBoard(x, y, board, hit_set);
  }

  public int getValid() {
    return this.is_valid;
  }
}
