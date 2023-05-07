package susstore.susstore.view;

public enum PageType {
    SettingsPage("Settings Page"),
    DashBoardPage("Dashboard Page"),
    AllCustomerPage("All Customer Page"),
    RegisterNewMember("Register New Member"),
    EditCustomerPage("Edit Customer Page"),
    AllBarang("All Barang"),
    NewBarang("New Barang"),
    Kasir("Kasir");

    private final String name;

    private PageType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
