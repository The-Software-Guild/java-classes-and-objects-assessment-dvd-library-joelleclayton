package com.dvdlibrary.ui;

import com.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author joelleclayton
 */

public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1 - List All Dvds");
        io.print("2 - Add New Dvd");
        io.print("3 - View a Dvd");
        io.print("4 - Remove a Dvd");
        io.print("5 - Edit a Dvd");
        io.print("6 - Exit");

        return io.readInt("Please select from the menu", 1, 6);
    }

    public int printEditMenuAndGetSelection() {

        io.print("Edit Menu");
        io.print("1 - Edit Release Date");
        io.print("2 - Edit MPAA Rating");
        io.print("3 - Edit Director Name");
        io.print("4 - Edit User Rating");
        io.print("5 - Edit Studio Name");
        io.print("6 - Exit");

        return io.readInt("Please select from the menu", 1, 6);
    }

    /*
     This method prompts the user for dvd ID, First Name, Last Name, and Cohort,
    gathers this information, creates a new dvd object, and returns it to the caller.
     */
    public Dvd getNewDvdInfo() {

        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter release date");
        String mpaaRating = io.readString("Please enter MPAA rating");
        String directorName = io.readString("Please enter director's name");
        String userRating = io.readString("Please enter user rating");
        String studioName = io.readString("Please enter studio name");
        Dvd newDvd = new Dvd(title);
        newDvd.setReleaseDate(releaseDate);
        newDvd.setMPAA(mpaaRating);
        newDvd.setDirectorsName(directorName);
        newDvd.setUserRating(userRating);
        newDvd.setStudio(studioName);
        return newDvd;
    }


    /*
    This method simply displays a banner or heading to the UI indicating that
    the next interactions on the screen will be for creating a new dvd
     */
    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }


    /*
    The second method displays a message that the new dvd was successfully created
    and waits for the user to hit Enter to continue
     */
    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created! Please hit enter to continue.");
    }


     /*
    A method that takes a list of DVD objects as a parameter and displays the information for each Dvd to the screen.
     */
    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format("TITLE: %s || RELEASE DATE: %s || MPAA RATING: %s || " +
                            "DIRECTOR NAME: %s || USER RATING: %s || STUDIO NAME: %s",
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMPAA(),
                    currentDvd.getDirectorsName(),
                    currentDvd.getUserRating(),
                    currentDvd.getStudio());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }


    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD Info ===");
    }


   /*
    Get the dvd title to display information
     */
    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }


    /*
    Displays the dvd information
     */
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("TITLE: " + dvd.getTitle());
            io.print("RELEASE DATE: " + dvd.getReleaseDate());
            io.print("MPAA RATING: " + dvd.getMPAA());
            io.print("DIRECTOR: " + dvd.getDirectorsName());
            io.print("USER RATING: " + dvd.getUserRating());
            io.print("STUDIO: " + dvd.getStudio());
        } else {
            io.print("That DVD wasn't found in the library!");
        }
        io.readString("Please hit enter to continue.");
    }


    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }


    public void displayRemoveResult(Dvd dvdRecord){
        if(dvdRecord != null) {
            io.print("DVD successfully removed!");
        } else {
            io.print("That DVD wasn't found in the library!");
        } io.readString("Please hit enter to continue.");
    }


    public void displayExitBanner() {
        io.print("Goodbye!!!");
    }


    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }


    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditDvdSuccess() {
        io.readString("DVD successfully Edited!  Please hit enter to continue");
    }

    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }

    public void displayEditMPAABanner() {
        io.print("=== Edit DVD MPAA rating ===");
    }

    public void displayEditDirectorNameBanner() {
        io.print("=== Edit DVD Director's Name ===");
    }

    public void displayEditStudio() {
        io.print("=== Edit DVD Studio ===");
    }

    public void displayEditUserRating() {
        io.print("=== Edit DVD User Rating ===");
    }

    public String getNewReleaseDate() {
        return io.readString("Please enter new release date.");
    }

    public String getNewMPAARating() {
        return io.readString("Please enter new MPAA rating.");
    }

    public String getNewDirectorName() {
        return io.readString("Please enter new director's name.");
    }

    public String getNewUserRating() {
        return io.readString("Please enter new user rating.");
    }

    public String getNewStudio() {
        return io.readString("Please enter new studio.");
    }

    public void displayNullDVD() {
        io.print("That DVD wasn't found in the library!");
        io.readString("Please hit enter to continue.");
    }




}
