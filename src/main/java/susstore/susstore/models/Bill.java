package susstore.susstore.models;

public abstract class Bill {

    protected int id;
    protected int idUser;

    public Bill(int id, int idUser) {
        this.id = id;
        this.idUser = idUser;
    }

    /* Getter & Setter */
    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public abstract Nominal getBillTotal();
}
