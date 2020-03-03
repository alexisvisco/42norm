package fr.ft.aviscogl.event;

import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import fr.ft.aviscogl.norm.NormExecutor;
import fr.ft.aviscogl.norm.NormType;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Inspection extends LocalInspectionTool
{

    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    @Override
    public String getDisplayName()
    {
        return "Norminette";
    }

    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    @Override
    public String getGroupDisplayName()
    {
        return "Norminette";
    }

    @Override
    public boolean runForWholeFile()
    {
        return true;
    }

    @Nullable
    @Override
    public ProblemDescriptor[] checkFile(@NotNull PsiFile file, @NotNull InspectionManager manager, boolean isOnTheFly)
    {
        VirtualFile virtualFile = file.getVirtualFile();
        if (virtualFile == null || virtualFile.isDirectory() || !virtualFile.isValid())
            return super.checkFile(file, manager, isOnTheFly);

        List<ProblemDescriptor> problems = new ArrayList<>();
        Document document = FileDocumentManager.getInstance().getDocument(virtualFile);
        if (document != null) {
            NormExecutor.execute(virtualFile.getPath()).forEach(result -> {
                try {
                    problems.add(manager.createProblemDescriptor(
                            file,
                            getRange(result.getLine(), result.getOffset(), document),
                            result.getType().toString() + ": " + result.getMessage(),
                            result.getType().equals(NormType.ERROR)
                                    ? ProblemHighlightType.ERROR
                                    : ProblemHighlightType.WARNING,
                            isOnTheFly
                    ));
                } catch (Exception ignore) {}
            });
        }

        return problems.toArray(new ProblemDescriptor[0]);
    }

    private TextRange getRange(int line, int offset, Document vf)
    {
        int lineOffset = vf.getLineStartOffset(line-1);
        return new TextRange(lineOffset, offset == -1 ? vf.getLineEndOffset(line-1) : lineOffset + offset);
    }
}
