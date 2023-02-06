import java.awt.*;

public class MenuBarEx extends Frame {

    MenuBarEx(){
        MenuBar mb = new MenuBar();
        Menu m = new Menu("File");
        Menu im = new Menu("Insert");
        Menu sm= new Menu("Print");
        MenuItem i1 = new MenuItem("Open");
        MenuItem i2 = new MenuItem("Save");
        MenuItem i3 = new MenuItem("File");
        MenuItem i4 = new MenuItem("Folder");
        MenuItem i5 = new MenuItem("Table");
        MenuItem i6 = new MenuItem("Shape");

        m.add(i1);
        m.add(i2);
        sm.add(i3);
        sm.add(i4);
        im.add(i5);
        im.add(i6);

        m.add(sm);
        mb.add(m);
        mb.add(im);
        setMenuBar(mb);
        setVisible(true);
        setSize(400,400);
        setLayout(null);

    }
//    public static void main(String[] args){
//            new MenuBarEx();
//    }
}
