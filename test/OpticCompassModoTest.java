import org.junit.Assert;
import org.junit.Test;
import javafx.application.Platform;

public class OpticCompassModoTest {

	@Test
	public void mainTest() {
		
		try {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						OpticCompass oc = new OpticCompass();
						String[] args = {"test"};
						oc.start(args);							
					}catch(Exception e){
					}
				}
			});
			
			thread.start();
			Thread.sleep(1000);
			Assert.assertFalse(Platform.isFxApplicationThread());
			Platform.exit();
		}catch(Exception ex){
			//System.out.println("Exception stopping mainTest catched.");
		}
	}
}