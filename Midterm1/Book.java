public class Book {
    private String title;
    private String author;
    private float price;

    public Book (String t, String a, float p) {
        if (t == null || a == null || p < 0.0f) {
            throw new IllegalArgumentException("Invalid, the argument is not correct.");
        }
        title = t;
        author = a;
        price = p;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle () {
        this.title = title;
    }

    public String getAuthor () {
        return author;
    }

    public void setAuthor () {
        this.author = author;
    }

    public float getPrice () {
        return price;
    }

    public void setPrice () {
        this.price = price ;
    }
}