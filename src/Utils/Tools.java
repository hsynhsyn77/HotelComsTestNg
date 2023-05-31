package Utils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;



public class Tools {
    public static void compareToList(List<String> menuExpectedList, List<WebElement> menuList) {

        for (int i = 0; i < menuExpectedList.size(); i++) {
            Assert.assertEquals(menuExpectedList.get(i), menuList.get(i).getText(), "Karşılaştırma sorunu");

        }
    }

    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

// }

// public static double WebElementToDouble(WebElement e) {
//     String result=e.getText();
//     result=result.replaceAll("[^\\d]","");
//     return Double.parseDouble(result);
// }

// public static int RandomGenerator(int max)
// {
//     return (int)(Math.random()*max);// max 4 ise =>0 1 2 3...
// }

//

    }
    public static int generateRandomNumber(int number){
        Random random=new Random();
        int rNum=random.nextInt(number);
        return rNum;
    }

}