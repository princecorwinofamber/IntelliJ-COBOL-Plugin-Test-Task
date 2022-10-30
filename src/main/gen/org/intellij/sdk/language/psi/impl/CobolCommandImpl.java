// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.CobolTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;

public class CobolCommandImpl extends ASTWrapperPsiElement implements CobolCommand {

  public CobolCommandImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CobolVisitor visitor) {
    visitor.visitCommand(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CobolVisitor) accept((CobolVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CobolDisplay getDisplay() {
    return findChildByClass(CobolDisplay.class);
  }

  @Override
  @Nullable
  public CobolPerform getPerform() {
    return findChildByClass(CobolPerform.class);
  }

  @Override
  @Nullable
  public CobolStop getStop() {
    return findChildByClass(CobolStop.class);
  }

}
