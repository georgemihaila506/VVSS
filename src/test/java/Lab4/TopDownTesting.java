package Lab4;

import note.controller.NoteController;
import note.model.Corigent;
import note.model.Elev;
import note.model.Medie;
import note.model.Nota;
import note.repository.ClasaRepositoryMock;
import note.repository.EleviRepositoryMock;
import note.repository.NoteRepositoryMock;
import note.utils.ClasaException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TopDownTesting {
    private NoteRepositoryMock repositoryNote;
    private ClasaRepositoryMock repository;
    private EleviRepositoryMock repositoryElevi;
    List<Elev> elevi = new ArrayList<Elev>();
    List<Nota> note = new ArrayList<Nota>();

    @Before
    public void init() throws ClasaException {
        repositoryNote = new NoteRepositoryMock();
        repositoryElevi = new EleviRepositoryMock();
        repository = new ClasaRepositoryMock();

        repositoryElevi.addElev(new Elev(1, "Ana"));
        repositoryElevi.addElev(new Elev(2, "Mihai"));
        repositoryElevi.addElev(new Elev(3, "Marius"));

        repositoryNote.addNota(new Nota(1, "Romana", 8));
        repositoryNote.addNota(new Nota(2, "Romana", 9));
        repositoryNote.addNota(new Nota(3, "Romana", 7));
        repositoryNote.addNota(new Nota(2, "Matematica", 10));
        repositoryNote.addNota(new Nota(3, "Matematica", 4));
        repositoryNote.addNota(new Nota(3, "Informatica", 10));

        repository.creazaClasa(repositoryElevi.getElevi(), repositoryNote.getNote());

        elevi = new ArrayList<Elev>(repositoryElevi.getElevi());
        note = new ArrayList<Nota>(repositoryNote.getNote());
    }

    @Test
    public void unitTestA() throws ClasaException {
        int currentSize = repositoryNote.getNote().size();
        Nota n = new Nota(1, "Matematica", 9);
        repositoryNote.addNota(n);
        assertEquals(repositoryNote.getNote().size(), currentSize+1);
    }

    @Test
    public void unitTestB() throws ClasaException {
        Medie medie = repository.medieElev(elevi.get(0));
        assertEquals(medie.getMedie(), 8, 0);
    }

    @Test
    public void unitTestC() throws ClasaException {
        List<Corigent> corigents = repository.getCorigenti();
        assertEquals(corigents.size(), 1);
    }

    @Test
    public void integrarePA() throws ClasaException {
        // P -> A
        NoteController controller = new NoteController(repositoryNote, repository, repositoryElevi);

        int nrNote = controller.getNote().size();

        controller.addNota(new Nota(1, "materie1", 10));
        controller.addNota(new Nota(2, "materie1", 7));

        assertEquals(controller.getNote().size(), nrNote + 2);
        assertEquals(controller.getNote().get(nrNote+1).getNota(), 7, 0);
    }

    @Test
    public void integrarePAB() throws ClasaException {
        // P -> A -> B
        NoteController controller = new NoteController(repositoryNote, repository, repositoryElevi);

        int nrNote = controller.getNote().size();

        controller.addNota(new Nota(1, "materie1", 10));
        controller.addNota(new Nota(2, "materie1", 7));

        assertEquals(controller.getNote().size(), nrNote + 2);
        assertEquals(controller.getNote().get(nrNote+1).getNota(), 7, 0);

        List<Medie> medii = controller.calculeazaMedii();
        assertEquals(medii.size(), 3);

        Medie medie1 = repository.medieElev(elevi.get(0));
        assertEquals(medie1.getMedie(), 8, 0);
    }

    @Test
    public void integrarePABC() throws ClasaException {
        // P -> A -> B -> C
        NoteController controller = new NoteController(repositoryNote, repository, repositoryElevi);

        int nrNote = controller.getNote().size();

        controller.addNota(new Nota(1, "Materie1", 10));
        controller.addNota(new Nota(2, "Materie1", 7));

        assertEquals(controller.getNote().size(), nrNote + 2);
        assertEquals(controller.getNote().get(nrNote+1).getNota(), 7, 0);

        List<Medie> medii = controller.calculeazaMedii();
        assertEquals(medii.size(), 3);

        Medie medie1 = repository.medieElev(elevi.get(0));
        assertEquals(medie1.getMedie(), 8, 0);

        List<Corigent> corigents = repository.getCorigenti();
        assertEquals(corigents.size(), 1);
    }
}
