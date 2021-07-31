import java.time.*;

abstract class Nota {
    Integer id;
    String title;
    LocalDate creation_date;
    String description;

    void setTitle(String title) {
        this.title = title;
    }

    String getTitle() {
        return this.title;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getDescription() {
        return this.description;
    }

    LocalDate getDate() {
        return this.creation_date;
    }

    void setId(Integer id) {
        this.id = id;
    }

    Integer getId() {
        return this.id;
    }

}