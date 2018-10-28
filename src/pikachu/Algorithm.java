/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pikachu;

import java.awt.Point;

/**
 *
 * @author Hp Pavilion
 */
public class Algorithm {
    
    Level level1 = new Level();

    public Algorithm() {
    }

    public Level getLevel1() {
        return level1;
    }   
    
    //p1 and p2 nam tren cung 1 hang hoac cot dau tien hoac cuoi cung
    //(1)
    private boolean checkLineXFirst(int x, int y1, int y2){       
            
            return true;     
    }
    //(2)
    private boolean checkLineXLast(int x, int y1, int y2){        
            
            return true;
    }
    //(3)
    private boolean checkLineYFirst(int x1, int x2, int y){
            
            return true;
    }
    //(4)
    private boolean checkLineYLast(int x1, int x2, int y){
           
            return true;
    }
    
    //check with line x, y1 next y2
    //(5)
    private boolean checkNextX( int x,int y1, int y2){
            
            return true;
    }
    
    //check with line x, y1 next y2
    //(6)
    private boolean checkNextY(int x1, int x2, int y){
        return true;
    }
    
    // check with line x, from column y1 to y2
    //(7)
    private boolean checkLineX( int x,int y1, int y2) {
        // find point have column max and min
        int min = Math.min(y1, y2);
        int max = Math.max(y1, y2);
        // run column
        for (int y = min+1; y < max; y++) {
            if (level1.getValue(x, y) !=0) { // if see barrier then die
                System.out.println("die: " + x + "" + y);
                return false;
            }            
        }
        
        // not die -> success
        return true;
    }
    
    // check with line y, from column x1 to x2
    //(8)
    private boolean checkLineY(int x1, int x2, int y) {
        int min = Math.min(x1, x2);
        int max = Math.max(x1, x2);
        for (int x = min+1; x < max; x++) {
            if (level1.getValue(x, y) !=0) {               
                return false;
            }           
        }
       
        return true;
    }
    
    //check with (x,y) va (x+1,y+1)
    //(9)
    private boolean checkNextLineXY(Point p1, Point p2){ 
        if(p1.x <p2.x){
            if(p1.y<p2.y){
                if (level1.getValue(p1.x+1, p1.y) !=0 && level1.getValue(p1.x, p1.y+1) !=0) {                 
                    return false;
                }else{
                    return true;
                }   
            }else{
                if (level1.getValue(p1.x+1, p1.y) !=0 && level1.getValue(p1.x, p1.y-1) !=0) {                 
                    return false;
                }else{
                    return true;
                }   
            }
        }else{
            if(p1.y<p2.y){
                if (level1.getValue(p2.x+1, p2.y) !=0 && level1.getValue(p2.x, p2.y-1) !=0) {                 
                    return false;
                }else{
                    return true;
                }   
            }else{
                if (level1.getValue(p2.x+1, p2.y) !=0 && level1.getValue(p2.x, p2.y+1) !=0) {                 
                    return false;
                }else{
                    return true;
                }   
            }
        }
    }
    
    //(10)
    private boolean checkNextLineX(Point p1, Point p2){
        if(p1.x<p2.x){           
            if(checkLineX(p1.x, p1.y, p2.y)==true ||checkLineX(p1.x+1, p1.y, p2.y)==true){
                return true;
            }else{
                return false;
            }
        }else{
            if(checkLineX(p1.x, p1.y, p2.y)==true ||checkLineX(p1.x-1, p1.y, p2.y)==true){
                return true;
            }else{
                return false;
            }
        }
    }
    
    //(11)
    private boolean checkNextLineY(Point p1, Point p2){
        if(p1.y<p2.y){           
            if(checkLineY(p1.x, p2.x, p1.y)==true ||checkLineY(p1.x, p2.x, p2.y+1)==true){
                return true;
            }else{
                return false;
            }
        }else{
            if(checkLineY(p1.x, p2.x, p1.y)==true ||checkLineY(p1.x, p2.x, p2.y-1)==true){
                return true;
            }else{
                return false;
            }
        }
    }
    
