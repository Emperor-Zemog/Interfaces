import javax.swing.*;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortLister {
    public static void main (String[] args)  throws IOException {
        int fileIndex = 0;
        ArrayList<String> inList = new ArrayList<String>();
        ArrayList<String> outList = new ArrayList<String>();
        VMGMule eagle = new VMGMule(new Scanner(System.in));
        Boolean done = false;
        JFileChooser jChoose= new JFileChooser(new File("pom.xml"));
        FileFilter txtFilefilter = new FileFilter() {
            public boolean accept(File file) {
                if (file.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        };
        File [] files = jChoose.getCurrentDirectory().listFiles(txtFilefilter);
        while(done ==false){

            for (int i = 0; i < files.length; i++) {
                System.out.println(i+": "+ files[i].getName());
            }
            fileIndex= eagle.getIndexSelect("Please select the number corresponding to the file you want ",0,files.length-1);
            done = eagle.getUserConfirm("You selected "+files[fileIndex].getName()+ " Is this correct?");
        }
        Path fPath= Path.of(files[fileIndex].getPath());
        String contents= Files.readString(fPath);
        inList=splitSubstrings(contents);
        System.out.println("______Words In: "+files[fileIndex].getName()+" ______");
        for(int c=0; c<inList.size();c++){
            System.out.println(inList.get(c));
        }
        System.out.println("______Words In: "+files[fileIndex].getName()+" With Length Less Then 5______");
        outList=collectAll(inList);
        for(int y=0; y<outList.size();y++){
            System.out.println(outList.get(y));
        }
    }
    public static ArrayList<String> splitSubstrings(String s)
    {


        int i, j;


        int stringLength = s.length();


        ArrayList<String> subStringList = new ArrayList<String>();

        i=0;
        j=0;
        while(i<stringLength){
            if(s.charAt(i)==' '){
                subStringList.add(s.substring(j,i));
                j=i+1;
            } else if(s.charAt(i)=='\n'){
                subStringList.add(s.substring(j,i-1));
                j=i+1;

            }else if (i==stringLength-1) {
                subStringList.add(s.substring(j,i+1));
            }
            i++;
        }


        return subStringList;
    }
    public static ArrayList<String> collectAll(ArrayList<String> s){
        ArrayList<String> outList = new ArrayList<String>();
        ShortWordFilter dove = new ShortWordFilter();
        int v = s.size();
        for(int x=0;x<v;x++){
            if(dove.accept(s.get(x))==true){
                outList.add(s.get(x));
            }
        }
        return outList;
    }
}
