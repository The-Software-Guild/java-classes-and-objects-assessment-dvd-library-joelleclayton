package com.dvdlibrary;

import com.dvdlibrary.controller.DvdLibraryController;
import com.dvdlibrary.dao.DvdLibraryFileDao;
import com.dvdlibrary.dao.DvdLibraryDao;
import com.dvdlibrary.ui.DvdLibraryView;
import com.dvdlibrary.ui.UserIO;
import com.dvdlibrary.ui.UserIOConsole;
/**
 *
 * @author joelleclayton
 */

public class App {

    public static void main(String[] args) {
        /*
        Instantiate the UserIO, DvdLibraryView,dvdLibraryDao,  DvdLibraryController class and call the run method
         */
        UserIO myIO = new UserIOConsole();
        DvdLibraryView myView = new DvdLibraryView(myIO);
        DvdLibraryDao myDao = new DvdLibraryFileDao();
        DvdLibraryController controller = new DvdLibraryController(myView, myDao);
        controller.run();
    }
}