    //2 o cach xa dong,xa cot nhung 2 can 2 duong de an
    private boolean checkTowLine(Point p1, Point p2){
        if((checkLineX(p1.x, p1.y, p2.y)&&checkLineY(p1.x, p2.x, p2.y)) ||
                (checkLineX(p2.x, p2.y, p1.y)&&checkLineY(p1.x, p2.x, p1.y))){
            return true;
        }else{
            return false;
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
            if (checkLineX(pMinY.x, pMinY.y, y)
                    && checkLineY(pMinY.x, pMaxY.x, y)
                    && checkLineX(pMaxY.x,y, pMaxY.y)) {     
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
            if (checkLineY(pMinX.x, x, pMinX.y)
                    && checkLineX(x, pMinX.y, pMaxX.y)
                    && checkLineY(x, pMaxX.x, pMaxX.y)) {
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
        if (checkLineX(row,pMinY.y, pMaxY.y+1)) {
            while (level1.getValue(pMinY.x,y+1) ==0
                    && level1.getValue(pMaxY.x,y+1)==0) {
                if (checkLineY(pMinY.x, pMaxY.x, y+1)) {
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
        if (checkLineX(row,pMinY.y-1, pMaxY.y)) {
            while (level1.getValue(pMinY.x,y-1) ==0
                    && level1.getValue(pMaxY.x,y-1)==0) {
                if (checkLineY(pMinY.x, pMaxY.x, y-1)) {
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
        int x = pMaxX.x;
        int col = pMinX.y;
        
        if (checkLineY(pMinX.x, pMaxX.x+1, col)) {
            while (level1.getValue(x+1,pMinX.y) ==0
                    && level1.getValue(x+1,pMaxX.y) ==0) {
                if (checkLineX(x+1, pMinX.y, pMaxX.y)) {                   
                    return true;
                }
                x += 1;
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
        if (checkLineY(pMinX.x-1, pMaxX.x, col)) {
            while (level1.getValue(x-1,pMinX.y) ==0
                    && level1.getValue(x-1,pMaxX.y) ==0) {
                if (checkLineX(x-1, pMinX.y, pMaxX.y)) {                   
                    return true;
                }
                x -= 1;
            }
        }
        return false;
    }
       
    //(20)
    private boolean checkStraightLineX(Point p1, Point p2){
        int type=1;
        while (level1.getValue(p1.x+type,p1.y) ==0
            && level1.getValue(p2.x+type,p2.y) ==0) {
            if (checkLineX(p1.x+type,p1.y,p2.y)) {                   
                return true;
            }
            p1.x += type;
        }
        type = -1;
        while (level1.getValue(p1.x+type,p1.y) ==0
            && level1.getValue(p2.x+type,p2.y) ==0) {
            if (checkLineX(p1.x+type,p1.y,p2.y)) {                   
                return true;
            }
            p1.x += type;
        }
        
        return false;
    }
    
    //(21)
    private boolean checkStraightLineY(Point p1, Point p2){
        int type=1;
        while (level1.getValue(p1.x,p1.y+type) ==0
            && level1.getValue(p2.x,p2.y+type) ==0) {
            if (checkLineY(p1.x,p2.x,p1.y+type)) {                   
                return true;
            }
            p1.x += type;
        }
        type = -1;
        while (level1.getValue(p1.x,p1.y+type) ==0
            && level1.getValue(p2.x,p2.y+type) ==0) {
            if (checkLineY(p1.x,p2.x,p1.y+type)) {                   
                return true;
            }
            p1.x += type;
        }
        
        return false;
    }

    //check 2 point
    public boolean checkTwoPoint(Point p1, Point p2) {
        if(level1.getValue(p1.x, p1.y)==level1.getValue(p2.x, p2.y)){          
            //(1)
            if((p1.x==p2.x)&&p1.x==2){
                if(checkLineXFirst(p1.x,p1.y,p2.y));
                return true;
            }
            //(2)
            if((p1.x==p2.x)&&p1.x==10){
                if(checkLineXFirst(p1.x,p1.y,p2.y));
                return true;
            }
            //(3)
            if((p1.y==p2.y)&&p1.y==2){
                if(checkLineXFirst(p1.x,p2.x,p1.y));
                return true;
            }
            //(4)
            if((p1.y==p2.y)&&p1.x==17){
                if(checkLineXFirst(p1.x,p2.x,p1.y));
                return true;
            }

            //(5)check next X
            if(p1.x==p2.x && Math.abs(p1.y-p2.y)==1){
                if (checkNextX(p1.x, p1.y, p2.y)) {
                    return true;
                }
            }

            //(6)check next Y
            if(p1.y==p2.y && Math.abs(p1.x-p2.x)==1){
                if (checkNextY(p1.x, p2.x, p1.y)) {
                    return true;
                }
            }

            //(7)check line with x
            if (p1.x == p2.x) {
                if (checkLineX( p1.x, p1.y, p2.y)) {
                    return true;
                }
            }
            //(8) check line with y
            if (p1.y == p2.y) {
                if (checkLineY(p1.x, p2.x, p1.y)) {
                    return true;
                }
            }
            
            //(9)
            if(Math.abs(p1.x-p2.x)==1 && Math.abs(p1.y-p2.y)==1){
                if(checkNextLineXY(p1,p2)){
                    return true;
                }
            }
            //(10) (11) 2 dong x lien tiep nhau nhung y cach xa
            if(Math.abs(p1.x-p2.x)==1){
                if(checkNextLineX(p1, p2)){
                    return true;
                }
            }            
            //(12) 2 dong y lien tieo nhau nhung x cach xa
            if(Math.abs(p1.x-p2.x)==1){
                if(checkNextLineY(p1, p2)){
                    return true;
                }
            }
            
            //2 o cach xa dong,xa cot nhung 2 can 2 duong de an
            //(13)
            if(checkTowLine(p1, p2)){
                return true;
            }
            
            //(14)
            if(checkRectX(p1, p2)){
                return true;
            }
            //(15)
            if(checkRectY(p1, p2)){
                return true;
            }
            
            //16
            if(checkMoreLineRightX(p1, p2)){
                return true;
            }
            //17
            if(checkMoreLineLeftX(p1, p2)){
                return true;
            }
            
            //18
            if(checkMoreLineUpY(p1, p2)){
                return true;
            }
            
            //19
            if(checkMoreLineDownY(p1, p2)){
                return true;
            }
            //20
            if(checkStraightLineX(p1, p2)){
                return true;
            }
            //21
            if(checkStraightLineY(p1, p2)){
                return true;
            }
        }
        return false;
    }
    
    public void settohide(Point p1, Point p2){
        level1.setValue(p1, p2);
    }
}
