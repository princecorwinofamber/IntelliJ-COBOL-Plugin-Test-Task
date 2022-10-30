// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CobolFileType extends LanguageFileType {

    public static final CobolFileType INSTANCE = new CobolFileType();

    private CobolFileType() {
        super(CobolLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Cobol File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Cobol language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "cob";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return CobolIcons.FILE;
    }

}