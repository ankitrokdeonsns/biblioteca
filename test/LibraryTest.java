import com.twu28.biblioteca.Library;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: ankitro
 * Date: 7/12/12
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryTest
{
    @Test (expected = RuntimeException.class)
    public void canPersonReserveBookByBookNameIfBookNameIsNull()
    {
        Library library = new Library();
        library.reserveBookByBookName(null);
    }

    @Test
    public void canPersonReserveBookByBookNameIfBookNameIsNotString()
    {
        Library library = new Library();
        Assert.assertFalse(library.reserveBookByBookName(15));
    }

    @Test
    public void canPersonReserveBookByBookNameIfBookListIsEmpty()
    {
        Library library = new Library();
        Assert.assertFalse(library.reserveBookByBookName("head first java"));
    }

    @Test
    public void canPersonReserveBookByBookNameIfBookListIsNotEmptyAndBookDoesNotExist()
    {
        Library library = new Library();
        Assert.assertFalse(library.reserveBookByBookName("head first java"));
    }

    @Test
    public void canPersonReserveBookByBookNameIfBookListIsNotEmptyAndBookExists()
    {
        Library library = new Library();
        Assert.assertTrue(library.reserveBookByBookName("book3"));
    }
}
