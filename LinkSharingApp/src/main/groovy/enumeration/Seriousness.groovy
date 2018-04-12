package enumeration

enum Seriousness {
    SERIOUS("Serious")
    ,VERY_SERIOUS("Very Serious")
    ,CASUAL("casual")

    private final String displayName

    String getDisplayName() {
        return displayName
    }

    Seriousness(String displayName) {
        this.displayName = displayName
    }

    static Seriousness isSeriousness(String s){
        if (s.equalsIgnoreCase("SERIOUS")){
            return Seriousness.SERIOUS
        }
        else if (s.equalsIgnoreCase("VERY_SERIOUS")){
            return Seriousness.VERY_SERIOUS
        }
        else if (s.equalsIgnoreCase("CASUAL")){
            return Seriousness.CASUAL
        }
        else {
            throw new Exception("String is not of any seriousness")
        }
    }
}