package com.bingoastradirectwebservice.model.astradirectmodels;

public enum FamilyRelationship {

    KIND("Kind, Adoptiv- oder Pflegekind", true),
    PARTNER_KIND("Kind, Adoptiv- oder Pflegekind des Ehegatten oder Lebenspartner", false),
    ENKELKIND("Enkelkind", true),
    EHEGATTE("Ehegatte bzw. Lebenspartner", true),
    PARTNER_GEMEINSCHAFT("Partner einer eheähnlichen oder lebenspartnerschaftsähnlichen Gemeinschaft", false),
    VERLOBTE("Verlobte", false),
    ELTERN("Eltern (Mutter/Vater)", true),
    GROSS_ELTERN("Großeltern (Großmutter/Großvater)", true),
    SCHWIEGER_ELTERN("Schwiegereltern (Schwiegermutter/Schwiegervater)", true),
    STIEF_ELTERN("Stiefeltern (Stiefmutter/Stiefvater)", true),
    PFLEGE_ELTERN("Pflegeeltern (Pflegemutter/Pflegevater)", true),
    SCHWIEGERKIND("Schwiegerkind (Schwiegertochter/Schwiegersohn)", true),
    GESCHWISTER("Geschwister (Schwester/Bruder)", true),
    NICHTE_NEFFE("Kinder der Geschwister (Nichte/Neffe)", true),
    SCHWAGERIN_BRUDER_EHEGATTE("Ehegatten oder Lebenspartner der Geschwister (Schwägerin/Schwager)", false),
    SCHWAGERIN_BRUDER_PARTNER("Geschwister der Ehegatten oder Lebenspartner (Schwägerin/Schwager)", false),
    TANTE_ONKEL("Geschwister der Eltern (Tante/Onkel)", true),
    NONE("Keiner der vorherig genannten Angehörigen", false);

    private final String displayName;
    private final boolean isCloseFamily;

    FamilyRelationship(String displayName, boolean isCloseFamily) {
        this.displayName = displayName;
        this.isCloseFamily = isCloseFamily;
    }

    public boolean isCloseFamily() {
        return isCloseFamily;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static FamilyRelationship fromDisplayName(String text) {
        for (FamilyRelationship fr : values()) {
            if (fr.displayName.equalsIgnoreCase(text)) {
                return fr;
            }
        }
        return null;
    }
}
