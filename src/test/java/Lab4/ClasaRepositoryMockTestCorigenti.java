package Lab4;

import note.model.Corigent;
import note.model.Elev;
import note.model.Nota;
import note.repository.ClasaRepositoryMock;
import note.utils.ClasaException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClasaRepositoryMockTestCorigenti {

    private ClasaRepositoryMock repository;
    List<Elev> elevi = new ArrayList<Elev>();
    List<Nota> note = new ArrayList<Nota>();

    @Before
    public void setUp() throws Exception {
        repository = new ClasaRepositoryMock();

        elevi.add(new Elev(1, "Ana"));
        elevi.add(new Elev(2, "Mihai"));
        elevi.add(new Elev(3, "Marius"));
        elevi.add(new Elev(4, "Ioana"));

        note.add(new Nota(1, "Romana", 8));
        note.add(new Nota(2, "Romana", 10));
        note.add(new Nota(3, "Romana", 4));
        note.add(new Nota(4, "Romana", 4));
        note.add(new Nota(1, "Matematica", 4));
        note.add(new Nota(2, "Matematica", 10));
        note.add(new Nota(3, "Matematica", 3));
        note.add(new Nota(4, "Matematica", 7));

        repository.creazaClasa(elevi, note);
    }

    @Test
    public void getCorigenti() throws ClasaException {
        List<Corigent> corigents = repository.getCorigenti();
        assertEquals(corigents.size(), 3);
    }

    @Test(expected = ClasaException.class)
    public void testEmptyClass() throws ClasaException{
        repository = new ClasaRepositoryMock();
        List<Corigent> corigents = repository.getCorigenti();
    }
}