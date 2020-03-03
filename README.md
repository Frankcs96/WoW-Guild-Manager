# WOW GUILD MANAGER

![](screenshots/wowlogo.jpg)
<h4>Aplicación para la asignatura de programación la cual consistira en un programa de gestion de tu guild (Grupo de jugadores organizados por rangos los cuales se juntan para cumplir objetivos dentro del juego)
para el juego world of warcraft</h4>

## Base de datos

![](screenshots/db.jpg)

La base de datos consta de 4 tablas:

**user**: Esta tabla contiene los datos de los usuarios los cuales usaremos para el login. Solo se requiere de nombre y contraseña.

**guild**: Esta tabla contiene la informacion de la guild del usuario (un usuario solo puede tener una guild)
tambien tiene la FK del servidor al que pertenece.

**server**: Simple información sobre el servidor al que pertenece esa guild.

**player**: Aqui es donde guardaremos mas informacion ya que es donde vamos a realizar las acciones de crud.
Esta tabla contiene la información de todos los miembros que pertenecen a una guild.
La aplicacion nos permitira dar de alta, modificar y borrar jugadores de nuestra guild.

## Login

![](screenshots/login.jpg)

Para acceder a la aplicación necesitaremos estas registrados. Si intentamos acceder al index sin estar logeados nos mandara a la pagina de login.

![](screenshots/create.jpg)

Para la creación de una cuenta la aplicación tendra en cuenta que los dos campos de contraseña sean iguales y en el caso de que esto ocurra buscara si existe ya un usuario con ese nombre.



