package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

  @Test
  void kdyMaSvatek() {
    Svatky svatky = new Svatky();
    assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
    assertNull(svatky.kdyMaSvatek("Eva"));
  }

  @Test
  void jeVSeznamu() {
    Svatky svatky = new Svatky();
    assertTrue(svatky.jeVSeznamu("Nataša"));
    assertFalse(svatky.jeVSeznamu("Naďa"));
    //assertTrue(svatky.jeVSeznamu("Naďa"));
    //assertFalse(svatky.jeVSeznamu("Nataša"));

    return;
  }

  @Test
  void getPocetJmen() {
    Svatky svatky = new Svatky();
    assertEquals(37, svatky.getPocetJmen() );
    return;
  }

  @Test
  void getSeznamJmen() {
    Svatky svatky = new Svatky();
    assertEquals(svatky.getPocetJmen(), svatky.getSeznamJmen().size());
    return;
  }

  @Test
  void pridatSvatekDenMesicInt() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Laura", 1, 6);
    assertTrue(svatky.jeVSeznamu("Laura"));
    assertEquals(svatky.kdyMaSvatek("Laura"), MonthDay.of(6, 1));
  }


  @Test
  void pridatSvatekDenMesicMonth() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Tamara", MonthDay.of(6, 3));
    assertTrue(svatky.jeVSeznamu("Tamara"));
    assertEquals(svatky.kdyMaSvatek("Tamara"), MonthDay.of(6, 3));
  }

  @Test
  void prridatSvatekMonthDay() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Jarmil", 2, Month.JUNE);
    assertTrue(svatky.jeVSeznamu("Jarmil"));
    assertEquals(svatky.kdyMaSvatek("Jarmil"), MonthDay.of(Month.JUNE, 2));
  }

  @Test
  void smazatSvatek() {
    Svatky svatky = new Svatky();
    int puvodniPocetSvatku = svatky.getPocetJmen();
    svatky.smazatSvatek("Alex");
    assertFalse(svatky.jeVSeznamu("Alex"));
    assertEquals(svatky.getPocetJmen(), puvodniPocetSvatku-1);
  }
}
