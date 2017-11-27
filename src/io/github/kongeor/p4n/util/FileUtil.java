package io.github.kongeor.p4n.util;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.File;
import java.nio.file.Path;

public class FileUtil {

    public static Path virtualFileToPath(VirtualFile virtualFile) {
       return new File(virtualFile.getPath()).toPath();
    }
}
