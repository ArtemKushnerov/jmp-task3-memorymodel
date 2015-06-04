import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The class that intended to load other classes from specified directory into the memory.
 *
 * @author Artsiom Kushniarou
 * @since May 13, 2015
 */
public class DiskClassLoader extends ClassLoader {

    final static Logger logger = Logger.getLogger(DiskClassLoader.class);

    /**
     * Path to the file on the disk.
     */
    private String path2Class = "d:\\Semaphore.class";


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Path path = Paths.get(path2Class);
        byte[] classData = null;
        try {
            classData = Files.readAllBytes(path);
        } catch (IOException e) {
            logger.error("Error: " + e);
        }
        Class<?> aClass = defineClass(name, classData, 0, classData.length);
        return aClass;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (!name.contains("SomeClass")) {
            return super.loadClass(name);
        }
        Class c = findClass(name);
        resolveClass(c);
        return c;
    }
}
