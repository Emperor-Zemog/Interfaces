import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;
public class ShortWordFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        boolean outcome=false;
        String input;
        if (x.getClass().equals(String.class)){
            input = (String) x;
            if(input.length()<5){
                outcome = true;
            }
        }

        return outcome;
    }
}
