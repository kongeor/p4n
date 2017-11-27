package io.github.kongeor.p4n.util;

import com.intellij.openapi.vfs.VirtualFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public static Path virtualFileToPath(VirtualFile virtualFile) {
        String filePath = virtualFile.toString();
        return  Paths.get(filePath.replaceAll("file://", ""));
    }
}
