package simone.russo.tesidilaurea.sql.dbinterface;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final int DATABASE_VERSION = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query= "CREATE TABLE IF NOT EXISTS `Ordine_has_prodotto` (`idOrdine`	INTEGER, `idProdotto` INTEGER, `quantita` INTEGER NOT NULL, PRIMARY KEY(`idOrdine`,`idProdotto`))";
        db.execSQL(query);

        query= "CREATE TABLE IF NOT EXISTS `Carrello` (`idUtente` INTEGER, `idProdotto` INTEGER, `quantita` INTEGER NOT NULL, PRIMARY KEY(`idUtente`,`idProdotto`))";
        db.execSQL(query);

        query= "CREATE TABLE IF NOT EXISTS `Ordine` (`idOrdine`	INTEGER PRIMARY KEY AUTOINCREMENT,`idUtente` INTEGER NOT NULL, `data` TEXT NOT NULL, `stato` INTEGER NOT NULL, `pagamento` INTEGER NOT NULL, `nominativo` TEXT NOT NULL, `email` TEXT NOT NULL, `provincia`	TEXT NOT NULL, `citta` TEXT NOT NULL, `indirizzo` TEXT NOT NULL)";
        db.execSQL(query);

        query = "CREATE TABLE IF NOT EXISTS `Cliente` ( `idCliente_utente` INTEGER, `verificato` INTEGER DEFAULT 0, `intestatarioCarta` TEXT NOT NULL, `numeroCarta` TEXT NOT NULL, `dataScadenza` TEXT NOT NULL, PRIMARY KEY(`idCliente_utente`))";
        db.execSQL(query);

        query= "CREATE TABLE IF NOT EXISTS `Gestore` ( `idGestore_utente` INTEGER, PRIMARY KEY(`idGestore_utente`))";
        db.execSQL(query);

        query="CREATE TABLE IF NOT EXISTS `Admin` ( `idAmministratore_utente` INTEGER, PRIMARY KEY(`idAmministratore_utente`))";
        db.execSQL(query);

        query= "CREATE TABLE IF NOT EXISTS `Prodotto` (`idProdotto`	INTEGER PRIMARY KEY AUTOINCREMENT, `Nome` TEXT NOT NULL, `Descrizione` TEXT NOT NULL, `Prezzo` REAL NOT NULL, `Disponibile`	INTEGER NOT NULL DEFAULT 0)";
        db.execSQL(query);

        query= "CREATE TABLE IF NOT EXISTS `Utente` (`idUtente`	INTEGER PRIMARY KEY AUTOINCREMENT, `nome` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, `telefono` TEXT NOT NULL, `provincia` TEXT NOT NULL, `citta` TEXT NOT NULL, `indirizzo` TEXT NOT NULL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}