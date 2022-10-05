package tests.practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniverstyPage;
import utilities.Driver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P04 {
    //Keşif Testi (Exploratory Testing) , test senaryolarının önceden oluşturulmadığı, testçilerin sistemi test anında kontrol ettiği bir tür yazılım testidir. Herhangi bir test senaryosuna bağlı kalmaksızın yazılımları serbestçe keşfederek buldukları bug’ları raporlamasına dayanır. Test uzmanlarının minimum planlama ve maksimum test uygulamasına katıldığı uygulamalı bir yaklaşımdır. Testin yürütülmesinden önce neyin test edileceğine dair fikirleri not edebilirler.
    //Keşif Testi (Exploratory Testing), diğer test yaklaşımlarında kolayca kapsanmayan hataları ve eksiklikleri keşfetmeye, ortaya çıkarmaya dayanır. Özellikle yazılım test döngüsünün başlarında sıkça başvurulan bir test türüdür. Test uzmanı açısından ise istediği şekilde son kullanıcı senaryoları oluşturma imkanı olduğu için eğlencelidir.

    @Test
    public void test01() throws InterruptedException {
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        //testng ye gecmeseydik fşndElement diyecektik ve locate alacaktık
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");
// Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        WebUniverstyPage webUniverstyPage = new WebUniverstyPage();

        List<String> workList = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka", "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));
        //workList.forEach(t->webUniversityPage.addNewTodo.sendKeys(t, Keys.ENTER));
        Actions actions = new Actions(Driver.getDriver());
        for (String w : workList
        ) {
            actions.click(webUniverstyPage.addNewTodo).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }
//Tüm yapılacakların üzerini çiz.
        List<WebElement> todos = webUniverstyPage.todos;
        for (WebElement w : todos
        ) {
            w.click();
        }
//Tüm yapılacakları sil.
        List<WebElement> deleteTodos = webUniverstyPage.deleteTodos;
        for (WebElement w : deleteTodos
        ) {
            w.click();
        }
        //2.yol  webUniverstyPage.deleteTodos.forEach(t->t.click());

Thread.
        sleep(2000);
//Tüm yapılacakların silindiğini doğrulayın.
        List<WebElement> newtodos = webUniverstyPage.newtodosWebelement;
        Assert.assertEquals(0,newtodos.size());
    }
}