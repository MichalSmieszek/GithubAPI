import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComparingDates {
    //checking if we have got a good pattern, there are 8 tests to check it.
    Date date1,date2,date3,date4;
    @Before
    public void checkSeveralDates()throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
         date1 = sdf.parse("2010-01-01T1:0:0Z");
         date2 = sdf.parse("2010-01-02T1:0:0Z");
         date3 = sdf.parse("2010-01-01T1:0:1Z");
         date4 = sdf.parse("2011-01-01T1:0:0Z");
    }
   @Test
    public void testDate1(){
       Assert.assertTrue(date2.after(date1));
   }
    @Test
    public void testDate2(){
        Assert.assertTrue(date3.after(date1));
    }
    @Test
    public void testDate3(){
        Assert.assertTrue(date4.after(date1));
    }
    @Test
    public void testDate4(){
        Assert.assertTrue(date4.after(date2));
    }
    @Test
    public void testDate5(){
        Assert.assertTrue(date4.after(date3));
    }
    @Test
    public void testDate6(){
        Assert.assertTrue(date3.before(date2));
    }
    // Now i want to check if in the pattern I have good hours and minutes
    @Test
    public void getHour(){
        Assert.assertEquals(1, date2.getHours());
    }
    @Test
    public void getMinute(){
        Assert.assertEquals(0, date2.getMinutes());
    }
    @Test
    public void getSeconds(){
        Assert.assertEquals(0, date2.getSeconds());
    }
    //I believe, that the pattern is ok :)
}
