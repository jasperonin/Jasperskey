package MainPackage;

class ServerThread extends Thread
{
    public void run()
    {
        Server s = new Server();
    }
}



public class Firewall {

    public static void main(String[] args) {
       
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /*
//         * If Nimbus (introduced in Java SE 6) is not available, stay with the
//         * default look and feel. For details see
//         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ServerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ServerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ServerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ServerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        ServerThread s = new ServerThread();
//        ClientThread1 c1 = new ClientThread1();
//        ClientThread2 c2 = new ClientThread2();
        
        //s.setPriority(Thread.MAX_PRIORITY);
        //c1.setPriority(Thread.NORM_PRIORITY);
        //c2.setPriority(Thread.MIN_PRIORITY);
        new ServerThread().start();
   
        
       
//        s.start();
//        c1.start();
//        c2.start();
    }
}
    

