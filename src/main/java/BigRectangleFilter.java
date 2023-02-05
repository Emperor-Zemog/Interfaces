import java.awt.*;

public class BigRectangleFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        boolean outcome=false;
        Rectangle input;
        if (x.getClass().equals(Rectangle.class)){
            input = (Rectangle) x;
            if((2*(input.getHeight()+input.getWidth()))>10){
                outcome = true;
            }
        }

        return outcome;

    }
}
