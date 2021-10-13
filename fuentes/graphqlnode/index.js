
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
    
    type Query{
        estudiantes: [Estudiante]
        estudiante(id: Int) : Estudiante
        }

    type Mutation {
        addEstudiante(nombre: String, apellido: String,
            edad : Int, contacto: String, carrera: String):Estudiante
    
        }



`);
//modify Estudiante, RemoveEstudiante

var estudiantes=[];
var counter=1;
//funcion para resolver las peticiones

var root = {
    estudiantes: () => {return estudiantes; },

    estudiante : (data) => {
        for (var i=0; i<estudiantes.length; i++)
            if (estudiantes[i].id == data.id)
                    return estudiantes[i];
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

};

var app = express();
app.use('/graphql', graphqlHTTP({
    schema: schema,
    rootValue : root,
    graphiql : true
}));

app.listen(4000, () => console.log('Running a GraphQL API server at http://localhost:4000/graphql'));





