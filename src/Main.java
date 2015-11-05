import java.awt.Toolkit;
import java.net.InetAddress;

public class Main {
	
	public static int attempts = 1;
	
	public static void main(String[] args){
		ping("127.0.0.1"); // Insert your IP or Hostname.
    }
	
	public static void ping(String ip) {
		try {
            InetAddress address = InetAddress.getByName(ip);
            boolean reachable = address.isReachable(10000);
            int index = 0;
            while(index == 0) {
            	if(reachable == true) {
            		System.out.println("Attempt " + attempts + ": Successfully connected to '" + ip + "'.");
                	Toolkit.getDefaultToolkit().beep();
                	break;
                } else if (reachable == false) {
                	System.out.println("Attempt " + attempts + ": Connection to '" + ip + "' failed.");
                	attempts++;
                }            	
            	Thread.sleep(2500);
                index++;
                ping(ip);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
	}
}
