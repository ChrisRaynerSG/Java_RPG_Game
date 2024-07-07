import dbm.ItemValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemsTests {

    @Test
    @DisplayName("Given item name that doesn't exist then -1 should be returned")
    void givenItemNameDoesntExistNegativeOneReturned(){
        int expected = -1;
        String input = "Blobby goop";
        int actual = ItemValues.getItemId(input);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Given item name of Dagger then item ID of 9 should be returned")
    void givenItemNameDaggerThen9ShouldReturn(){
        int expected = 16;
        String input = "dagger";
        int actual = ItemValues.getItemId(input);
        Assertions.assertEquals(expected,actual);
    }

}
