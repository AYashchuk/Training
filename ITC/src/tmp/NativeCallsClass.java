package tmp;

public class NativeCallsClass
{
    static
    {
        System.loadLibrary("megalib");
    }

    native public static void printOne();
    native public static void printTwo();
}

