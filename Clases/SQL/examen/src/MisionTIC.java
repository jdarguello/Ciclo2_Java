import java.sql.SQLException;
import java.util.Arrays;

public class MisionTIC {
    String[] name = new String[4];  //[sede, ciclo, grupo, tripulante]
    Contacto db = new Contacto();
    String[][] est_datos = {{"id","int"}, {"Nombre", "str"}};
    String [] nom_tablas = {"sede", "ciclo", "grupo", "tripulante"};
    boolean existe;

    public void eliminarItem(int tipoTab, int id) {
        String sql = "DELETE FROM " + this.nom_tablas[tipoTab] + "\n";
        sql += "WHERE id = " + id + ";";
        this.db.SQLExec(sql);
    }

    public void actualizarTabla(int tipoTab, int id, String[][] info) {
        String sql = "UPDATE " + this.nom_tablas[tipoTab] +"\n";
        sql += "SET ";
        for (String [] item : info) {
            if (item[0].equals("id")) {
                sql += item[0] + " = " + item[1] + ",\n";
            } else {
                sql += "    " +  item[0] + " = '" + item[1] + "',\n";
            }
        }
        sql = sql.substring(0, sql.length()-2) + "\n";
        sql += "WHERE\n" + "    id = " + id + ";";
        this.db.SQLExec(sql);
    }

    public boolean accederObjeto(String nombre, int tipo, String tabName) {
        //¿Existe nombre de la sede?
        String[][] data = this.leer(tabName, false);
        boolean existe = false;
        for (String[] fila: data) {
            if (fila[1].equals(nombre)) {
                existe = true;
                this.name[tipo] = nombre;
            }
        }
        if (!existe) {
            this.name[tipo] = "";
        }
        this.existe = existe;
        return existe;
    }


    public void crearObjeto(String [][] datos, String tabName) {
        //Conexión con la base de datos y creación de tablas si no existen
        this.db.dbConnect();
        //Reconocer id máximo y si existen las tablas.
        this.crearTablas();
        String[][] data = this.leer(tabName, false);
        int id_max = 0;
        boolean existe = false;
        for (String[] fila: data) {
            int id_f = Integer.parseInt(fila[0]);
            if (id_f > id_max) {
                id_max = id_f;
            }
            if (datos[0][0].equals(fila[1])) {
                existe = true;
            }
        }
        id_max++;
        //Crear nueva sede
        String in_sql = "INSERT INTO " + tabName + " (";
        for (String[] info: this.est_datos) {
            in_sql += info[0] + ",";
        }
        in_sql = in_sql.substring(0,in_sql.length()-1);
        in_sql += ") VALUES(" + id_max + ",";
        for (int i = 1; i < this.est_datos.length; i++) {
            if (this.est_datos[i][1].equals("str")) {
                in_sql += "'" + datos[i-1][1] + "',";
            } else {
                in_sql += datos[i-1][1] + ",";
            }
        }
        in_sql = in_sql.substring(0,in_sql.length()-1) + ");";
        if (!existe) {
            this.db.SQLExec(in_sql);
        } else {
            System.out.println("¡El nombre " + datos[0][1] + " ya existe!");
        }
    }

    public String[][] leer(String nombre, boolean filtering) {
        String[][] info = this.db.SQLReturn("SELECT * FROM " + nombre, this.est_datos);
        if (this.name[0] != null && filtering) {
            info = this.filtrado(info, nombre);
        }
        return info;
    }

    private String[][] filtrado(String[][] raw, String tabName) {
        /*Operación de filtrado de información de acuerdo a:
         sede, ciclo, grupo y tripulante.

            Estructura:
                - Sede: [id, Nombre]
                - Ciclo: [id, Nombre, Sede]
                - Grupo: [id, Nombre, Sede, Ciclo]
                - Estudiante: [id, Nombre, email, ..., Sede, Ciclo, Grupo]
         */
        /*
        String[][] info = {};
        boolean primera = true;
        String[][] ref;
        for (String name : this.name) {
            if (name != null) {
                if (primera) {
                    primera = false;
                    ref = raw;
                } else {
                    ref = info;
                    info = new String[][] {};
                }
                for (String[] fila : ref) {
                    if (fila[fila.length-1].equals(name)) {
                        info = Arrays.copyOf(info, info.length+1);
                        info[info.length-1] = fila;
                    }
                }
            }
        }
         */
        String sql = "SELECT ";
        for (String[] est : this.est_datos) {
            sql += est[0] + ',';
        }
        sql = sql.substring(0, sql.length()-1) + " FROM " + tabName + " WHERE ";
        int cont = 0;
        for (String name : this.name) {
            if (name != null) {
                cont++;
            }
        }
        cont--;
        sql += this.nom_tablas[cont] + "= '" + this.name[cont] + "';";
        String[][] info = this.db.SQLReturn(sql, this.est_datos);
        return info;
    }

    private void crearTablas() {
        //Crear tablas si no existen
        String sql = "";
        for (int i = 0; i < this.nom_tablas.length; i++) {
            if (!this.nom_tablas[i].equals("tripulante")) {
                sql = "CREATE TABLE IF NOT EXISTS " + this.nom_tablas[i] + " (\n"
                        + "	id integer PRIMARY KEY,\n"
                        + "	Nombre text NOT NULL,\n";
            } else {
                sql = "CREATE TABLE IF NOT EXISTS " + this.nom_tablas[i] + " (\n"
                        + "	id integer PRIMARY KEY,\n"
                        + "	Nombre text NOT NULL,\n"
                        + "	Celular text NOT NULL,\n"
                        + "	Email text NOT NULL,\n";
            }
            //Completar SQL
            for (int j = 0; j< i; j++) {
                sql += "	" + this.nom_tablas[j] + " text NOT NULL,\n";
            }
            sql = sql.substring(0, sql.length()-2);
            sql += ");";
            this.db.SQLExec(sql);
        }
    }

}


