package io.github.kongeor.p4n;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import io.github.kongeor.p4n.util.P4;
import io.github.kongeor.p4n.util.PerforceUtil;

public class RevertFile extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        VirtualFile virtualFile = event.getDataContext().getData(PlatformDataKeys.VIRTUAL_FILE);
        int response = Messages.showOkCancelDialog("Are you sure you want to revert changes?", "Revert File", Messages.getInformationIcon());
        if (Messages.OK == response) {
            PerforceUtil.executeCommand(virtualFile, P4.revert);
        }
    }
}
