package com.dvdlibrary.dao;

import com.dvdlibrary.dto.Dvd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author joelleclayton
 */

public class DvdLibraryFileDao implements DvdLibraryDao {

    public final String DVD_FILE = "DvdFile.txt";
    public static final String DELIMITER = "::";

    /*
    Hash Map to store and retrieve the dvd with title name
     */
    private Map<String, Dvd> dvds = new HashMap<>();

    public DvdLibraryFileDao() {
    }

    public DvdLibraryFileDao(String libraryTextFile){
    }




    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        loadDvdFile();
        Dvd prevDvd = dvds.put(title, dvd);
        writeDvdFile();
        return prevDvd;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadDvdFile();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        loadDvdFile();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        loadDvdFile();
        Dvd removedDvd = dvds.remove(title);
        writeDvdFile();
        return removedDvd;
    }

    //title::release date::MPAArating::DirectorName::UserRating::StudioName

    /*
    Method to unmarshall the object or read a line of string
    from the line and convert it into an object
     */
    private Dvd unmarshallDvd(String dvdAsText) {

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        Dvd dvdFromFile = new Dvd(title);

        dvdFromFile.setReleaseDate(dvdTokens[1]);

        dvdFromFile.setMPAA(dvdTokens[2]);

        dvdFromFile.setDirectorsName(dvdTokens[3]);

        dvdFromFile.setUserRating(dvdTokens[4]);

        dvdFromFile.setStudio(dvdTokens[5]);

        return dvdFromFile;
    }

    /*
    Method to Load file DVD_FILE into memory
     */
    private void loadDvdFile() throws DvdLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException("Could not load dvd data into memory", e);
        }
        String currentLine;
        Dvd currentDvd;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }


    private String marshallDvd(Dvd aDvd) {
        // title
        String dvdAsText = aDvd.getTitle() + DELIMITER;
        // release date
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        // MPAA rating
        dvdAsText += aDvd.getMPAA() + DELIMITER;
        // director's name
        dvdAsText += aDvd.getDirectorsName() + DELIMITER;
        // user rating
        dvdAsText += aDvd.getUserRating() + DELIMITER;
        // studio name
        dvdAsText += aDvd.getStudio();

        return dvdAsText;
    }


    /**
     * Writes all Dvds in the library out to a DVD_FILE. See loadDvdFile
     * for file format.
     *
     * @throws Exception if an error occurs writing to the file
     */
    private void writeDvdFile() throws DvdLibraryDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        //implement

        // Write out the DvD objects to the DVD file.
        // NOTE TO THE APPRENTICES: We could just grab the dvd map,
        // get the Collection of dvd and iterate over them but we've
        // already created a method that gets a List of dvds so
        // we'll reuse it.

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save the DVD data.", e);
        }

        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }




    @Override
    public Dvd editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException {
        loadDvdFile();
        Dvd currentDvd = dvds.get(title);
        currentDvd.setReleaseDate(newReleaseDate);
        writeDvdFile();
        return currentDvd;
    }

    @Override
    public Dvd editMPAA(String title, String newRating) throws DvdLibraryDaoException {
        loadDvdFile();
        Dvd currentDVD = dvds.get(title);
        currentDVD.setMPAA(newRating);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public Dvd editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException {
        loadDvdFile();
        Dvd currentDVD = dvds.get(title);
        currentDVD.setDirectorsName(newDirectorName);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public Dvd editUserRating(String title, String newUserRating) throws DvdLibraryDaoException {
        loadDvdFile();
        Dvd currentDVD = dvds.get(title);
        currentDVD.setUserRating(newUserRating);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public Dvd editStudio(String title, String newStudioName) throws DvdLibraryDaoException {
        loadDvdFile();
        Dvd currentDVD = dvds.get(title);
        currentDVD.setStudio(newStudioName);
        writeDvdFile();
        return currentDVD;
    }
}
