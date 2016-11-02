package by.chvertock.lathe.util;

import java.util.Arrays;

public final class IOUtils {

    public static boolean isImageExtension(String ext){
        if(ext == null || StringUtils.isBlank(ext)){
            return false;
        }

        final String[] EXT = {"jpg", "jpeg", "gif", "png", "tga", "bmp"};

        return Arrays.asList(EXT).contains(ext);
    }
}
