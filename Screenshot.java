package Erp.Automation.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import Erp.Automation.main.MainTests;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot extends MainTests {

	public void fullPageScreenshot(String fileName) throws IOException {

		AShot ashot = new AShot();
		//ru.yandex.qatools.ashot.Screenshot screenshot = ashot.takeScreenshot(driver);
		BufferedImage image = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000)).takeScreenshot(driver)
				.getImage();
		String baseDir = System.getProperty("user.dir");
		String filePath = (baseDir + "/src/test/resources/failedtestcasesscreenshot/");
		Calendar calendar = Calendar.getInstance();
		String time = calendar.getTime().toString();
		time = time.replace(" ", "_");
		time = time.replace(":", "_");
		System.out.println(time);

		File screenshotFile = new File(filePath + fileName + "_" + time + ".png");

		try {
			ImageIO.write(image, "PNG", screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
