import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * The main entrance to the program.
 *
 * @author Artsiom Kushniarou
 * @since May 13, 2015
 */
public class LoadClass {


    private static String className = "Semaphore";

    private List<Class<?>> classList = new ArrayList<Class<?>>();


    /**
     * Invokes the specified method on the class instance loaded from the disk.
     *
     * @param args command line arguments, should contain path to the file
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        final LoadClass OOMIntroducer = new LoadClass();
        do {
            OOMIntroducer.introduceOOM();
        } while (true);
    }

    private void introduceOOM() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = new DiskClassLoader();
        Class<?> clazz = classLoader.loadClass(className);
        classList.add(clazz);
        System.out.println("Loaded");
    }
}
