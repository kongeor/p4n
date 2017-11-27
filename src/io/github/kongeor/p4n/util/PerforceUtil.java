package io.github.kongeor.p4n.util;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class PerforceUtil {

    private static boolean runOsCommand(ProcessBuilder pb, P4 command) throws InterruptedException, IOException {
        Process start = null;
        Process process = pb.start();
        if (process.waitFor() == 0) {
            MessageUtil.showInfo("Executed p4 file " + command);
        } else {
            InputStream is = start.getErrorStream();
            String out = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining());
            MessageUtil.showError(out);
            is.close();
        }
        return true;
    }

    public static void executeCommand(VirtualFile virtualFile, P4 command) {
        if (virtualFile != null) {
            try {
                Path path = FileUtil.virtualFileToPath(virtualFile);
                File folder = path.getParent().toFile();
                File file = path.getFileName().toFile();
                ProcessBuilder pb = new ProcessBuilder("p4", command.name(), file.getName());
                pb.directory(folder);
                if (runOsCommand(pb, command)) {
                    virtualFile.refresh(false, false);
                }
            } catch (IOException | InterruptedException e) {
                MessageUtil.showError(e.getMessage());
            }
        } else {
            MessageUtil.showError("No file opened");
        }
    }
}
