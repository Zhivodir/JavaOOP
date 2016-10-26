package les5.hw5.task1;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by User on 26.10.2016.
 */
public class FilterForDocFile implements FileFilter {
    private String doc = "docx";

    @Override
    public boolean accept(File pathname) {
        int pointerIndex = pathname.getName().lastIndexOf(".");
        if (pointerIndex == -1) {
            return false;
        }
        String ext = pathname.getName().substring(pointerIndex + 1).toLowerCase();
        return doc.equals(ext);
    }
}
