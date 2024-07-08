import fileReading.FileAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileAccessObjectTest {

    @Test
    public void testFileAccessObjectReturnsValues() {
        List<String> output = FileAccessObject.getItemsAsStrings();

        Assertions.assertNotEquals(0,output.size());
    }
}
