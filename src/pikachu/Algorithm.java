/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pikachu;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import pikachu.InGame;

/**
 *
 * @author Hp Pavilion
 */
public class Algorithm {

    public Level level1 = new Level();

    public Algorithm() {
    }

    //check with line x, y1 next y2
    //(5)
    private boolean checkNextX(int x, int y1, int y2) {
        StaticFinalvariable.p1 = new Point(x, y1);
        StaticFinalvariable.p2 = new Point(x, y2);
        return true;
    }

    //check with line x, y1 next y2
    //(6)
    private boolean checkNextY(int x1, int x2, int y) {
        StaticFinalvariable.p1 = new Point(x1, y);
        StaticFinalvariable.p2 = new Point(x2, y);
        return true;
    }

    // check with line x, from column y1 to y2
    //(7)
    private boolean checkLineX(int x, int y1, int y2) {
        // find point have column max and min
        int min = Math.min(y1, y2);
        int max = Math.max(y1, y2);
        // run column
        if (max - min == 1 && level1.getValue(x, min) != 0 && level1.getValue(x, max) != 0) {
            return false;
        }

        for (int y = min + 1; y < max; y++) {
            if (level1.getValue(x, y) != 0) {
                return false;
            }
        }
        StaticFinalvariable.p1 = new Point(x, y1);
        StaticFinalvariable.p2 = new Point(x, y2);
        return true;
    }

    // check with line y, from column x1 to x2
    //(8)
    private boolean checkLineY(int x1, int x2, int y) {
        int min = Math.min(x1, x2);
        int max = Math.max(x1, x2);
        if (max - min == 1 && level1.getValue(min, y) != 0 && level1.getValue(max, y) != 0) {
            return false;
        }

        for (int x = min + 1; x < max; x++) {
            if (level1.getValue(x, y) != 0) {
                return false;
            }
        }
        StaticFinalvariable.p1 = new Point(x1, y);
        StaticFinalvariable.p2 = new Point(x2, y);
        return true;
    }

