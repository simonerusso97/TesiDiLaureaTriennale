package simone.russo.tesidilaurea.business;

import android.database.Cursor;

import java.util.ArrayList;

import simone.russo.tesidilaurea.dao.ProdottoDAO;
import simone.russo.tesidilaurea.model.ProdottoModel;

public class ProdottoBusiness {

    private static ProdottoBusiness ourInstance = new ProdottoBusiness();

    public static ProdottoBusiness getInstance() {
        return ourInstance;
    }

    public ArrayList<ProdottoModel> trovaTuttiIProdotti() {
        return ProdottoDAO.getInstance().trovaTuttiIProdotti();
    }
}
