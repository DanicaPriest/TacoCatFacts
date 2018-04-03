package mybatis.model.TacoCat;

public class TacoRoot {
    String name;
    String recipe;
    String url;
    String cat_fact;

    public String getCat_fact() {
        return cat_fact;
    }

    public void setCat_fact(String cat_fact) {
        this.cat_fact = cat_fact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
