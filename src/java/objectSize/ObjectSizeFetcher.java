/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package objectSize;

import java.lang.instrument.Instrumentation;

/**
 *
 * @author Lokesh Kotha
 */
public class ObjectSizeFetcher {

    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}
