package org.backend.gdc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImportExportEnum {

    IMPORT("import"),EXPORT("export");

    private String value;
}
