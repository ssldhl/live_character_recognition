import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sushil
 */
public class start{
        static void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = {"Components", "Camera", "Defaults","GUI"};
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(520,340,200,40);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("Loading "+comps[(frame/25)%4]+"...",520, 350);
    }
    public start() {
        final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }
        for(int i=0; i<100; i++) {
            renderSplashFrame(g, i);
            splash.update();
            try {
                Thread.sleep(90);
            }
            catch(InterruptedException ert) {
                javax.swing.JOptionPane.showMessageDialog(null, ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        splash.close();
        Lcr lcr = new Lcr();
        lcr.setVisible(true);
        lcr.first();
    }
    
    private static WindowListener closeWindow = new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e){
            e.getWindow().dispose();
        }
    };
    
    public static void main (String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lcr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new start();
            }
        });
    }
}
