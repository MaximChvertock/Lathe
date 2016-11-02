package by.chvertock.lathe.util;

public final class StringUtils {

    private StringUtils(){
    }

    public static boolean isBlank(String string){
        if(string == null){
            return true;
        }

        string.trim();

        return string.isEmpty();
    }
}
