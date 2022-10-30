// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.CobolLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CobolElementType extends IElementType {

    public CobolElementType(@NotNull @NonNls String debugName) {
        super(debugName, CobolLanguage.INSTANCE);
    }

}