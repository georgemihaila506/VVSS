package Lab3;

import note.model.Elev;
import note.model.Medie;
import note.model.Nota;
import note.repository.ClasaRepositoryMock;
import note.utils.ClasaException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClasaRepositoryMockTest {

    private ClasaRepositoryMock repository;
    List<Elev> elevi = new ArrayList<Elev>();
    List<Nota> note = new ArrayList<Nota>();

    @Before
    public void setUp() {
        repository = new ClasaRepositoryMock();

        elevi.add(new Elev(1, "Ana"));
        elevi.add(new Elev(2, "Mihai"));
        elevi.add(new Elev(3, "Marius"));
        elevi.add(new Elev(4, "Maria"));

        note.add(new Nota(1, "Romana", 8));
        note.add(new Nota(2, "Romana", 9));
        note.add(new Nota(3, "Romana", 7));
        note.add(new Nota(2, "Matematica", 10));
        note.add(new Nota(3, "Matematica", 4));
        note.add(new Nota(3, "Istorie", 10));

        repository.creazaClasa(elevi, note);
    }

    @Test (expected = ClasaException.class)
    public void medieElevInexistent() throws ClasaException {
        Medie medie = repository.medieElev(new Elev(5, "Elena"));
    }

    @Test (expected = ClasaException.class)
    public void medieElevFaraNote() throws ClasaException {
        Medie medie = repository.medieElev(elevi.get(3));
    }

    @Test
    public void medieElevONota() throws ClasaException {
        Medie medie = repository.medieElev(elevi.get(0));
        assertEquals(medie.getMedie(), 8, 0);
    }

    @Test
    public void medieElevDouaNote() throws ClasaException {
        Medie medie = repository.medieElev(elevi.get(1));
        assertEquals(medie.getMedie(), 9.5, 0);
    }

    @Test
    public void medieElevTreiNote() throws ClasaException {
        Medie medie = repository.medieElev(elevi.get(2));
        assertEquals(medie.getMedie(), 7, 0);
    }
}