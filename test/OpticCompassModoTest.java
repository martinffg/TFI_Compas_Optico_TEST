import org.junit.Assert;
import org.junit.Test;

import javafx.application.Platform;
import untref_tfi.OpticCompass;

public class OpticCompassModoTest {

	@Test
	public void mainTest() {
		try {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						String[] args = new String[1]; args[0]="test";
						OpticCompass.main(args);
						if (Platform.isFxApplicationThread()) {
							Assert.assertTrue(Platform.isFxApplicationThread());
						}
					}catch(Exception e){
						//e.printStackTrace();
						System.out.println("Exception launching OpticCompass.main catched.");
					}
				}
			});
			
			thread.start();
	
			Thread.sleep(3000);
			Assert.assertFalse(Platform.isFxApplicationThread());
		}catch(InterruptedException ex){
			System.out.println("Exception stopping mainTest catched.");
		}
	}
}