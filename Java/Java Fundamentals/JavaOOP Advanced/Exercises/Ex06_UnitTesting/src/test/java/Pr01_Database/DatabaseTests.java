package Pr01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private static final Integer[] INITIAL_NUMS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    private static final Integer[] INVALID_INITIAL_NUMS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    private Database database;
    @Before
    public void crateDatabase() throws OperationNotSupportedException {
        this.database = new Database(INITIAL_NUMS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testInitializingDatabaseWithInvalidNums() throws OperationNotSupportedException {
        Database databse = new Database(INVALID_INITIAL_NUMS);
    }

    @Test
    public void testInitializingDatabaseWithValidNums(){
        Assert.assertEquals("Length must be 16",16, this.database.getLength());
    }

    @Test(expected = IllegalStateException.class)
    public void addNullElement(){
        database.add(null);
    }

    @Test
    public void addValidElement(){
        this.database.fetch()[0] = null;
        Integer addedInt = this.database.add(7);
       Assert.assertEquals((int)7L, (int)addedInt);
    }
}
