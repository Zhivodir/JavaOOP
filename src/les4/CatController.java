package les4;

/**
 * Created by User on 20.10.2016.
 */
public class CatController {
    private CatDAO catDAO;

    public CatController(CatDAO catDAO) {
        super();
        this.catDAO = catDAO;
    }

    public CatController(){
        super();
    }

    public CatDAO getCatDAO() {
        return catDAO;
    }

    public void setCatDAO(CatDAO catDAO) {
        this.catDAO = catDAO;
    }

    public Cat loadCat(){
        return catDAO.loadCat();
    }

    public void saveCat(Cat cat){
        catDAO.saveCat(cat);
    }
}
