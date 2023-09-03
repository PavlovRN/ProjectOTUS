package data;

public enum EventsSortingData {

    OPEN_WEBINAR("Открытый вебинар", "Открытый вебинар");

    private String nameFilter;
    private String namePage;

    EventsSortingData(String nameFilter, String namePage ) {
        this.nameFilter = nameFilter;
        this.namePage = namePage;
    }

    public String getNameFilter() {
        return nameFilter;
    }

    public String getNamePage() {
        return namePage;
    }
}