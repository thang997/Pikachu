/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pikachu;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Hp Pavilion
 */
public class Level {
    private int[][] Board = new int[13][20];

    public Level() {
        initData();
    }

    public int getValue(int x, int y) {
        return Board[x][y];
    }

    public void setValue(Point p1, Point p2) {
       Board[p1.x][p1.y]=0;
       Board[p2.x][p2.y]=0;       
    }

   
    
    
    //matrix gom 13 hang va 20 cot, 
    //4 hang, cot phia ngoai=-1
    //4 hang, cot phia trong tiep theo =0
    private void initData(){
        for(int row=0;row<13;row++){
            for(int column=0;column<20;column++){
                if(row==0 || row==12 ||column==0 ||column==19){
                    Board[row][column]=-1;
                }else{
                    Board[row][column]=0;
                }
                                           
            }    
        }
        Random random = new Random();  
        
        for(int row=2;row<11;row++){
            for(int column=2;column<18;column++){
                if(Board[row][column]==0){
                    Board[row][column] = random.nextInt(30)+1;
                    int count=0;
                    for(int a=2;a<11;a++){
                        for(int b=2;b<18;b++){
                            if(Board[a][b]==0){
                                count++;
                            }
                        }
                    }
                    int cell = random.nextInt(count)+1;
                    count=0;
                    for(int a=2;a<11;a++){
                        for(int b=2;b<18;b++){
                            if(Board[a][b]==0){
                                count++;
                                if(count==cell){
                                    Board[a][b]=Board[row][column];
                                }
                            }
                        }
                    }
                }                                
            }    
        }
    }  
    
    public void printfBoard(){ 
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(Board[i][j] + "\t");
            }
            System.out.println();
        }     
    }
    
    public void checkBoard(){
        int total = 0;
        for(int a=1;a<=30;a++){
            int count =0;
            for (int i = 0; i < 13; i++) {               
                for (int j = 0; j < 20; j++) {
                    if(Board[i][j]==a){
                        count++;
                    }
                }           
            }
            System.out.println(a+":"+ count);
            total = total+count;
        }
        System.out.println(total);
    }  
}
