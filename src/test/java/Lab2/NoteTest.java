import note.model.Nota;
import note.repository.NoteRepositoryMock;
import note.utils.ClasaException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoteTest {

    private NoteRepositoryMock repository;

    @Before
    public void init(){
        repository = new NoteRepositoryMock();
    }

    @Test
    public void testAddNota() throws ClasaException {
        int currentSize = repository.getNote().size();
        Nota n = new Nota(1, "Matematica", 9);
        repository.addNota(n);
        assertEquals(repository.getNote().size(), currentSize+1);
    }

    @Test
    public void testAddNota2() throws ClasaException {
        int currentSize = repository.getNote().size();
        Nota n = new Nota(75, "Matematica", 6);
        repository.addNota(n);
        assertEquals(repository.getNote().size(), currentSize+1);
    }

    @Test(expected = ClasaException.class)
    public void testAddNotaNrMatricolMic() throws ClasaException {
        Nota n = new Nota(0, "Matematica", 10);
        repository.addNota(n);
    }

    @Test (expected = ClasaException.class)
    public void testAddNotaNrMatricolMare() throws ClasaException{
        Nota n = new Nota(1001, "Matematica", 10);
        repository.addNota(n);
    }

    @Test (expected = ClasaException.class)
    public void testAddNotaNrMatricolDouble() throws ClasaException{
        Nota n = new Nota(45.7, "Matematica", 10);
        repository.addNota(n);
    }

    @Test (expected = ClasaException.class)
    public void testAddNotaNotaMica() throws ClasaException{
        Nota n = new Nota(1, "Matematica", -4);
        repository.addNota(n);
    }

    @Test (expected = ClasaException.class)
    public void testAddNotaNotaMare() throws ClasaException{
        Nota n = new Nota(1, "Matematica", 11);
        repository.addNota(n);
    }

    @Test (expected = ClasaException.class)
    public void testAddNotaNotaDouble() throws ClasaException{
        Nota n = new Nota(1, "Matematica", 3.7);
        repository.addNota(n);
    }

    @Test
    public void testAddNotaBVA3() throws ClasaException {
        int currentSize = repository.getNote().size();
        Nota n = new Nota(2, "Matematica", 7);
        repository.addNota(n);
        assertEquals(repository.getNote().size(), currentSize+1);
    }

    @Test
    public void testAddNotaBVA4() throws ClasaException {
        int currentSize = repository.getNote().size();
        Nota n = new Nota(999, "Matematica", 10);
        repository.addNota(n);
        assertEquals(repository.getNote().size(), currentSize+1);
    }

    @Test(expected = ClasaException.class)
    public void testAddNotaBVA7() throws ClasaException {
        Nota n = new Nota(1, "Matematica", 0);
        repository.addNota(n);
    }

    @Test
    public void testAddNotaBVA11() throws ClasaException {
        int currentSize = repository.getNote().size();
        Nota n = new Nota(8, "Matematica", 10);
        repository.addNota(n);
        assertEquals(repository.getNote().size(), currentSize+1);
    }
}