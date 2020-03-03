package fr.ft.aviscogl.event;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class OnKeystroke extends AnAction
{
    @Override
    public void actionPerformed(@NotNull AnActionEvent e)
    {
        // todo this keystroke enable or disable the inspection by default.
    }
}
