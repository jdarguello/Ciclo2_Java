public class App {
    public static void main(String[] args) throws Exception {
         CRUD test = new CRUD();

         //Crear tabla
         String query = "CREATE TABLE IF NOT EXISTS personas (" +
                 "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                 "nombre TEXT NOT NULL," +
                 "edad INTEGER NOT NULL" +
                 ");";
         test.SQLExec(query);
    }
}
