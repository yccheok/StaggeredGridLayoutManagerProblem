package noteplus.yocto.com.myapplication;

public class Data {
    public final int id;
    public final String title;
    public final String body;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (id != data.id) return false;
        if (title != null ? !title.equals(data.title) : data.title != null) return false;
        return body != null ? body.equals(data.body) : data.body == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    public Data(int id, String title, String body) {

        this.id = id;
        this.title = title;
        this.body = body;
    }
}
