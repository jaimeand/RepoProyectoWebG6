import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        String respuesta="";

        try {
            Cnx cnx = new Cnx();
            MongoCursor<Document> document= cnx.makeCnxToMongoDB();

            while (document.hasNext()) {
                ArrayList<Object> doc = new ArrayList<>(document.next().values());
                respuesta = respuesta +"nombre: "+ doc.get(1) +" Apellido: "+ doc.get(2) +
                        " Edad: "+ doc.get(3)+" correo: "+ doc.get(4)+"\n";
                /*respuesta = respuesta +"nombreProyecto: "+ doc.get(1) +" \nObjetivoEspecifico: "+ doc.get(2) +
                        " \nObjetivoGeneral: "+ doc.get(3)+" \npresupuesto: "+ doc.get(4)+" \ndirector: "
                        + doc.get(7)+ " \nEstado: "+ doc.get(8)+"\n";*/
                if(doc.get(1)== "James"){
                    System.out.println(respuesta);
                }
            }


        }catch(Exception exc){
            try {
                throw new Exception(exc.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        Estudiantes e1 = new Estudiantes ( "Juanito","perez","23","juanito12@gmail.com","3144353453","Ingenieria de sistemas");
//        estudiantesRepository.save(e1);
//
//        System.out.println("**************Exitoso");
//
//        List<Estudiantes> estudiantes = estudiantesRepository.findAll();
//
//        for(Estudiantes e: estudiantes){
//            System.out.println(e.toString());
//        }
//
//    }
}
