import java.util.*;
import java.time.*;

class Anotacao extends Nota {
    /*Utilizei uma implementação de Set para eviter elementos duplicados*/
    HashSet<String> tags;

    Anotacao(String title, String description, Integer id) {
        super.setTitle(title);
        super.setDescription(description);
        this.setCreationDate();
        super.setId(id);
    }


    /*Sempre usando a tag toda em caixa baixa, para que a capitalização utilizada pelo usuário seja
    * irrelevante*/

    Boolean addTag(String tag) {
        return tags.add(tag.toLowerCase());
    }

    Boolean removeTag(String tag) {
        return tags.remove(tag.toLowerCase());
    }

    Boolean hasTag(String tag) {
        return tags.contains(tag.toLowerCase());
    }

    private void setCreationDate() {
        this.creation_date = LocalDate.now();
    }


}