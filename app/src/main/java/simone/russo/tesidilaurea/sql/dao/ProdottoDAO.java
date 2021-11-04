package simone.russo.tesidilaurea.sql.dao;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

import simone.russo.tesidilaurea.business.ProdottoBusiness;
import simone.russo.tesidilaurea.model.ProdottoModel;

public class ProdottoDAO {
    private static ProdottoDAO ourInstance = new ProdottoDAO();

    public static ProdottoDAO getInstance() {
        return ourInstance;
    }

    public ArrayList<ProdottoModel> trovaTuttiIProdotti() {
        return null;
    }
}
