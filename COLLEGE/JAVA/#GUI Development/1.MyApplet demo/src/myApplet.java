import java.applet.*;
import java.awt.*; // abstract windows toolkit

public class myApplet extends Applet{

    // 5 Life cycle in applet(paint is mandatory to use,rest 4 are optional)
    String msg = "Applet demo";
    public void init() // called on running program.
    {
        setBackground(Color.pink);
        setForeground(Color.RED);
    }

    public void start() {
        msg = msg+" in java";
    }

    public void paint(Graphics g){  // paint used to design window
        g.drawString(msg,50,100);
        g.drawLine(50, 110, 150, 110);
        g.drawRect(50, 180, 100, 60);
        g.fillRect(50, 190, 100, 60);
    }

    public void stop(){


    }

    public void destroy(){

    }
}