    //check with (x,y) va (x+1,y+1)
    //(9)
    private boolean checkNextLineXY(Point p1, Point p2) {
        if (p1.x < p2.x) {
            if (p1.y < p2.y) {
                if (level1.getValue(p1.x + 1, p1.y) == 0) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x + 1, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (level1.getValue(p1.x, p1.y + 1) == 0) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p1.y + 1);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (level1.getValue(p1.x + 1, p1.y) == 0) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x + 1, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (level1.getValue(p1.x, p1.y - 1) == 0) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p1.y - 1);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (p1.y < p2.y) {
                if (level1.getValue(p2.x + 1, p2.y) == 0) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x + 1, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (level1.getValue(p2.x, p2.y - 1) == 0) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p2.y - 1);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (level1.getValue(p2.x + 1, p2.y) == 0) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x + 1, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (level1.getValue(p2.x, p2.y + 1) == 0) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p2.y + 1);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    //(10)
    private boolean checkNextLineX(Point p1, Point p2) {
        if (p1.x < p2.x) {
            if (p1.y < p2.y) {
                if (checkLineX(p1.x, p1.y, p2.y + 1) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineX(p1.x + 1, p1.y - 1, p2.y) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x + 1, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (checkLineX(p1.x, p1.y, p2.y - 1) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineX(p1.x + 1, p1.y + 1, p2.y) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            }

        } else {
            if (p1.y < p2.y) {
                if (checkLineX(p1.x, p1.y, p2.y + 1) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineX(p1.x - 1, p1.y - 1, p2.y) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (checkLineX(p1.x, p1.y, p2.y - 1) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineX(p1.x - 1, p1.y + 1, p2.y) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            }

        }
    }

    //(12)
    private boolean checkNextLineY(Point p1, Point p2) {
        if (p1.y < p2.y) {
            if (p1.x < p2.x) {
                if (checkLineY(p1.x, p2.x + 1, p1.y) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineY(p1.x - 1, p2.x, p1.y + 1) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            } else {    
                if (checkLineY(p1.x, p2.x - 1, p1.y) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineY(p1.x + 1, p2.x, p1.y + 1) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            }

        } else {
            if (p1.x < p2.x) {
                if (checkLineY(p1.x, p2.x + 1, p1.y) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineY(p1.x - 1, p2.x, p1.y - 1) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (checkLineY(p1.x, p2.x - 1, p1.y) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineY(p1.x + 1, p2.x, p1.y - 1) == true) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            }

        }
    }

    //13
    //2 o cach xa dong,xa cot nhung 2 can 2 duong de an
    private boolean checkTowLine(Point p1, Point p2) {
        if (p1.x < p2.x) {
            if (p1.y < p2.y) {
                if (checkLineX(p1.x, p1.y, p2.y + 1) && checkLineY(p1.x - 1, p2.x, p2.y)) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineX(p2.x, p1.y - 1, p2.y) && checkLineY(p1.x, p2.x + 1, p1.y)) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (checkLineX(p1.x, p1.y, p2.y - 1) && checkLineY(p1.x - 1, p2.x, p2.y)) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineX(p2.x, p1.y + 1, p2.y) && checkLineY(p1.x, p2.x + 1, p1.y)) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (p1.y < p2.y) {
                if (checkLineX(p1.x, p1.y, p2.y + 1) && checkLineY(p1.x + 1, p2.x, p2.y)) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineX(p2.x, p1.y - 1, p2.y) && checkLineY(p1.x, p2.x - 1, p1.y)) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (checkLineX(p1.x, p1.y, p2.y - 1) && checkLineY(p1.x + 1, p2.x, p2.y)) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p1.x, p2.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else if (checkLineX(p2.x, p1.y + 1, p2.y) && checkLineY(p1.x, p2.x - 1, p1.y)) {
                    StaticFinalvariable.p1 = p1;
                    StaticFinalvariable.p2 = new Point(p2.x, p1.y);
                    StaticFinalvariable.p3 = p2;
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

    //check 3 line
    // check in rectangle
    //(14)
    private boolean checkRectX(Point p1, Point p2) {
        // find point have y min and max
        Point pMinY = p1, pMaxY = p2;
        if (p1.y > p2.y) {
            pMinY = p2;
            pMaxY = p1;
        }
        for (int y = pMinY.y + 1; y < pMaxY.y; y++) {
            // check three line
            if (checkLineX(pMinY.x, pMinY.y, y + 1)
                    && checkLineY(pMinY.x - 1, pMaxY.x + 1, y)
                    && checkLineX(pMaxY.x, y - 1, pMaxY.y)) {
                StaticFinalvariable.p1 = pMinY;
                StaticFinalvariable.p2 = new Point(pMinY.x, y);
                StaticFinalvariable.p3 = new Point(pMaxY.x, y);
                StaticFinalvariable.p4 = pMaxY;
                return true;
            }
        }
        // have a line in three line not true then return -1
        return false;
    }

    //(15)
    private boolean checkRectY(Point p1, Point p2) {
        // find point have y min
        Point pMinX = p1, pMaxX = p2;
        if (p1.x > p2.x) {
            pMinX = p2;
            pMaxX = p1;
        }
        // find line and y begin
        for (int x = pMinX.x + 1; x < pMaxX.x; x++) {
            if (checkLineY(pMinX.x, x + 1, pMinX.y)
                    && checkLineX(x, pMinX.y - 1, pMaxX.y + 1)
                    && checkLineY(x - 1, pMaxX.x, pMaxX.y)) {
                StaticFinalvariable.p1 = pMinX;
                StaticFinalvariable.p2 = new Point(x, pMinX.y);
                StaticFinalvariable.p3 = new Point(x, pMaxX.y);
                StaticFinalvariable.p4 = pMaxX;
                return true;
            }
        }
        return false;
    }

    //(16)
    private boolean checkMoreLineRightX(Point p1, Point p2) {
        // find point have y min
        Point pMinY = p1, pMaxY = p2;
        if (p1.y > p2.y) {
            pMinY = p2;
            pMaxY = p1;
        }
        // find line and y begin
        int y = pMaxY.y;
        int row = pMinY.x;
        // check more
        if (checkLineX(row, pMinY.y, pMaxY.y + 1)) {
            while (level1.getValue(pMinY.x, y + 1) == 0
                    && level1.getValue(pMaxY.x, y + 1) == 0) {
                if (checkLineY(pMinY.x, pMaxY.x, y + 1)) {
                    StaticFinalvariable.p1 = pMinY;
                    StaticFinalvariable.p2 = new Point(pMinY.x, y + 1);
                    StaticFinalvariable.p3 = new Point(pMaxY.x, y + 1);
                    StaticFinalvariable.p4 = pMaxY;
                    return true;
                }
                y += 1;
            }
        }
        return false;
    }

    //(17)
    private boolean checkMoreLineLeftX(Point p1, Point p2) {
        // find point have y min
        Point pMinY = p1, pMaxY = p2;
        if (p1.y > p2.y) {
            pMinY = p2;
            pMaxY = p1;
        }
        // find line and y begin
        int y = pMinY.y;
        int row = pMaxY.x;
        // check more
        if (checkLineX(row, pMinY.y - 1, pMaxY.y)) {
            while (level1.getValue(pMinY.x, y - 1) == 0
                    && level1.getValue(pMaxY.x, y - 1) == 0) {
                if (checkLineY(pMinY.x, pMaxY.x, y - 1)) {
                    StaticFinalvariable.p1 = pMinY;
                    StaticFinalvariable.p2 = new Point(pMinY.x, y - 1);
                    StaticFinalvariable.p3 = new Point(pMaxY.x, y - 1);
                    StaticFinalvariable.p4 = pMaxY;
                    return true;
                }
                y -= 1;
            }
        }
        return false;
    }

    //(18)
    private boolean checkMoreLineDownY(Point p1, Point p2) {
        Point pMinX = p1, pMaxX = p2;
        if (p1.x > p2.x) {
            pMinX = p2;
            pMaxX = p1;
        }
        int row = pMaxX.x;
        int col = pMinX.y;

        if (checkLineY(pMinX.x, pMaxX.x + 1, col)) {
            while (level1.getValue(row + 1, pMinX.y) == 0
                    && level1.getValue(row + 1, pMaxX.y) == 0) {
                if (checkLineX(row + 1, pMinX.y, pMaxX.y)) {
                    StaticFinalvariable.p1 = pMinX;
                    StaticFinalvariable.p2 = new Point(row + 1, pMinX.y);
                    StaticFinalvariable.p3 = new Point(row + 1, pMaxX.y);
                    StaticFinalvariable.p4 = pMaxX;
                    return true;
                }
                row += 1;
            }
        }
        return false;
    }

    //(19)
    private boolean checkMoreLineUpY(Point p1, Point p2) {
        Point pMinX = p1, pMaxX = p2;
        if (p1.x > p2.x) {
            pMinX = p2;
            pMaxX = p1;
        }
        int x = pMinX.x;
        int col = pMaxX.y;
        if (checkLineY(pMinX.x - 1, pMaxX.x, col)) {
            while (level1.getValue(x - 1, pMinX.y) == 0
                    && level1.getValue(x - 1, pMaxX.y) == 0) {
                if (checkLineX(x - 1, pMinX.y, pMaxX.y)) {
                    StaticFinalvariable.p1 = pMinX;
                    StaticFinalvariable.p2 = new Point(x - 1, pMinX.y);
                    StaticFinalvariable.p3 = new Point(x - 1, pMaxX.y);
                    StaticFinalvariable.p4 = pMaxX;
                    return true;
                }
                x -= 1;
            }
        }
        return false;
    }

    //check 2 point
    public boolean checkTwoPoint(Point p1, Point p2) {
        if (level1.getValue(p1.x, p1.y) == level1.getValue(p2.x, p2.y)) {

            //(5)check next X
            if (p1.x == p2.x && Math.abs(p1.y - p2.y) == 1) {
                if (checkNextX(p1.x, p1.y, p2.y)) {
                    System.out.println("5");
                    return true;
                }
            }

            //(6)check next Y
            if (p1.y == p2.y && Math.abs(p1.x - p2.x) == 1) {
                if (checkNextY(p1.x, p2.x, p1.y)) {
                    System.out.println("6");
                    return true;
                }
            }

            //(7)check line with x
            if (p1.x == p2.x) {
                if (checkLineX(p1.x, p1.y, p2.y)) {
                    System.out.println("7");
                    return true;
                }
            }
            //(8) check line with y
            if (p1.y == p2.y) {
                if (checkLineY(p1.x, p2.x, p1.y)) {
                    System.out.println("8");
                    return true;
                }
            }

            //(9)
            if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 1) {
                if (checkNextLineXY(p1, p2)) {
                    System.out.println("9");
                    return true;
                }
            }
            //(10) (11) 2 dong x lien tiep nhau nhung y cach xa
            if (Math.abs(p1.x - p2.x) == 1) {
                if (checkNextLineX(p1, p2)) {
                    System.out.println("10");
                    return true;
                }
            }
            //(12) 2 dong y lien tieo nhau nhung x cach xa
            if (Math.abs(p1.y - p2.y) == 1) {
                if (checkNextLineY(p1, p2)) {
                    System.out.println("12");
                    return true;
                }
            }

            //2 o cach xa dong,xa cot nhung 2 can 2 duong de an
            //(13)
            if (checkTowLine(p1, p2)) {
                System.out.println("13");
                return true;
            }

            //(14)
            if (checkRectX(p1, p2)) {
                System.out.println("14");
                return true;
            }
            //(15)
            if (checkRectY(p1, p2)) {
                System.out.println("15");
                return true;
            }

            //16
            if (checkMoreLineRightX(p1, p2)) {
                System.out.println("16");
                return true;
            }
            //17
            if (checkMoreLineLeftX(p1, p2)) {
                System.out.println("17");
                return true;
            }

            //18
            if (checkMoreLineUpY(p1, p2)) {
                System.out.println("18");
                return true;
            }

            //19
            if (checkMoreLineDownY(p1, p2)) {
                System.out.println("19");
                return true;
            }

        }
        return false;
    }

    public void settohide(Point p1, Point p2) {
        level1.setValue(p1, p2);
    }

    public boolean checkToChange() {
        for (int i = 2; i < 11; i++) {
            for (int j = 2; j < 18; j++) {
                if (level1.getValue(i, j) != 0) {
                    for (int a = 2; a < 11; a++) {
                        for (int b = 2; b < 18; b++) {
                            if ((i != a || j != b) && checkTwoPoint(new Point(i, j), new Point(a, b))) {
                                System.out.println(i + "," + j + "," + a + "," + b);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Looxi");
        return false;
    }
}
