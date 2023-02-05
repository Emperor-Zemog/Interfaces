import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class BigRectLister {
    public static void main (String[] args)  throws IOException {
        int fileIndex = 0;
        ArrayList<Rectangle> inList = new ArrayList<Rectangle>();
        ArrayList<Rectangle> outList = new ArrayList<Rectangle>();
        VMGMule eagle = new VMGMule(new Scanner(System.in));
        Boolean inputDone = false;
        Boolean saveRec = false;
        Boolean done = false;
        while(inputDone == false) {
            int height = eagle.getStuntedInt("Height of the Rectangle ",1);
            int width = eagle.getStuntedInt("Width of the Rectangle ",1);
            saveRec = eagle.getUserConfirm("Do you want to add this Rectangle to the List?");
            if(saveRec == true){
                inList.add(new Rectangle(width,height));
                saveRec =false;
            }

            inputDone = eagle.getUserConfirm("Are you done with input");
        }




        System.out.println("______Rectangles Input______");
        for(int c=0; c<inList.size();c++){
            System.out.println(inList.get(c).toString());
        }
        System.out.println("______Rectangles Input that have a perimeter greater then 10______");
        outList=collectAll(inList);
        for(int y=0; y<outList.size();y++){
            System.out.println(outList.get(y).toString());
        }
    }

    public static ArrayList<Rectangle> collectAll(ArrayList<Rectangle> s){
        ArrayList<Rectangle> outList = new ArrayList<Rectangle>();
        BigRectangleFilter dove = new BigRectangleFilter();
        int v = s.size();
        for(int x=0;x<v;x++){
            if(dove.accept(s.get(x))==true){
                outList.add(s.get(x));
            }
        }
        return outList;
    }
}
