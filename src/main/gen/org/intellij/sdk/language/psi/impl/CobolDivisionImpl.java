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

public class CobolDivisionImpl extends ASTWrapperPsiElement implements CobolDivision {

  public CobolDivisionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CobolVisitor visitor) {
    visitor.visitDivision(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CobolVisitor) accept((CobolVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CobolDataContent getDataContent() {
    return findChildByClass(CobolDataContent.class);
  }

  @Override
  @Nullable
  public CobolIdentificationContent getIdentificationContent() {
    return findChildByClass(CobolIdentificationContent.class);
  }

  @Override
  @Nullable
  public CobolProcedureContent getProcedureContent() {
    return findChildByClass(CobolProcedureContent.class);
  }

}
