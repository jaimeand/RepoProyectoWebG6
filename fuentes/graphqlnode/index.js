
var express= require('express');
const {graphqlHTTP} = require('express-graphql');
var {buildSchema} = require('graphql');

var schema = buildSchema(`
    type Estudiante{
        id: Int
        nombre: String
        apellido: String
        edad: Int
        contacto: String
        carrera: String
        }

    type Proyecto{
        id: Int
        nombreProyecto: String
        objetivoEspecifico: String
        objetivoGeneral: String
        presupuesto : Int
        fechaInicial: String
        fechaFinal: String
        director: String
        estado: String
        avance: String
        }
    
    type Query{
        estudiantes: [Estudiante]
        estudiante(id: Int) : Estudiante
        proyectos: [Proyecto]
        proyecto(id: Int):Proyecto
        }

    type Mutation {
        addEstudiante(nombre: String, apellido: String,
            edad : Int, contacto: String, carrera: String):Estudiante
        addProyecto(
            nombreProyecto: String,
            objetivoEspecifico: String,
            objetivoGeneral: String,
            presupuesto : Int,
            fechaInicial: String,
            fechaFinal: String,
            director: String,
            estado: String,
            avance: String):Proyecto
    
        }
     
    
`);
//modify Estudiante, RemoveEstudiante

var estudiantes=[];
var proyectos =[];
var counter=1;
var counterp=1;
//funcion para resolver las peticiones

var root = {
    estudiantes: () => {return estudiantes; },
    proyectos : () => {return proyectos;},

    estudiante : (data) => {
        for (var i=0; i<estudiantes.length; i++)
            if (estudiantes[i].id == data.id)
                    return estudiantes[i];
        return null;
        },
    proyecto : (data) =>{
        for (var i=0;i< proyectos.length; i++)
            if (proyectos[i].id== data.id)
                return proyectos[i];
        return null;

        },

    addEstudiante: (data) => {
        var e={'id':counter, 'nombre':data.nombre,'apellido':data.apellido,
                'edad':data.edad,'contacto':data.contacto,'carrera':
                data.carrera};
        estudiantes.push ( e );
        counter++;
        return e;
        },
    addProyecto: (data) => {
        var p={'id':counterp, 'nombreProyecto':data.nombreProyecto,
                'objetivoEspecifico':data.objetivoEspecifico,
                'objetivoGeneral': data.objetivoGeneral,
                'presupuesto':data.presupuesto,'fechaInicial':data.fechaInicial,
                'fechaFinal':data.fechaFinal,'director':data.director,
                'estado':data.estado,'avance':data.avance};
        proyectos.push ( p );
        counterp++;
        return p;
        },

};

var app = express();
app.use('/graphql', graphqlHTTP({
    schema: schema,
    rootValue : root,
    graphiql : true
}));

app.listen(4000, () => console.log('Running a GraphQL API server at http://localhost:4000/graphql'));





