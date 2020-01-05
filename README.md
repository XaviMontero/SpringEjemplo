 
## Instalación
`Prueba` puede ser ejecutado como una aplicación Spring-Boot la cual requiere la instalación previa de Mysql.

### :coffee: Despliegue estándar



4. Instalar `Prueba`.
```bash
$ cd mediapp-backend-1
$ mvn clean package install
```

`Prueba` proporciona la base de datos gracias a `spring.jpa.hibernate.ddl-auto=update`.

 

 

## Documentación
### Swagger
Para acceder, debemos utilizar los usuarios indicados en la sección anterior.

http://localhost:8080/swagger-ui.html

### Postman
`Prueba` Puedes crear con el siguiente json

`Orden`
`  {
 	"idOrden":3,
  "examens": [
    {
      "idExamen": 1
    },
        {
      "idExamen": 2
    }
  ],
  "fechaEmision": "2017-05-14",
  "fechaEntrega": "2017-05-14",
 
  "medico": {
    
    "cedulaMedico": "0106079784" 
    },
  "paciente": {
    "cedula": "0106079783" 
  }
} `

## Bitácora

- V1: 2020-04-01, Primera versión.
 

## Autor
| [![](https://avatars3.githubusercontent.com/u/24358710?s=40&v=4)](https://github.com/xavimontero) |
|-|
| [@XaviMontero](https://github.com/xavimontero) |

 
