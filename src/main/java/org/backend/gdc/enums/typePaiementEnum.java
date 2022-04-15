package org.backend.gdc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum typePaiementEnum {

    COMPTANT(1), CREDIT(0);

    private int value;
}
