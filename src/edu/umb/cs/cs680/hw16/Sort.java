package edu.umb.cs.cs680.hw16;

import java.util.ArrayList;

public class Sort implements Command {

    private FileSystem f;

    public Sort(FileSystem fs) {
        f = fs;
    }

    @Override
    public void execute() {

        ArrayList<FSElement> fsys = f.sort(FileSystem.getCurrent(), new AlphabeticalComparator());
        f.print(fsys);

    }

}